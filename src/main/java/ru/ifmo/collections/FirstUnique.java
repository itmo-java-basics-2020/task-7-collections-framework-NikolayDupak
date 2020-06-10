package ru.ifmo.collections;

import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */

public class FirstUnique {
    private Map<Integer, Integer> map;
    private Queue<Integer> queue;

    public FirstUnique(int[] numbers) {
        map = new HashMap<>();
        queue = new ArrayDeque<>();
        for (int number : numbers) {
            this.add(number);
        }
    }

    public int showFirstUnique() {
        while (!queue.isEmpty() && map.get(queue.element()) > 1) {
            queue.remove();
        }
        return (queue.isEmpty() ? -1 : queue.element());
    }

    public void add(int value) {
        queue.add(value);
        if (map.get(value) != null) {
            map.put(value, map.get(value) + 1);
            return;
        }

        map.put(value, 1);
    }
}
