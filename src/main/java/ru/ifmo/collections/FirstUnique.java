package ru.ifmo.collections;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final Set<Integer> set;

    public FirstUnique(int[] numbers) {
        this.set = new LinkedHashSet<>();
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        return set.iterator().hasNext() ? set.iterator().next() : -1;
    }

    public void add(int value) {
        if (set.contains(value)) {
            set.remove(value);
        } else {
            set.add(value);
        }
    }
}
