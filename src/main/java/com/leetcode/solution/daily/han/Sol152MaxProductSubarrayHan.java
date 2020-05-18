package com.leetcode.solution.daily.han;

import static java.lang.Math.*;

/**
 * @Description Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-18 21:08
 * @Param
 * @return
 */
public class Sol152MaxProductSubarrayHan {
        public int maxProduct(int[] arr){
            // 判断非空
            if (arr.length == 0) {
                return 0;
            }

            /**
             * 定义两个变量，分别存储以第i个数字结尾的子数组的乘积的最大值 和最小值， 因为如果i+1值为负，那么 乘积的最大值就会翻转
             * 最大值 和最小值，只能是 max*arr[i] min*arr[i], arr[i]中的最大值或者最小值
             */

            int min = arr[0];
            int max = arr[0];
            int res = arr[0];
            // 遍历数组
            for (int i = 1; i < arr.length; i++) {
                // 求最小值，需要用到max之前的值，
                int tmp = max;
                max = Math.max(max * arr[i], Math.max(min*arr[i], arr[i]));
                min = Math.min(min * arr[i], Math.min(tmp*arr[i], arr[i]));

                //res只存最大值
                res = Math.max(res,max);
            }

            return res;
    }


    public  static void main(String[] args){
            int[] num = new int[]{1,2,3,-2,5,4,0,9,8,-3,5,-7};

            System.out.println(new Sol152MaxProductSubarrayHan().maxProduct(num));
    }
}

