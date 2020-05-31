package com.leetcode.solution.hard;

import java.util.Arrays;

/**
 * 不同的子序列
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * @author yangguang14
 * @date 2020/5/30.
 */
public class NumDistinct115 {

    /**
     * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
     *
     * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        //动态规划
        int[][] dp = new int[t.length()+1][s.length()+1];
        //如果t为空串，则为1；s为空串为0不需要处理
        Arrays.fill(dp[0], 1);
        //遍历
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (t.charAt(i-1) == s.charAt(j-1)){
                    //如果字符相等，则可以选择要或者不要
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    //只能不要
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()][s.length()];
    }

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(new NumDistinct115().numDistinct(s,t));
    }
}
