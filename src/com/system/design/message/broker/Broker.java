package com.system.design.message.broker;

public interface Broker<T> {
    void publish(String topic, T message) throws InterruptedException;
    T consume(String topic) throws InterruptedException;
    void registerTopic(String topic);
    void removeTopic(String topic);

    void registerDLQ(String topic);
    void removeDLQ(String topic);
}
