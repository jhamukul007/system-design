package com.system.design.list.roundrobin;

import com.system.design.utils.LinkedList;

public class RoundRobinAlgorithm<T> {
    private LinkedList<T> elements;
    private LinkedList<T> tail;

    private LinkedList<T> current;

    public void insert(T data) {
        LinkedList<T> newNode = new LinkedList<>(data);
        if (elements == null) {
            this.elements = newNode;
            this.elements.setNext(elements);
            this.tail = elements;
            this.current = elements;
            return;
        }
        newNode.setNext(elements);
        tail.setNext(newNode);
        tail = tail.getNext();
    }

    public T get() {
        if (this.current == null) {
            return null;
        }
        LinkedList<T> node = current;
        current = current.getNext();
        return node.getData();
    }

}
