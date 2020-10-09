package com.leetcode.solution.daily;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author yangguang14
 * @date 2020/6/13.
 */
public class Solution70 {

    /**
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int pre = 1;
        int ppre = 1;
        for (int i = 0; i < n; i++) {
            pre = i - 1 >= 0 ? pre : 1;
            ppre = i - 2 >= 0 ? ppre : (i > 0 ? 1 : 0);
            int curr = pre + ppre;
            ppre = pre;
            pre = curr;
        }
        return pre;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution70().climbStairs(n));
    }
}
