package com.system.design.list.queue;


public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueUsingLinkedList<>();
        queue.offer(1);
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        queue.offer(2);
        queue.offer(3);
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
        queue.print();

        queue.poll();
        queue.print();
        System.out.println("Size: " + queue.size());
        System.out.println("Peek: " + queue.peek());
    }
}
