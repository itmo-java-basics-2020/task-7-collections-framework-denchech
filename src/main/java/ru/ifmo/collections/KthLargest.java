package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final List<Integer> list;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        if (k > numbers.length || k < 0) {
            throw new IllegalArgumentException("k cannot be out of array's bound");
        }
        this.list = Arrays.stream(numbers).boxed().collect(Collectors.toCollection(ArrayList::new));
        this.list.sort(Collections.reverseOrder());
        this.k = k;
    }

    public int add(int val) {
        insert(val);
        return list.get(k - 1);
    }

    private void insert(int value) {
        int position = Collections.binarySearch(list, value, Collections.reverseOrder());
        if (position < 0) {
            list.add(-position - 1, value);
        } else {
            list.add(position, value);
        }
    }
}