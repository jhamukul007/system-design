package com.system.design.message.broker;

public class SimpleMessage extends Message {
    @Override
    public int compareTo(Message other) {
        return this.getPriority() - other.getPriority();
    }
}
