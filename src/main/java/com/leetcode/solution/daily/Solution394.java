package com.leetcode.solution.daily;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 *
 * @author yangguang14
 * @date 2020/5/28.
 */
public class Solution394 {

    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        //记录操作数次数
        LinkedList<Integer> multiList = new LinkedList<>();
        //记录操作数
        LinkedList<String> tmpList = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                //左括号记录当前状态入栈
                //记录本轮操作数次数
                multiList.addLast(multi);
                //记录本轮操作数
                tmpList.addLast(res.toString());
                //初始化本轮变量
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //右括号计算本轮结果
                StringBuilder tmp = new StringBuilder();
                //获取次数
                int currMulti = multiList.removeLast();
                //拼接
                for (int i = 0; i < currMulti; i++) {
                    tmp.append(res);
                }
                //将当前结果与之前结果拼接，s的最后一个字符一定是右括号。匹配完成及为最终结果
                res = new StringBuilder(tmpList.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {
                //如果为数值，则计算当前轮次操作次数
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else {
                //如果为字母，则拼接到本轮操作数中
                res.append(c);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(new Solution394().decodeString(s));
        System.out.println(new Solution394().decodeString2(s));
    }


    public String decodeString2(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        //记录操作数次数
        Stack<Integer> multiList = new Stack<>();
        //记录操作数
        Stack<String> tmpList = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                //左括号记录当前状态入栈
                //记录本轮操作数次数
                multiList.push(multi);
                //记录本轮操作数
                tmpList.push(res.toString());
                //初始化本轮变量
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                //右括号计算本轮结果
                StringBuilder tmp = new StringBuilder();
                //获取次数
                int currMulti = multiList.pop();
                //拼接
                for (int i = 0; i < currMulti; i++) {
                    tmp.append(res);
                }
                //将当前结果与之前结果拼接，s的最后一个字符一定是右括号。匹配完成及为最终结果
                res = new StringBuilder(tmpList.pop() + tmp);
            } else if (c >= '0' && c <= '9') {
                //如果为数值，则计算当前轮次操作次数
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            else {
                //如果为字母，则拼接到本轮操作数中
                res.append(c);
            }
        }

        return res.toString();
    }
}
