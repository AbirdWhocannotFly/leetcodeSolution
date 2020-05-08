package com.leetcode.solution.daily;

/**
 * @author yangguang14
 * @date 2020/5/8.
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int length = getLength(dp, i - 1, j - 1);
                    if (length == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = calLength(matrix, i, j, length);
                    }
                    maxLength = Math.max(dp[i][j], maxLength);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[i].length; i1++) {
                System.out.print(dp[i][i1]);
            }
            System.out.println();
        }
        return maxLength * maxLength;
    }

    private int calLength(char[][] matrix, int i, int j, int length) {
        int rowLength = 0;
        int colLength = 0;
        for (int row = i; row >= i - length; row--) {
            if (matrix[row][j] == '1') {
                rowLength++;
            }else {
                break;
            }

        }
        for (int col = j; col >= j - length; col--) {
            if (matrix[i][col] == '1') {
                colLength++;
            }else {
                break;
            }
        }

        return Math.min(rowLength, colLength);
    }

    private int getLength(int[][] dp, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {{'0','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0'},{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1'},{'1','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1'},{'1','0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0'},{'0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1'},{'1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},{'0','1','1','0','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','0','1'},{'1','1','1','1','1','1','1','1','0','1','1','0','1','1','0','1','1','1','1'},{'1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','0','1','1','1'}};
        System.out.println(new Solution221().maximalSquare(matrix));
    }
}
