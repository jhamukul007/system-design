package com.system.design.message.broker.exceptions;

public class InvalidInputException extends MessageBrokerException{
    public InvalidInputException() {
    }

    public InvalidInputException(String message) {
        super(message);
    }
}
