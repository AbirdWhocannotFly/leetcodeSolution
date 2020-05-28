package com.leetcode.solution.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 *
 * @author yangguang14
 * @date 2020/5/27.
 */
public class Solution974 {

    /**
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     *
     * @param array
     * @param k
     * @return
     */
    public int subarraysDivByK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }
        int res = 0;
        //记录前缀和 mod k 的值
        Map<Integer, Integer> map = new HashMap<>();
        //mod 为0 需要初始化为1，适用本身前缀和整除的边界条件
        map.put(0, 1);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            //计算和
            sum += array[i];
            //计算mod(此处补充负数，)
            int mod = (sum % k + k) % k;
            //查看mod的前缀和的数量
            int count = map.getOrDefault(mod, 0);
            //结果集增加对应次数
            res += count;
            //map中记录
            map.put(mod, count + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 3,7,1};
        int k = 2;
        System.out.println(new Solution974().subarraysDivByK(array, k));
    }
}
