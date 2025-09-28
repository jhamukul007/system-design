package com.system.design.message.broker;

public class ProducerImpl<T> implements Producer<T> {

    private final MessageBroker<T> messageBroker;

    public ProducerImpl(MessageBroker<T> messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void produce(String topic, T message) throws InterruptedException {
        messageBroker.publish(topic, message);
    }
}
