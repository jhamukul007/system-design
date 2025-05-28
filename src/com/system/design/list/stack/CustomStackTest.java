package com.system.design.list.stack;

public class CustomStackTest {
    public static void main(String[] args) {
        Stack<String> stack = new StackUsingLinkedList<>();
        stack.push("Virat Kohli");
        stack.push("MS Dhoni");
        stack.push("Rohit Sharma");

        stack.display();
        System.out.println("-----------------------------");

        System.out.println("Size: " + stack.size());
        System.out.println("Top: " + stack.top());
        stack.pop();
        System.out.println("Top: " + stack.top());
        stack.push("Jack");
        stack.pop();
        stack.display();
    }
}
