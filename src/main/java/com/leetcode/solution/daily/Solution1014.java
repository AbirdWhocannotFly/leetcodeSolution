package com.leetcode.solution.daily;

/**
 * 1014. 最佳观光组合
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 *
 * @author yangguang14
 * @date 2020/6/17.
 */
public class Solution1014 {

    public int maxScoreSightseeingPair(int[] arr) {

        int pre = 0;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //计算当前位置收益
            int temp = arr[pre] + arr[i] - i + pre;
            max = Math.max(max, temp);
            //判断继续选pre，不选择i的收益
            temp = arr[pre]- arr[i] - i + pre;
            if (temp <= 0 ) {
                //如果代价比价值还高，更新索引
                pre = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 8, 10};
        System.out.println(new Solution1014().maxScoreSightseeingPair(arr));
    }
}
