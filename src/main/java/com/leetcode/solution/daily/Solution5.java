package com.leetcode.solution.daily;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author yangguang14
 * @date 2020/5/21.
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        //定义起始坐标，及当前最大回文串长度
        int start = 0, end = 0, len = 1;
        //遍历数组，
        for (int i = 0; i < s.length() - 1; i++) {
            //查找以当前元素为中心的回文
            int len1 = getLength(s, i, i);
            //查找以当前元素同为中心的回文长度
            int len2 = getLength(s, i, i + 1);
            //比较，当前元素的最长回文长度为其中较大值
            int currlen = Math.max(len1, len2);
            //如果比当前记录最大值大则更新起始坐标
            if (currlen > len) {
                start = i - (currlen - 1) / 2;
                end = i + currlen / 2;
                len = currlen;
            }
        }
        return s.substring(start, end + 1);
    }

    public int getLength(String s, int l, int r) {

        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}
