package com.leetcode.solution.daily;

import com.leetcode.solution.structure.LRUCache;

/**
 * LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author yangguang14
 * @date 2020/5/25.
 */
public class Solution146 {


    public static void main(String[] args) {
        int capacity = 10;
        LRUCache obj = new LRUCache(capacity);
        int key = 1;
        int value = 1000;
        System.out.println(obj.get(key));
        obj.put(key, value);
        System.out.println(obj.get(key));
    }
}
