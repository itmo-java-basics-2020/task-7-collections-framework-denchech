package ru.ifmo.collections;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private final Map<Integer, Boolean> map;

    public FirstUnique(int[] numbers) {
        this.map = new LinkedHashMap<>(numbers.length, DEFAULT_LOAD_FACTOR, false);
        for (int number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        if (map.containsKey(value)) {
            map.replace(value, true);
        } else {
            map.put(value, false);
        }
    }
}
