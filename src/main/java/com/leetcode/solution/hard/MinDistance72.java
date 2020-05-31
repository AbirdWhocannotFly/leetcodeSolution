package com.leetcode.solution.hard;

/**
 * 编辑距离
 * https://leetcode-cn.com/problems/edit-distance/
 *
 * @author yangguang14
 * @date 2020/5/30.
 */
public class MinDistance72 {

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        //定义dp数组
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //初始化dp,其中一个为空串，则生产一样的串只能删除长串或增加空串
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        //遍历串
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                //word1执行删除
                int del = dp[i - 1][j] + 1;
                //word1执行添加
                int insert = dp[i][j - 1] + 1;
                //删除一个字符，增加一个字符，替换
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //如果当前字符相等。不需替换
                    dp[i][j] = Math.min(Math.min(del, insert), dp[i - 1][j - 1]);
                } else {
                    //如果当前字符相等。替换
                    dp[i][j] = Math.min(Math.min(del, insert), dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new MinDistance72().minDistance(word1, word2));
    }
}
