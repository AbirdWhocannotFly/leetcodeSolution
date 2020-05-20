package com.leetcode.solution.daily;

import java.util.Arrays;

/**
 * 每个元音包含偶数次的最长子字符串
 * https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 * 照抄题解
 * @author yangguang14
 * @date 2020/5/20.
 */
public class Solution1371 {

    /**
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次
     * 前缀和思想：即当前位置统计的奇偶性-第一次出现此奇偶性的位置，中间部分一定为偶数
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        //使用一个5位二进制数存储奇偶性。每位分别代表一个字母的奇偶，所以数组长度需要2^5
        //数组存储每种组合第一次出现这种组合的index。形成前缀和计算前提
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        //记录结果
        int ans = 0,
                //奇偶统计变量初始化为0，即每个都未出现
                status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            //统计当前位下各字母出现奇偶性
            if (ch == 'a') {
                //对第一位进行计数
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
            //应用前缀和思想：即当前位置统计的奇偶性-第一次出现此奇偶性的位置，中间部分一定为偶数
            if (pos[status] >= 0) {
                //如果该组合已经出现过，则当前位置减去第一个出现此组合的位置即为当前位置符合条件的最大长度
                //记录当前值与历史值较大的，更新结果
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                //如果未出现过，则在数组中记录
                pos[status] = i + 1;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        String ori = "qnplnlarrtztkotazhufrsfczrzibvccaoayyihidztfljcffiqfviuwjowkppdajmknzgidixqgtnahamebxfowqvnrhuzwqohquamvszkvunbxjegbjccjjxfnsiearbsgsofywtqbmgldgsvnsgpdvmjqpaktmjafgkzszekngivdmrlvrpyrhcxbceffrgiyktqilkkdjhtywpesrydkbncmzeekdtszmcsrhsciljsrdoidzbjatvacndzbghzsnfdofvhfxdnmzrjriwpkdgukbaazjxtkomkmccktodig";
        System.out.println(new Solution1371().findTheLongestSubstring(ori));
    }
}
