package com.leetcode.solution.daily.han;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-20 0:43
 * @Param
 * @return
 */
public class Sol680ValidPalindromeHan {

    /**
     *
        460 / 460 个通过测试用例
     状态：通过
     执行用时 : 6 ms, 在所有 Java 提交中击败了 99.84%的用户
     内存消耗 : 40.5 MB, 在所有 Java 提交中击败了 6.67%的用户
     */



    /**
     双指针 + 判断字符串是否为回文字符串的方法
     双指针 left right，分别指向字符串 首尾，判断值是否等， 遇到不等，只需判断 s[left+1,right] 或者s[left,right-1]包含的字符串是不是回文字符串即可
     */
    public boolean validPalindrome(String s) {
        // 当字符串长度小于2，满足删除一个字符为回文的情况
        if (s.length() <= 2) {
            return true;
        }

        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // 判断(left,right] 或者[left,right)对应的s的子串是否为回文串
                return validPalindrome2(s, left+1, right) || validPalindrome2(s, left,right-1);
            }
        }
        return true;
    }

    // 判断一个字符串是否为回文
    public boolean validPalindrome2(String s, int left, int right) {
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return left>=right;
    }


    /**
     * 这个递归的写法，够简洁，耗时相对于双指针较长，递归的思路 值得借鉴。代码写的够漂亮
     * 执行用时 :33 ms 在所有 Java 提交中击败了5.18%的用户
     * 内存消耗 : 46.7 MB 在所有 Java 提交中击败了6.67%的用户
     */
    public boolean validPalindrome3(String s) {
        return validPalindrome4(s, 0, s.length()-1, 1);
    }

    /**
     *
     * @param s 输入字符串
     * @param left 左指针
     * @param right 右指针
     * @param chance 删除节点的机会次数
     */
    private boolean validPalindrome4(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome4(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome4(s, left, right - 1, chance-1) || validPalindrome4(s, left + 1, right, chance-1);
        }
    }

//    作者：guan-rong
//    链接：https://leetcode-cn.com/problems/valid-palindrome-ii/solution/javashuang-zhi-zhen-di-gui-jie-jue-680-yan-zheng-h/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
