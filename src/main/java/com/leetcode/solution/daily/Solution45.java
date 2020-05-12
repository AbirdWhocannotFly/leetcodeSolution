package com.leetcode.solution.daily;

/**
 * 跳跃游戏 II
 * https://leetcode-cn.com/problems/jump-game-ii/
 *
 * @author yangguang14
 * @date 2020/5/12.
 */
public class Solution45 {

    public int jump(int[] nums) {
        //边界值
        if (nums.length == 1) {
            return 0;
        }

        //记录次数
        int step = 1;
        //记录当前可达最大边界
        int max = nums[0];
        //下一步可达最大边界
        int nextMax = nums[0];
        //数组边界
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            //如果已经可达边界，结束循环
            if (max > length - 2) {
                break;
            }
            //如果超过当前步骤可达边界，更新步数及下一轮次最大可达
            if (i > max) {
                step++;
                max = nextMax;
            }
            //更新新的边界
            nextMax = Math.max(nextMax, i + nums[i]);

        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(new Solution45().jump(nums));
    }
}
