package com.leetcode.solution.daily;

/**
 * @author yangguang14
 * @date 2020/5/9.
 */
public class Soution69 {

    public int mySqrt(int x) {

        return getSqrt(x);
    }

    /**
     * 二分
     *
     * @param x
     * @return
     */
    private int getSqrt(int x) {
        if (x < 2) {
            return x;
        }
        int max = x / 2;
        if ((long)max * max <= x) {
            return max;
        }
        int min = max / 2;
        while (min < max) {
            //判断当前位置是否为结果
            if ((long)min * min <= x && (long)(min + 1) * (min + 1) > x) {
                break;
            }
            //如果当前值比目标值大，则结果在下半区间
            if ((long)min * min > x) {
                max = min;
                min = max / 2;
            } else {
                //否则在上半区间
                min = (max + min) / 2;
            }
//            System.out.println(min + "--" + max);
        }
        return min;
    }

    public static void main(String[] args) {
        int arg = 2147395599;
        System.out.println(new Soution69().mySqrt(arg));
    }
}
