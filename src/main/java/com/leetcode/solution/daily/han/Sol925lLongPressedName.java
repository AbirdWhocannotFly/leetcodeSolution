package com.leetcode.solution.daily.han;

/**
 * @ProjectName
 * @ClassName
 * @ClassDescription Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 *
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 *
 *
 * Example 1:
 *
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 * Example 2:
 *
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 * Example 3:
 *
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 * Example 4:
 *
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character.
 *
 *
 * Constraints:
 *
 * 1 <= name.length <= 1000
 * 1 <= typed.length <= 1000
 * The characters of name and typed are lowercase letters.TODO
 * @author  broccoli
 * @CreateAt
 * @Version 1.0
 */
public class Sol925lLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        /*
            双指针，遍历name与typed，i=0，j=0；name[i]==typed[j]时，i++，j++，
            若name[i]!=typed[j],则判断typed[j]==name[i-1],判断是否为重复录入的字符，
            最后判断name是否全部遍历，若name未遍历完，为false，
            若name遍历结束，判断typed后续的字符是否为name最后字符的重复值
         */

        int i = 0,j = 0;
        int nameLen = name.length();
        int typedLen = typed.length();
        // 遍历 typed
//        while(j < typedLen){  j 小于length即可因为 是从0 开始的
        while(j < typedLen){
            if(i < nameLen && name.charAt(i)==typed.charAt(j)){
                i++;
                j++;
            } else if (i == 0){
                // 第一个字符不等，返回false
                return false;
            } else if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else{
                return false;
            }
        }
        return i == nameLen;

    }


    public static void main (String[] args){

        System.out.println(new Sol925lLongPressedName().isLongPressedName("alex","alleexx"));

    }
}
