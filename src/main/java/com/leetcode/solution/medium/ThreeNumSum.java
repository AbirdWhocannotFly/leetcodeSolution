package com.leetcode.solution.medium;

import com.leetcode.solution.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author yangguang14
 * @date 2020/6/12.
 */
public class ThreeNumSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //处理边界
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            //双指针遍历
            while (left < right) {


                int sum = nums[i] + nums[left] + nums[right];
                //将符合条件的值加入
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    //去掉重复值
                    while (left < right - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right - 1 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //移动指针
                    right--;
                    left++;
                } else if (sum > 0) {
                    //如果比0大，右指针左移
                    right--;
                } else {
                    left++;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        PrintUtil.printListList(new ThreeNumSum().threeSum(nums));

    }
}
