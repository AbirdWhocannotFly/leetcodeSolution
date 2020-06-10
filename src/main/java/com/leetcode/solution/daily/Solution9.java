package com.leetcode.solution.daily;

/**
 * 9. 回文数
 *
 * @author yangguang14
 * @date 2020/6/10.
 */
public class Solution9 {

    /**
     * 逐位翻转
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //处理边界
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int y = 0;

        while (x > y) {
            int mod = x % 10;
            y = y * 10 + mod;
            x = x / 10;
        }
        return x == y || y / 10 == x;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{121,-121,10,101};
        for (int num : nums) {
            System.out.println(new Solution9().isPalindrome(num));
        }
    }
}
