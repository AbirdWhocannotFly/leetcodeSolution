package com.leetcode.solution.daily;

/**
 * 验证回文字符串 Ⅱ
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 *
 * @author yangguang14
 * @date 2020/5/19.
 */
public class Solution680 {
    public boolean validPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        //定义前后指针
        int start = 0, end = s.length() - 1;
        //遍历
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        //如果遍历完成，则符合条件
        if (start >= end) {
            return true;
        } else {
            //未遍历完成，前后忽略一个字符位，进行判断
            return validStr(s, start + 1, end) || validStr(s, start, end - 1);
        }

    }

    /**
     * 判断一个字符串从起始到结束位置是否为回文
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean validStr(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                break;
            }
        }
        return start >= end;

    }

    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println(new Solution680().validPalindrome(s));
    }
}
