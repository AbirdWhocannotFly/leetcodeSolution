package com.leetcode.solution.hard;

/**
 * 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 *
 * @author yangguang14
 * @date 2020/5/28.
 */
public class LongestValidParentheses {

    /**
     * 动态规划
     * 其他思路：栈（栈顶存放第一个不可能的下标，左括号入栈，右括号出栈）
     * 双指针（left-right 左右两次遍历）
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        //定义结果变量
        int max = 0;
        //定义dp数组，存储当前位置匹配的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //从第二个字符开始遍历数组，如果是左括号不需要计算
            if (s.charAt(i) == ')') {
                //判断前一位是否为左括号
                if (s.charAt(i - 1) == '(') {
                    //则i和i-1成对，当前位置匹配长度为dp[i-2]+2;
                    dp[i] = (i - 2 > 0 ? dp[i - 2] : 0) + 2;
                    //更新最大值
                    max = Math.max(max, dp[i]);
                } else {
                    //根据前一位的长度进行处理，计算跳过前一位的长度后，是否能匹配
                    int index = i - dp[i - 1] - 1;
                    if (index >= 0 && s.charAt(index) == '(') {
                        //匹配后还需要计算是否串联上index-1的位置
                        dp[i] = dp[i - 1] + 2 + ((index - 1) > 0 ? dp[index - 1] : 0);
                        //更新最大值
                        max = Math.max(max, dp[i]);
                    }
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(new LongestValidParentheses().longestValidParentheses(str));
    }
}
