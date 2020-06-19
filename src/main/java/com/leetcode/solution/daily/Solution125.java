package com.leetcode.solution.daily;

/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 125. 验证回文串
 *
 * @author yangguang14
 * @date 2020/6/19.
 */
public class Solution125 {
    /**
     * 只比较数字和字母，忽略大小写
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right && String.valueOf(s.charAt(left)).equalsIgnoreCase(String.valueOf(s.charAt(right)))) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return left >= right;
    }

    public static void main(String[] args) {
        String s = new String("A man, a plan, a canal: Panama");
        String s1 = new String("");
        String s2 = new String(",.");
        System.out.println(new Solution125().isPalindrome(s));
        System.out.println(new Solution125().isPalindrome(s1));
        System.out.println(new Solution125().isPalindrome(s2));
    }
}
