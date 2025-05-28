package com.system.design.utils;

public class LinkedList<T> {
    private T data;
    private LinkedList<T> next;

    public LinkedList(T data) {
        this.data = data;
    }

    public void setNext(LinkedList<T> next) {
        this.next = next;
    }

    public LinkedList<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }
}
