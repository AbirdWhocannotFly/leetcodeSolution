package com.leetcode.solution.daily;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author yangguang14
 * @date 2020/6/15.
 */
public class Solution14 {

    public String longestCommonPrefix(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        String temp = null;
        for (int i = 0; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                temp = strs[i];
            }
            minLength = Math.min(minLength, strs[i].length());

        }
        for (int i = 0; i < minLength; i++) {
            char ch = temp.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                char tempCh = strs[j].charAt(i);
                if (tempCh != ch) {
                    return temp.substring(0, i);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
        strs = new String[]{"dog","racecar","car"};
        System.out.println(new Solution14().longestCommonPrefix(strs));
    }
}
