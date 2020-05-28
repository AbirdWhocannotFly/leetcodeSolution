package com.leetcode.solution.daily.han;


import java.util.Stack;

/**
 * @Description Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-28 21:56
 * @Param
 * @return
 */
public class Sol394DecodeStringHan {

    public String  decodeString(String s) {

        /**
         * 借助栈操作，遍历s 遇到 数字 或者 '[' 或者字符 就入栈，
         * 遇到']' 时 就从栈内依次取出元素，遇到'[' 后 下一位出栈必定是数字
         * 此时就能得到K[axx]这样最基本的单元，把这个单元解析成纯字符后，再入栈。
         * 最后将栈内的元素依次出栈 ，拼接成字符串即可
         */
        Stack sta = new Stack();
        char[] arr = s.toCharArray();
        for (Character c : arr) {
            if (c != ']') {
                // 元素依次入栈
                sta.push(c);
            } else {
                // 将已经入站的元素 依次出栈 得到 对应的 字符串 和 次数 以 第一个字符‘[’来判断是否要进行拼接， 拼接完 ，再次入栈
                sta = popParseAndPush(sta);
            }
        }

        // 翻转栈内的内容，拼接后输出
        StringBuffer res = new StringBuffer();
        while (sta.size() > 0) {
            res.insert(0,sta.pop());
        }

        return res.toString();
    }

    private Stack popParseAndPush(Stack sta) {
        // 首先出栈的肯定是字符 遇到‘[’,结束，然后再出栈 得到数字，数字可能出现多次 例如 11[aa]这样的
        StringBuffer str = new StringBuffer();
        while (true) {
            char c = (char)sta.pop();
            if (c == '[') {
                break;
            }
            str.insert(0,c);
        }

        int mul = 0;
        // 接下来获取 对应的数字
        while(sta.size() > 0) {
            char c = (char) sta.peek();
            if (c >= '0' && c <= '9') {
                mul += mul*10 + Integer.parseInt(c +"");
                sta.pop();
            } else {
                break;
            }
        }

        for (char c : parseCode(mul,str)) {
            sta.push(c);
        }

        return sta;
    }

    private char[] parseCode(int mul, StringBuffer str) {
        StringBuffer s = new StringBuffer();
        while (mul-->0) {
            s.append(str);
        }

        return s.toString().toCharArray();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        String s1 = "3[a2[c]]";
        String s2 = "2[abc]3[cd]ef";

        System.out.println(new Sol394DecodeStringHan().decodeString(s2));
    }
}
