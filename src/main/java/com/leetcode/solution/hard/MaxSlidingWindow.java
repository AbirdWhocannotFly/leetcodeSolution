package com.leetcode.solution.hard;

import com.leetcode.solution.util.PrintUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * @author yangguang14
 * @date 2020/5/31.
 */
public class MaxSlidingWindow {
    /**
     * 输出滑动窗口中最大值
     *
     * @param nums 数组
     * @param k    窗口大小
     * @return 窗口中的最大值列表
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        //定义结果数组，共有nums.length - k + 1个窗口
        int[] res = new int[nums.length - k + 1];
        //使用一个数据结构保存当前窗口中的单调递减顺序
        //如果当前保存的最大值不在窗口中需要删除头部
        //如果当前加入的值大于最小值需要删除最小值并加入当前值
        //所以此处使用双端队列
        Deque<Integer> deque = new ArrayDeque<>();
        //初始化队列
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                //如果队列不空，并且最后一个值小于当前值
                //则删除尾部，因为不可能是窗口中的最大值
                deque.removeLast();
            }
            //加入当前值,存储索引
            deque.addLast(i);
        }
        res[0] = nums[deque.getFirst()];
        //从k开始滑动窗口，遍历数组
        for (int i = k; i < nums.length; i++) {
            int index = i - k + 1;
            //判断当前队列中最大值是否已经滑出
            if (index > deque.getFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                //如果队列不空，并且最后一个值小于当前值
                //则删除尾部，因为不可能是窗口中的最大值
                deque.removeLast();
            }
            //加入当前值,存储索引
            deque.addLast(i);
            res[index] = nums[deque.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        PrintUtil.printIntArray(new MaxSlidingWindow().maxSlidingWindow(nums, k));
    }
}
