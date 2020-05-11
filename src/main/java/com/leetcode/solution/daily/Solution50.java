package com.leetcode.solution.daily;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数
 * https://leetcode-cn.com/problems/powx-n/
 *
 * @author yangguang14
 * @date 2020/5/11.
 */
public class Solution50 {

    public double myPow(double x, int n) {
        /**
         * 此处不转换为long类型的话，在Integer.min_value做取反操作会溢出
         */
        Long N = (long) n;
        return pow(x, N);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double res = 0;
        double resBinary = pow(x, n / 2);
        res = resBinary * resBinary;
        if (n % 2 == 1) {
            res = res * x;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(new Solution50().myPow(x, n));
    }
}
