package com.system.design.message.broker;

public interface Producer<T> {
    void produce(String topic, T message) throws InterruptedException;
}
