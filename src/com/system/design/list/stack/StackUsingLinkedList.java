package com.system.design.list.stack;

import com.system.design.utils.LinkedList;

import java.util.EmptyStackException;
import java.util.Optional;

public class StackUsingLinkedList<T> implements Stack<T> {
    private LinkedList<T> elements;
    private int size;

    public StackUsingLinkedList() {
        this.elements = new LinkedList<>(null);
        this.size = 0;
    }

    @Override
    public void push(T input) {
        LinkedList<T> newNode = new LinkedList<>(input);
        LinkedList<T> nextNode = elements.getNext();
        newNode.setNext(nextNode);
        elements.setNext(newNode);
        size++;
    }

    @Override
    public T top() {
        return Optional.ofNullable(elements.getNext()).map(LinkedList::getData).orElseThrow(() -> new EmptyStackException());
    }

    @Override
    public T pop() {
        Optional<LinkedList<T>> popedNode = Optional.ofNullable(elements.getNext());

        LinkedList<T> nextNode = popedNode.orElseThrow(() -> new EmptyStackException()).getNext();
        elements.setNext(nextNode);
        size--;
        return popedNode.get().getData();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void display() {
        LinkedList<T> current = elements.getNext();
        while (current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
