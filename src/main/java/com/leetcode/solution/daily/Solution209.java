package com.leetcode.solution.daily;

/**
 * 209. 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 *
 * @author yangguang14
 * @date 2020/6/28.
 */
public class Solution209 {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，
     * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
     * 如果不存在符合条件的连续子数组，返回 0。
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int s = 11;
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(new Solution209().minSubArrayLen(s, nums));
    }
}
