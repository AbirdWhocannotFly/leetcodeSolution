package com.leetcode.solution.daily;

/**
 * 打家劫舍
 * https://leetcode-cn.com/problems/house-robber/
 *
 * @author yangguang14
 * @date 2020/5/29.
 */
public class Solution189 {
    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length ==0){
            return 0;
        }
        //定义dp数组(此处只使用了dp[i-1]及dp[i-2],可优化为使用两个变量存储。空间复杂度O(n)->O(1))
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            //如果当天做选择，则当前可获利
            int choose = (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i];
            //如果当天不做选择，则当前可获利
            int noChoose = i - 1 >= 0 ? dp[i - 1] : 0;
            //存储两种方案最大值
            dp[i] = Math.max(choose, noChoose);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(new Solution189().rob(nums));
    }
}
