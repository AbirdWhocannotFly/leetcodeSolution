package com.leetcode.solution.structure;

import java.util.Stack;

/**
 * 155 最小栈数据结构
 *
 * @author yangguang14
 * @date 2020/5/12.
 */
public class MinStack {

    /**
     * 存储数据
     */
    Stack<Integer> myStack = null;
    /**
     * 存储当前栈中最小值
     */
    Stack<Integer> min = null;

    public MinStack() {
        myStack = new Stack();
        min = new Stack();
    }

    /**
     * 压栈
     *
     * @param x
     */
    public void push(int x) {
        myStack.push(x);
        //如果比当前栈最小值小，则压入小栈
        if (min.isEmpty()) {
            min.push(x);
        } else if (x <= min.peek()) {
            min.push(x);
        }
    }

    /**
     * 删除栈顶
     */
    public void pop() {
        int x = myStack.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }

    /**
     * 返回栈顶
     *
     * @return
     */
    public int top() {
        return myStack.peek();
    }

    /**
     * 返回最小值
     *
     * @return
     */
    public int getMin() {
        return min.peek();
    }
}
