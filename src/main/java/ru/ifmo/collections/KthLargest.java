package ru.ifmo.collections;

import java.util.Objects;
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
    private final Queue<Integer> queue;
    private final int k;

    public KthLargest(int k, int[] numbers) {
        if (k > numbers.length || k < 0) {
            throw new IllegalArgumentException("k cannot be out of array's bound");
        }
        this.queue = new PriorityQueue<>(k);
        this.k = k;
        for (int number : numbers) {
            add(number);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
        } else if (Objects.requireNonNull(queue.peek()).compareTo(val) < 0) {
            queue.poll();
            queue.add(val);
        }
        return Objects.requireNonNull(queue.peek());
    }
}