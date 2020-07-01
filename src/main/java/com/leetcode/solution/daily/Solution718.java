package com.leetcode.solution.daily;

/**
 * 最长重复子数组
 * @author yangguang14
 * @date 2020/7/1.
 */
public class Solution718 {

    public int findLength(int[] numsA, int[] numsB) {
        int res = 0;
        int[][] dp = new int[numsA.length + 1][numsB.length + 1];
        for (int i = numsA.length - 1; i >= 0; i--) {
            for (int j = numsB.length - 1; j >= 0; j--) {
                if (numsA[i] == numsB[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res;
    }
}
