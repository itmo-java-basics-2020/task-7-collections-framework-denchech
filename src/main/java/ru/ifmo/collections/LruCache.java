package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents LRU cache with fixed maximum capacity.
 * <p>
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 * <p>
 * This class should not have any other public methods.
 * <p>
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private static final float MAX_LOAD_FACTOR = 1.0f;

    private final int capacity;
    private final Map<K, V> cache;

    public LruCache(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity + 1, MAX_LOAD_FACTOR, false);
    }

    public V get(K key) {
        if (cache.containsKey(key)) {
            V value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        } else {
            return null;
        }
    }

    public void put(K key, V value) {
        removeOldestIfRequired();
        cache.put(key, value);
    }

    public int elements() {
        return cache.size();
    }

    private void removeOldestIfRequired() {
        if (cache.size() >= capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
    }
}