package com.system.design.list.cache.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> implements Cache<K, V> {
    private final PairedDoublyLinkedList<K, V> leastUsedElement;
    private final PairedDoublyLinkedList<K, V> frequentUsedElement;
    private final Map<K, PairedDoublyLinkedList<K, V>> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.leastUsedElement = new PairedDoublyLinkedList<>(null, null);
        this.frequentUsedElement = new PairedDoublyLinkedList<>(null, null);
        leastUsedElement.setNext(frequentUsedElement);
        frequentUsedElement.setPrev(leastUsedElement);
    }

    public void put(K key, V value) {
        PairedDoublyLinkedList<K, V> node = cache.get(key);
        if (node != null) {

            // NOTE: If the key already exists, update its value, move the node to the most recently used position
            node.setValue(value);
            delete(node);
            insert(node);
        } else {
            if (cache.size() == capacity) {
                // NOTE: evict the node that is least used, Delete the node from the front of linked list

                PairedDoublyLinkedList<K, V> evictedElement = evict();
                if (evictedElement != null) {
                    // NOTE: remove the node from cache
                    cache.remove(evictedElement.getKey());
                }
            }
            // NOTE: Insert new key value pair in the cache
            node = new PairedDoublyLinkedList<>(key, value);
            insert(node);
            cache.put(key, node);
        }
    }

    // NOTE: Get and add node to the tail of linked list
    public V get(K key) {
        PairedDoublyLinkedList<K, V> node = cache.get(key);
        if (node == null) {
            return null;
        }
        delete(node);
        insert(node);
        return node.getValue();
    }

    // NOTE: Insert node in the tail of linked list
    private void insert(PairedDoublyLinkedList<K, V> node) {
        PairedDoublyLinkedList<K, V> frequentUsed = frequentUsedElement.getPrev();
        frequentUsed.setNext(node);
        node.setPrev(frequentUsed);
        node.setNext(frequentUsedElement);
        frequentUsedElement.setPrev(node);
    }

    /**
     * Evict node from head of linked list that is leastUsedElement
     *
     * @return
     */
    private PairedDoublyLinkedList<K, V> evict() {
        PairedDoublyLinkedList<K, V> leastUsed = leastUsedElement.getNext();
        if (leastUsed != null) {
            PairedDoublyLinkedList<K, V> nextElement = leastUsed.getNext();
            leastUsedElement.setNext(nextElement);
            if (nextElement != null) {
                nextElement.setPrev(leastUsedElement);
            }

            leastUsed.setNext(null);
            leastUsed.setPrev(null);
        }
        return leastUsed;
    }

    /**
     * Delete node
     *
     * @param node
     */
    private void delete(PairedDoublyLinkedList<K, V> node) {
        PairedDoublyLinkedList<K, V> prev = node.getPrev();
        PairedDoublyLinkedList<K, V> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
    }

}
