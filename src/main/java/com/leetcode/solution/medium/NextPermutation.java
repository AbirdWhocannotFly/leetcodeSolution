package com.leetcode.solution.medium;

import com.leetcode.solution.util.PrintUtil;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列
 * https://leetcode-cn.com/problems/next-permutation/
 *
 * @author yangguang14
 * @date 2020/6/4.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,3,3};
        PrintUtil.printIntArray(nums);
        new NextPermutation().nextPermutation2(nums);
        PrintUtil.printIntArray(nums);
    }


    public void nextPermutation2(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            int curr = nums[i];

            for (int j = nums.length-1; j > i ; j--) {
                if (nums[j] > curr) {
                    index = index == -1 ? j : nums[index] > nums[j] ? j : index;
                }
            }
            if (index > -1) {
                swap(nums, i, index);
                //此时需要将i之后的数字按增序排列
                //此时i之后的数字是递减，只需要做翻转即可
                for (int m = i + 1, n = nums.length - 1; m <n; m++) {
                    swap(nums, m, n--);
                }
                return;
            }

        }

        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - i - 1);
        }
    }

}
