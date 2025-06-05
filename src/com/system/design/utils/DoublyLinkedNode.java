package com.system.design.utils;

public class DoublyLinkedNode<T> {
    private T data;
    private DoublyLinkedNode previous;
    private DoublyLinkedNode next;

    public DoublyLinkedNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoublyLinkedNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedNode previous) {
        this.previous = previous;
    }

    public DoublyLinkedNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedNode next) {
        this.next = next;
    }
}
