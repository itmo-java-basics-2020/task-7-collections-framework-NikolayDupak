package ru.ifmo.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    LinkedList<Integer> listNumbers = new LinkedList();
    int k;

    public KthLargest(int k, int[] numbers) {
        this.k = k - 1;
        for (int number : numbers) {
            this.listNumbers.add(number);
        }

    }

    public int add(int val) {
        listNumbers.add(val);
        return KthElement();
    }

    private int KthElement() {
        Collections.sort(listNumbers);
        return listNumbers.get(this.k);
    }
}