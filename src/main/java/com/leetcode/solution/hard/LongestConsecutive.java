package com.leetcode.solution.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 128 最长连续序列
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 *
 * @author yangguang14
 * @date 2020/5/31.
 */
public class LongestConsecutive {
    /**
     * 暴力法，排序后遍历
     * 时间复杂度要求O(n)，考虑增加空间来达成
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;
        //定义hashset，完成数据存储
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            //如果set中不包含当前值的前一位数字，说明是个新的起点
            //开始计算以当前值为起点的最长连续序列
            if (!set.contains(nums[i] - 1)) {
                int next = nums[i] + 1;
                int count = 1;
                //如果有下一个值
                while (set.contains(next)) {
                    //继续找下一个
                    next++;
                    count++;
                }
                //遍历完成，统计结果值
                res = Math.max(res, count);

            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutive().longestConsecutive(nums));
    }
}
