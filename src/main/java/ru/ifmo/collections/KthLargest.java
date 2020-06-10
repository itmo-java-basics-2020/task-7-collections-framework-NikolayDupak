package ru.ifmo.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private Queue<Integer> heap;

    public KthLargest(int k, int[] numbers) {
        heap = new PriorityQueue<>();
        for (int number : numbers) {
            heap.add(number);
        }

        while (heap.size() != k) {
            heap.remove();
        }
    }

    public int add(int val) {
        if (val > heap.element()) {
            heap.remove();
            heap.add(val);
        }
        return heap.element();
    }

}