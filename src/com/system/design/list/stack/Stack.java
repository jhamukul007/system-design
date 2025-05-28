package com.system.design.list.stack;

public interface Stack<T> {
    void push(T input);
    T top();
    T pop();
    int size();
    void display();
}
