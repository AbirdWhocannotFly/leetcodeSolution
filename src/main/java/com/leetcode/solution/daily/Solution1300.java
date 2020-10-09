package com.leetcode.solution.daily;

import java.util.Arrays;

/**
 * 1300. 转变数组后最接近目标值的数组和
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 *
 * @author yangguang14
 * @date 2020/6/14.
 */
public class Solution1300 {

    /**
     * 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
     * 使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）
     *
     * @param arr
     * @param target
     * @return
     */
    public int findBestValue(int[] arr, int target) {

        int res = 0, abs = Integer.MAX_VALUE;
        Arrays.sort(arr);

        int[] sumDp = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sumDp[i] = (i > 0 ? sumDp[i - 1] : 0) + arr[i];
        }
        //二分找出左边界
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int midSum = sumDp[mid] + (arr.length - mid - 1) * arr[mid];
            int tempAbs = Math.abs(midSum - target);
            if (abs > tempAbs) {
                abs = tempAbs;
                res = arr[mid];

            }
            if (midSum > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //左右边界中继续二分确定位置
        int midSum = sumDp[left] + (arr.length - left - 1) * arr[left];
        if (midSum == target) {
            return arr[left];
        }
        int start = midSum < target ? arr[left] : 1;
        int index = midSum < target ? left + 1 : 0;
        int end = index > arr.length ? arr[arr.length - 1] : arr[index];
        int sumLeft = index == 0 ? 0 : sumDp[index-1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int tempSum = (sumLeft == 0 ? mid : sumLeft) + (arr.length - left - 1) * mid;
            int tempAbs = Math.abs(tempSum - target);
            if (abs > tempAbs || (abs == tempAbs && res > mid)) {
                abs = tempAbs;
                res = mid;
            }
            if (tempSum > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 9, 3};
        int target = 10;
        System.out.println(new Solution1300().findBestValue(arr, target));
    }
}
