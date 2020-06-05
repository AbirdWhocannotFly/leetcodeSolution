package com.leetcode.solution.daily;

import com.leetcode.solution.util.PrintUtil;

/**
 * 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @author yangguang14
 * @date 2020/6/5.
 */
public class SolutionInterview29 {

    public int[] spiralOrder(int[][] matrix) {
        //计算边界
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        //初始化行列边界
        int rows = matrix.length, columns = matrix[0].length;
        //定义结果数组
        int[] order = new int[rows * columns];
        //定义结果数组输出索引
        int index = 0;
        //定义执行边界
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            //从左往右输出上层
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            //从上往下输出右侧
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            //处理边界，如果左右重叠或上下重叠说明只剩单数层
            if (left < right && top < bottom) {
                //从右往左输出下侧
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                //从下往上输出左侧
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            //四个角变化，缩小范围
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        PrintUtil.printIntArray(new SolutionInterview29().spiralOrder(matrix));
    }
}
