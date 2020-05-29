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
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private static final float MAX_LOAD_FACTOR = 1.0f;

    private final int capacity;

    public LruCache(int capacity) {
        super(capacity, MAX_LOAD_FACTOR, false);
        this.capacity = capacity;
    }

    @Override
    public V get(Object key) {
        V value = super.remove(key);
        if (value != null) {
            super.put((K) key, value);
        }
        return value;
    }

    @Override
    public V put(K key, V value) {
        super.remove(key);
        return super.put(key, value);
    }

    public int elements() {
        return size();
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}