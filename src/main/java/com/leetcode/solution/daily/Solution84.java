package com.leetcode.solution.daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author yangguang14
 * @date 2020/5/30.
 */
public class Solution84 {
    /**
     * 单调栈，一遍扫描，计算以当前高度为h的面积，保留最大值
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        //处理边界
        if (heights == null || heights.length == 0) {
            return res;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        //定义单调递增栈
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            //遍历数组(在数组末尾增加0，避免入参单调递减)
            int curr = (i == heights.length ? 0 : heights[i]);
            //如果当前值比栈顶元素大，说明栈顶元素需要计算
            while (!stack.isEmpty() && curr < heights[stack.peekLast()]) {
                //高度为当前栈顶的值
                int height = heights[stack.removeLast()];
                //右边界索引为i，左边界索引为出栈后的栈顶
                //如果栈顶为空，则说明可以配到第一个索引位置
                int left = stack.isEmpty() ? -1 : stack.peekLast();
                //计算宽度
                int width = i - left - 1;
                //计算面积
                res = Math.max(res, width * height);
            }
            stack.addLast(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(new Solution84().largestRectangleArea(heights));
    }
}
