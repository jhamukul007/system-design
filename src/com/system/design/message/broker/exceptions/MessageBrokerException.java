package com.system.design.message.broker.exceptions;

public class MessageBrokerException extends RuntimeException{

    public MessageBrokerException() {
    }

    public MessageBrokerException(String message) {
        super(message);
    }
}
