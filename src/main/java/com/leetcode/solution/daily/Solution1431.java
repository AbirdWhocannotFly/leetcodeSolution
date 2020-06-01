package com.leetcode.solution.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 拥有最多糖果的孩子
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * @author yangguang14
 * @date 2020/6/1.
 */
public class Solution1431 {
    /**
     * @param candies
     * @param extraCandies
     * @return
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList<>(candies.length);
        int max = 0;
        //遍历一遍记录当前最大值
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        //遍历计算当前值获取额外值后是否不小于最大值
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2,3,5,1,3};
        int extra = 3;
        List<Boolean> res = new Solution1431().kidsWithCandies(candies, extra);
        for (Boolean re : res) {
            System.out.print(re + ",");
        }
    }
}
