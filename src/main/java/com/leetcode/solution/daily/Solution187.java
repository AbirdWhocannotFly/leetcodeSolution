package com.leetcode.solution.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  重复的DNA序列
 *  https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @author yangguang14
 * @date 2020/5/25.
 */
public class Solution187 {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> contents = new HashSet<String>();
        Set<String> res = new HashSet<String>();

        for (int i = 0; i < s.length()-9; i++) {
            String temp = s.substring(i,i+10);
            if (contents.contains(temp)){
                res.add(temp);
            }else {
                contents.add(temp);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new Solution187().findRepeatedDnaSequences(s));

    }
}
