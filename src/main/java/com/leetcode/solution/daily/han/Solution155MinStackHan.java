package com.leetcode.solution.daily.han;

import java.util.Stack;

/**
 * @ProjectName
 * @ClassName Solution155MinStackHan
 * @ClassDescription TODO
 * @CreateBy broccoli
 * @CreateAt 2020-05-12
 * @Version 1.0
 */
public class Solution155MinStackHan {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public Solution155MinStackHan() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        // 包装类型的值 判等 不能直接== 此时比较的是地址值，需要用equals()方法
//        if (dataStack.peek() == minStack.peek()) {
//            minStack.pop();
//        }
        if (dataStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public  int getMin() {
        return minStack.peek();
    }

    public String[] test(String[] opertion, int[] val) {
     String[] out = new String[val.length];
     if (opertion.length != val.length) {
         return out;
     }
        Solution155MinStackHan s = null;

     for ( int i = 0; i < opertion.length; i++){
         switch (opertion[i]) {
             case "MinStack":
                s = new Solution155MinStackHan();
                break;
             case "push":
                 s.push(val[i]);
                 break;
             case "pop":
                 s.pop();
                 break;
             case "getMin":
                 out[i] = (String.valueOf(s.getMin()));
                 break;
             default:
         }

     }
     return out;
    }


    public static void main(String[] args) {
        String[] opertion = new String[]{"MinStack","push","push","push","push","pop","getMin","pop","getMin","pop","getMin"};
        int[] val = new int[]{0,512,-1024,-1024,512,0,0,0,0,0,0};

        String[] out = new Solution155MinStackHan().test(opertion,val);
        for(String i : out) {
            System.out.println(i);
        }

    }

}
