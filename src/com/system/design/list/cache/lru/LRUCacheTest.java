package com.system.design.list.cache.lru;

public class LRUCacheTest {

    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);

        Integer value = cache.get(1);
        System.out.println(value == null ? -1 : value);

        cache.put(3, 3);
        value = cache.get(2);
        System.out.println(value == null ? -1 : value);

        cache.put(4, 4);
        value = cache.get(1);
        System.out.println(value == null ? -1 : value);

        value = cache.get(3);
        System.out.println(value == null ? -1 : value);

        value = cache.get(4);
        System.out.println(value == null ? -1 : value);
    }

}
