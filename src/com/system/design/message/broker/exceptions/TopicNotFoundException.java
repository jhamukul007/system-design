package com.system.design.message.broker.exceptions;

public class TopicNotFoundException extends MessageBrokerException{
    public TopicNotFoundException() {
    }

    public TopicNotFoundException(String message) {
        super(message);
    }
}
