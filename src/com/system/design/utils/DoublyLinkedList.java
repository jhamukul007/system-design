package com.system.design.utils;

public class DoublyLinkedList<T> {
    private T data;
    private DoublyLinkedList previous;
    private DoublyLinkedList next;

    public DoublyLinkedList(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedList getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedList previous) {
        this.previous = previous;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setNext(DoublyLinkedList next) {
        this.next = next;
    }
}
