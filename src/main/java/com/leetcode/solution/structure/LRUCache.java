package com.leetcode.solution.structure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yangguang14
 * @date 2020/5/25.
 */
public class LRUCache extends LinkedHashMap<Integer,Integer> {


    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
