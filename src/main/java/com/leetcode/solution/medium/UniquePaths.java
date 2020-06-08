package com.leetcode.solution.medium;

import java.util.Arrays;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 *
 * @author yangguang14
 * @date 2020/6/5.
 */
public class UniquePaths {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）
     *
     * @param m 列
     * @param n 行
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[n][m];
        Arrays.fill(dp[0],1);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] ;
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7,3));
    }
}
