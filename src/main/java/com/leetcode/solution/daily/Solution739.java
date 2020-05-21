package com.leetcode.solution.daily;

import com.leetcode.solution.util.PrintUtil;

import java.util.Stack;

/**
 * 每日温度
 * https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author yangguang14
 * @date 2020/5/21.
 */
public class Solution739 {

    /**
     * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        //倒序遍历，维护一个栈数据结构保存后面日期即索引
        //（保存规则：如果当日气温大于后日气温，则存储的后日索引可被移除，因为已经不对结果造成影响）
        //该规则下，栈数据结构中存储的气温列表是一个递增序列
        Stack<Integer> stack = new Stack();
        //定义结果数组
        int[] res = new int[temperatures.length];

        for (int length = temperatures.length - 1; length >= 0; length--) {
            while (!stack.isEmpty()) {
                //依次判断当前气温与栈顶大小，如果栈顶气温>当前气温，则res[i]=栈顶索引-当前索引
                if (temperatures[length] < temperatures[stack.peek()]) {
                    res[length] = stack.peek() - length;
                    stack.push(length);
                    break;
                } else {
                    //如果当日气温大于后日气温，则存储的后日索引可被移除，因为已经不对结果造成影响
                    stack.pop();
                }
            }
            //如果栈为空依然没找到，则res[i]=0
            if (stack.isEmpty()) {
                res[length] = 0;
                stack.push(length);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        PrintUtil.printIntArray(new Solution739().dailyTemperatures(temperatures));
    }
}
