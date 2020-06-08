package com.leetcode.solution.daily;

import com.leetcode.solution.util.PrintUtil;

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/problems/product-of-array-except-self/
 *
 * @author yangguang14
 * @date 2020/6/4.
 */
public class Solution238 {

    /**
     * 开辟额外空间存储前缀与后缀
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        //初始化前后数组第一位
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            //正序计算前缀
            left[i] = left[i - 1] * nums[i - 1];
            //逆序计算后缀
            right[nums.length - i - 1] = right[nums.length - i] * nums[nums.length - i];
        }
        //计算结果
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        PrintUtil.printIntArray(new Solution238().productExceptSelf(nums));
        PrintUtil.printIntArray(new Solution238().productExceptSelf2(nums));
    }

    /**
     * 不开辟额外空间
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {

        int[] left = new int[nums.length];
        //初始化前后数组第一位
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            //正序计算前缀
            left[i] = left[i - 1] * nums[i - 1];
            //逆序计算后缀
        }
        //计算结果
        //定义后缀变量
        int r = 1;
        //最后一个位置的前缀即自身结果
        for (int i = left.length - 2; i >= 0; i--) {
            r = r * nums[i+1];
            left[i] = left[i] * r;
        }
        return left;
    }
}
