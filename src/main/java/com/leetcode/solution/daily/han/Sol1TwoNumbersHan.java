package com.leetcode.solution.daily.han;


import java.util.HashMap;
import java.util.Map;

/**
 * @Description Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-22 0:44
 * @Param
 * @return
 */
public class Sol1TwoNumbersHan {
    public int[] isTwoNumbersSumEqualTarget(int[] nums, int target) {
        /**
         *  哈希表 映射，新建一个哈希表，存储 数组值 和下标，遍历判断 map是否含有target-nums[i]的key
         *
         */

        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("Two numbers solution is null!");
    }

    public  static void main(String[] args) {
        int[] nums = new int[]{9,8,5,10};
        int t = 18;
        int[] out = new Sol1TwoNumbersHan().isTwoNumbersSumEqualTarget(nums,t);

        for (int i : out) {
            System.out.println(i);
        }
    }
}
