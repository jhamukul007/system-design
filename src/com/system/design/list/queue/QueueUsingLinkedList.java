package com.system.design.list.queue;

import com.system.design.utils.LinkedList;

import java.util.NoSuchElementException;

public class QueueUsingLinkedList<T> implements Queue<T> {
    private LinkedList<T> firstElement;
    private LinkedList<T> lastElement;
    private int size;

    public QueueUsingLinkedList() {
        this.firstElement = new LinkedList<>(null);
        this.lastElement = firstElement;
        this.size = 0;
    }

    @Override
    public void offer(T data) {
        LinkedList<T> newNode = new LinkedList<>(data);
        lastElement.setNext(newNode);
        lastElement = newNode;
        size++;
    }

    @Override
    public T poll() {
        LinkedList<T> dataNode = firstElement.getNext();
        if (dataNode == null) {
            throw new NoSuchElementException();
        }
        firstElement.setNext(dataNode.getNext());
        size--;
        return dataNode.getData();
    }

    @Override
    public T peek() {
        if (firstElement.getNext() == null) {
            throw new NoSuchElementException();
        }
        return firstElement.getNext().getData();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        LinkedList<T> current = firstElement.getNext();
        while (current != null) {
            System.out.print(current.getData() + " <- ");
            current = current.getNext();
        }
    }
}
