package com.leetcode.solution.medium;

/**
 * 面试题64. 求1+2+…+n
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * @author yangguang14
 * @date 2020/6/2.
 */
public class SumNumsN {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     * @param n
     * @return
     */
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n ;
    }

    public static void main(String[] args) {
        int n = 101;
        int sum1 = n * (n +1) /2;
        System.out.println("sum1----"+sum1);
        int sum2 = new SumNumsN().sumNums(n);
        System.out.println("sum2----"+sum2);
        System.out.println(sum1 == sum2);
    }
}
