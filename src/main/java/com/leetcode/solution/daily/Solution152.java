package com.leetcode.solution.daily;

/**
 * 乘积最大子数组
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 *
 * @author yangguang14
 * @date 2020/5/18.
 */
public class Solution152 {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //记录最大值结果
        int max = Integer.MIN_VALUE;
        //记录当前下标最大乘积
        int imax = 1;
        //记录当前下标最小乘积
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            //判断当前数是否>0，如果大于0.直接计算；如果小于0，需要交换最大与最小
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            //记录当前位置最大值
            imax = Math.max(imax * nums[i], nums[i]);
            //更新全局最大值
            max = Math.max(imax, max);
            //记录当前位置最小值
            imin = Math.min(imin * nums[i], nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -5, -2, -4, 3};
        System.out.println(new Solution152().maxProduct(nums));
    }
}
