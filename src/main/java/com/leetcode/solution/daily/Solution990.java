package com.leetcode.solution.daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 *
 * @author yangguang14
 * @date 2020/6/8.
 */
public class Solution990 {

    /**
     * 并查集待实现
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {

        Map<Character, HashSet<Character>> charMap = new HashMap<Character, HashSet<Character>>(32);

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char first = equation.charAt(0);
                char sec = equation.charAt(3);
                HashSet<Character> set = new HashSet<>();
                set.add(first);
                set.add(sec);
                set.addAll(charMap.getOrDefault(first,new HashSet<>()));
                set.addAll(charMap.getOrDefault(sec,new HashSet<>()));
                for (Character character : set) {
                    charMap.put(character, set);
                }
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char first = equation.charAt(0);
                char sec = equation.charAt(3);

                HashSet<Character> set = charMap.getOrDefault(first,new HashSet<>());
                if (first == sec || set.contains(sec)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a==z","a==b","b==c","c==d","b==y","c==x","d==w","g==h","h==i","i==j","a==g","j!=y"};
        System.out.println(new Solution990().equationsPossible(strs));
        strs = new String[]{"b==a","a==b"};
        System.out.println(new Solution990().equationsPossible(strs));
        strs = new String[]{"a==b","b!=c","c==a"};
        System.out.println(new Solution990().equationsPossible(strs));
        strs = new String[]{"c==c","b==d","x!=z"};
        System.out.println(new Solution990().equationsPossible(strs));
    }

}
