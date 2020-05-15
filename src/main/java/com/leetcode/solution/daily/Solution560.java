package com.leetcode.solution.daily;

/**
 * 和为K的子数组
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * @author yangguang14
 * @date 2020/5/15.
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
//                    System.out.println(i + "---" + j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int k = 2;
        System.out.println(new Solution560().subarraySum(nums, k));
        nums = new int[]{1, 1, 1, 4, 1, 2, 3, 1, 1, 2, 1};
        k = 5;
        System.out.println(new Solution560().subarraySum(nums, k));
    }
}
