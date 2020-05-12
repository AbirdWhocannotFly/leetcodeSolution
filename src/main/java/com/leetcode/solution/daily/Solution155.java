package com.leetcode.solution.daily;

import com.leetcode.solution.structure.MinStack;

/**
 * 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 *
 * @author yangguang14
 * @date 2020/5/12.
 */
public class Solution155 {

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(-1);
        obj.push(5);
        obj.push(7);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }

}
