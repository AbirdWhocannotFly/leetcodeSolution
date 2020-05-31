package com.leetcode.solution.hard;

/**
 * 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author yangguang14
 * @date 2020/5/31.
 */
public class RegexIsMatch {
    /**
     * 可用动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        //处理边界，p为空
        if (p.length() == 0) {
            return s.isEmpty();
        }
        //判断第一个字符是否匹配
        boolean first = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            //需要判断第一个字符相等的情况下当前字符串截取一个字符后是否与正则匹配
            boolean anyTimesMatch = first && isMatch(s.substring(1), p);
            //并且需要判断当前字符与正则截取两个字符后是否匹配
            boolean anyTimesNotMatch = isMatch(s, p.substring(2));
            return anyTimesMatch || anyTimesNotMatch;
        } else {
            //判断第一个字符相等的情况下，各截取一个字符是否匹配
            return first && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String p = ".*";

        System.out.println(new RegexIsMatch().isMatch(s,p));
    }
}
