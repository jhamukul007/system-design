package com.system.design.list.cache.lru;

public interface Cache<K, V> {
    void put(K key, V value);
    V get(K key);
}
