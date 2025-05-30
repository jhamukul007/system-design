package com.system.design.list.cache.lru;

public class PairedDoublyLinkedList<K,V> {
    private K key;
    private V value;
    private PairedDoublyLinkedList<K, V> next;
    private PairedDoublyLinkedList<K, V> prev;

    public PairedDoublyLinkedList(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public PairedDoublyLinkedList<K, V> getNext() {
        return next;
    }

    public void setNext(PairedDoublyLinkedList<K, V> next) {
        this.next = next;
    }

    public PairedDoublyLinkedList<K, V> getPrev() {
        return prev;
    }

    public void setPrev(PairedDoublyLinkedList<K, V> prev) {
        this.prev = prev;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
