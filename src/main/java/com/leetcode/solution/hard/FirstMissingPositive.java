package com.leetcode.solution.hard;

/**
 * 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * @author yangguang14
 * @date 2020/5/31.
 */
public class FirstMissingPositive {
    /**
     * 索引映射
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        //遍历数组，查找是否存在1
        //如果存在，则可以将不能映射的数据填充为1，否则直接返回1
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else if (nums[i] < 1 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (count == 0) {
            return 1;
        }
        //遍历数组，将数组值映射到索引，置为负数
        for (int i = 0; i < nums.length; i++) {
            //在遍历时，取原值需要取绝对值映射索引
            int curr = Math.abs(nums[i]);
            //索引需要取余，0位置存储N
            int index = curr % nums.length;
            //置为负数
            nums[index] = -Math.abs(nums[index]);
        }
        //遍历数组，找出第一个正数(最后一个计算n)
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i % nums.length] > 0) {
                //对0索引还原为n
                return i;
            }
        }
        //如果数组中刚好为1-n，则返回n+1
        return nums.length + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, -1, 3, 1};
        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
    }
}
