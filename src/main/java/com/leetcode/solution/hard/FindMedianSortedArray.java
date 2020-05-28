package com.leetcode.solution.hard;

/**
 * 4.寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 *
 * @author yangguang14
 * @date 2020/5/28.
 */
public class FindMedianSortedArray {
    /**
     * 两个数组中位数为合并后 length/2 位置或该位置与下一个位置平均值
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        //计算中位数index
        int k = (length1 + length2) / 2;
        //计算总数是否为单数
        if ((length1 + length2) % 2 == 1) {
            //单数只需要找出第k个数
            return findKthInArrays(nums1, nums2, k + 1);
        } else {
            //偶数需要计算出两个值并求平均值
            return (findKthInArrays(nums1, nums2, k) + findKthInArrays(nums1, nums2, k + 1)) / 2.0;
        }

    }

    /**
     * 寻找第k个数
     *
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    private double findKthInArrays(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        //记录两个数组的边界
        int first = 0, second = 0;

        while (true) {
            //剔除边界
            //如果first 或者second达到了边界
            if (first == length1) {
                //返回另一个数组中第 k（此k已经发生过变化）个数
                return nums2[second + k - 1];
            } else if (second == length2) {
                //反之
                return nums1[first + k - 1];
            }
            //出口
            if (k == 1) {
                return Math.min(nums1[first], nums2[second]);
            }

            //每个数组中挑选k的一半的做比较
            int half = k / 2;
            //计算index边界值，避免越界
            int indexFirst = Math.min(first + half - 1, length1 - 1);
            int indexSec = Math.min(second + half - 1, length2 - 1);
            //获取两个位置的值进行比较
            int pivotFirst = nums1[indexFirst];
            int pivotSec = nums2[indexSec];
            if (pivotFirst > pivotSec) {
                //说明 indexSec之前的数字全不符合
                //计算本轮剔除的数据量更新second 和k值
                k -= (indexSec - second + 1);
                second = indexSec + 1;
            } else {
                //反之
                k -= (indexFirst - first + 1);
                first = indexFirst + 1;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,1,3, 3};
        int[] nums2 = new int[]{1,1,3, 3};

        System.out.println(new FindMedianSortedArray().findMedianSortedArrays(nums1, nums2));

    }

}
