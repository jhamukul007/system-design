package com.system.design.message.broker;

public interface Consumer<T> {
    T consume(String topic) throws InterruptedException;
}
