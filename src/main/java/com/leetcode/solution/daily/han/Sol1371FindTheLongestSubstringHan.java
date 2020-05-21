package com.leetcode.solution.daily.han;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 * Example 2:
 *
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * Example 3:
 *
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 * @Author Broccoli
 * @Date 2020-05-21 21:32
 * @Param
 * @return
 */
public class Sol1371FindTheLongestSubstringHan {

        public int findTheLongestSubstring(String s) {
            // aeiou  分别用5个bit表示，出现次数的奇 偶性，总共32中状态组合，例如 10010 表示 a i 出现奇数次，e o u 出现偶数次
            // 遍历 字符串，判断字符是否为aeiou中的，然后改变 aeiou出现的次数，即改变状态
            // 当状态值 出现了两次，例如在 i处 的状态值 和  j处的状态值一样，那么i+1 到 j处之间的字符串，必定满足原因字母出现偶数次, 只有经历了偶数个元音字母时，才能回到之前的状态
            // 第一次出现此状态时，需要记录下标值，再次遇到时，计算下标之间的长度，更新最大值到返回值变量上


            // 方法一 s= "leetcodeisgreat" 测试不通过
            // 定义map 存储状态值 和 对应的下标
            Map<Integer,Integer> map = new HashMap<>();
            // 定义初始状态
            int status = 0;

            // 定义最大长度值
            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c=='a'){
                    status ^=0x00001;
                }
                if (c=='e'){
                    status ^=0x00010;
                }
                if (c=='i'){
                    status ^=0x00100;
                }
                if (c=='o'){
                    status ^=0x01000;
                }
                if (c=='u'){
                    status ^=0x10000;
                }
                // 判断状态值 是否重复出现
                if (map.containsKey(status)) {
                    maxLen = Math.max(maxLen, i - map.get(status));
                } else {
                    map.put(status,i);
                }
            }

            return maxLen;


        }
        // 方法2
        public int findTheLongestSubstring2(String s){
             int n = s.length();
             int[] pos = new int[1 << 5];
             Arrays.fill(pos, -1);
             int ans = 0, status = 0;
             pos[0] = 0;
             for (int i = 0; i < n; i++) {
                 char ch = s.charAt(i);
                 if (ch == 'a') {
                     status ^= (1 << 0);
                 } else if (ch == 'e') {
                     status ^= (1 << 1);
                 } else if (ch == 'i') {
                     status ^= (1 << 2);
                 } else if (ch == 'o') {
                     status ^= (1 << 3);
                 } else if (ch == 'u') {
                     status ^= (1 << 4);
                 }
                 if (pos[status] >= 0) {
                     ans = Math.max(ans, i + 1 - pos[status]);
                 } else {
                     pos[status] = i + 1;
                 }
             }
             return ans;

        }

        public static void main(String[] args) {
            String s = "leetcodeisgreat";

            System.out.println(new Sol1371FindTheLongestSubstringHan().findTheLongestSubstring(s));
            System.out.println(new Sol1371FindTheLongestSubstringHan().findTheLongestSubstring2(s));
        }
}
