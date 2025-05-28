package com.system.design.list.queue;

public interface Queue<T> {
    void offer(T data);
    T poll();

    T peek();
    int size();

    void print();
}