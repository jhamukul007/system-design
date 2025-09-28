package com.system.design.message.broker;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;

public abstract class Message implements Comparable<Message> {
    private String message;
    private Map<String, Object> headers;
    private Date sentTime;
    // 0 to 10 : 0 is highest and 10 is lowest
    private int priority;

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getHeaders() {
        return headers;
    }

    public Date getSentTime() {
        return sentTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaders(Map<String, Object> headers) {
        this.headers = headers;
    }

    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", headers=" + headers +
                ", sentTime=" + sentTime +
                '}';
    }
}
