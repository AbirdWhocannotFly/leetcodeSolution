package com.leetcode.solution.daily;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 *
 * @author yangguang14
 * @date 2020/5/14.
 */
public class Solution136 {

    /**
     * 使用位运算特性
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        //或运算 A|A = A O|A = A 1|A= 1,与运算A&A = A O&A = 0 1|A= A,异或运算 A^A = 0 0^A = A
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,4};
        System.out.println(new Solution136().singleNumber(nums));
    }
}
