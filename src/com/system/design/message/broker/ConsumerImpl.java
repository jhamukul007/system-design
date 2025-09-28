package com.system.design.message.broker;

public class ConsumerImpl<T> implements Consumer<T> {
    private final MessageBroker<T> messageBroker;

    public ConsumerImpl(MessageBroker<T> messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public T consume(String topic) throws InterruptedException {
        return messageBroker.consume(topic);
    }
}
