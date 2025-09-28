package com.system.design.message.broker;

import com.system.design.message.broker.exceptions.TopicNotFoundException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

import static java.lang.String.format;

public class MessageBroker<T> implements Broker<T> {

    private final Map<String, PriorityBlockingQueue<T>> topicQueueMapper;
    private final Map<String, PriorityBlockingQueue<T>> topicDLQMapper;

    public MessageBroker() {
        // to avoid currency risk using concurrent hash map
        this.topicQueueMapper = new ConcurrentHashMap<>();
        this.topicDLQMapper = new ConcurrentHashMap<>();
    }

    @Override
    public void publish(String topic, T message) throws InterruptedException {
        PriorityBlockingQueue<T> queue = topicQueueMapper.get(topic);
        queue = null;
//        if (queue == null) {
//            throw new TopicNotFoundException(format("Topic with name %s not found", topic));
//        }
        try {
            queue.put(message);
        } catch (Exception e) {
            System.out.println("Publish got failed. Adding message to DLQ");
            publishToDLQ(topic, message);
        }
    }

    @Override
    public T consume(String topic) throws InterruptedException {
        PriorityBlockingQueue<T> queue = topicQueueMapper.get(topic);
        if (queue == null) {
            throw new TopicNotFoundException(format("Topic with name %s not found", topic));
        }
        return queue.take();
    }

    @Override
    public void registerTopic(String topic) {
        PriorityBlockingQueue<T> queue = topicQueueMapper.get(topic);
        if (queue == null) {
            topicQueueMapper.put(topic, new PriorityBlockingQueue<>());
        }

    }

    @Override
    public void removeTopic(String topic) {
        topicQueueMapper.remove(topic);
    }

    @Override
    public void registerDLQ(String topic) {
        PriorityBlockingQueue<T> queue = topicDLQMapper.get(topic);
        if (queue == null) {
            topicDLQMapper.put(topic, new PriorityBlockingQueue<>());
        }
    }

    @Override
    public void removeDLQ(String topic) {
        topicDLQMapper.remove(topic);
    }

    private void publishToDLQ(String topic, T message) {
        PriorityBlockingQueue<T> queue = topicDLQMapper.get(topic);
        if (queue == null) {
            throw new TopicNotFoundException(format("Topic with name %s not found", topic));
        }
        queue.put(message);
    }
}
