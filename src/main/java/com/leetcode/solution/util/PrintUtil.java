package com.leetcode.solution.util;

/**
 * 输出工具类
 *
 * @author yangguang14
 * @date 2020/5/21.
 */
public class PrintUtil {

    public static void printIntArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
