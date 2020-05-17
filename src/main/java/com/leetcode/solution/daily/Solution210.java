package com.leetcode.solution.daily;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 课程表2
 * https://leetcode-cn.com/problems/course-schedule-ii/
 *
 * @author yangguang14
 * @date 2020/5/17.
 */
public class Solution210 {

    /**
     * @param numCourses    总共有 n 门课需要选,0->n-1。所以数组下标不需特殊处理
     * @param prerequisites 先决条件
     * @return 学习顺序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //记录入度，即依赖数量
        int[] courseWeights = new int[numCourses];
        //初始化
        for (int i = 0; i < prerequisites.length; i++) {
            //输入为前者依赖后者，此处做转换
            int pre = prerequisites[i][1];
            int post = prerequisites[i][0];
            //记录入度
            courseWeights[post] = courseWeights[post] + 1;
        }

        //使用队列记录遍历顺序
        Queue<Integer> queue = new LinkedBlockingQueue();
        //从入度中选出入度为0的数据
        for (int i = 0; i < courseWeights.length; i++) {
            if (courseWeights[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;
        //开始遍历
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            res[count++] = curr;
            //更新相关可达节点的入度

            for (int i = 0; i < prerequisites.length; i++) {
                //输入为前者依赖后者，此处做转换
                int pre = prerequisites[i][1];
                int post = prerequisites[i][0];
                if (pre == curr) {
                    courseWeights[post] = courseWeights[post] - 1;
                    if (courseWeights[post] == 0) {
                        //如果入度为0，加入queue
                        queue.add(post);
                    }
                }
            }
        }
        //判断遍历完成后，结果集是否=入参课程数。如果不等代表存在环返回null
        if (count != numCourses) {
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] integers = new Solution210().findOrder(numCourses, prerequisites);
        System.out.print("[");
        for (Integer integer : integers) {
            System.out.print(integer + ",");
        }
        System.out.print("]");
    }
}
