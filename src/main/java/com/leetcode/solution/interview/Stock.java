package com.leetcode.solution.interview;

import com.leetcode.solution.util.PrintUtil;

/**
 * @author yangguang14
 * @date 2020/6/22.
 */
public class Stock {

    public int[] getMax(int[] stocks) {
        int[] res = new int[2];
        int max = 0;
        for (int i = 1; i < stocks.length; i++) {
            int earn = stocks[i] - stocks[res[0]];
            if (earn > max) {
                max = earn;
                res[1] = i;
            }
            if (earn < 0) {
                res[0] = i;
            }
        }
        return max == 0 ? new int[]{-1, -1} : res;
    }

    public static void main(String[] args) {
        int[] stocks = new int[]{1,2,3,6,5};
        PrintUtil.printIntArray(new Stock().getMax(stocks));
        stocks = new int[]{8,6,5,3,2};
        PrintUtil.printIntArray(new Stock().getMax(stocks));
    }
}
