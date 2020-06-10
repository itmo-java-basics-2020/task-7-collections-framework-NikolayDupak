package ru.ifmo.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

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
    HashMap<K, V> hashMap = new HashMap();
    LinkedList<K> linkedList = new LinkedList<>();
    int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
    }

    public V get(K key) {
        if (hashMap.get(key) != null) {
            linkedList.remove(key);
            linkedList.add(key);
        }
        return hashMap.get(key);
    }

    public void put(K key, V value) {
        if (hashMap.size() >= capacity) {
            K removeKey = linkedList.getFirst();
            linkedList.remove(removeKey);
            hashMap.remove(removeKey);

        }
        hashMap.put(key, value);
        linkedList.add(key);
    }

    public int elements() {
        return hashMap.size();
    }
}