package com.leetcode.solution.daily.han;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolutionValidParentheseHan {
    public Boolean isValidParenthses(String s) {
        // 首先判断 是否为空字符串
        if (s == null || s.length() == 0) {
            return true;
        }

        // 创建一个括号匹配关系的Map 用来校验是否匹配
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        // 创建一个栈， 用来存储遍历字符串得到的 左括号  jdk 8以后 有取消Stack的趋势， 因此用Deque 替代 Stack
        Deque<Character> dq = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            // 如果是左括号，进栈
            if (c == '(' || c == '[' || c == '{') {
                dq.push(c);
            } else {
                if ( dq.isEmpty() || !map.get(c).equals(dq.pop())) {
                    return false;
                }
            }
        }
         return dq.size() == 0;
    }

    public static void main(String[] args) {
        String s = "{[}{]}";
        SolutionValidParentheseHan sol = new SolutionValidParentheseHan();

        System.out.println(sol.isValidParenthses(s));

    }


}