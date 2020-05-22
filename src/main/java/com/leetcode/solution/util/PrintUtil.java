package com.leetcode.solution.util;

import com.leetcode.solution.daily.Solution102;
import com.leetcode.solution.structure.TreeNode;

import java.util.List;

/**
 * 输出工具类
 *
 * @author yangguang14
 * @date 2020/5/21.
 */
public class PrintUtil {

    /**
     * 输出数组
     * @param array
     */
    public static void printIntArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        if (array != null && array.length > 0) {
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(",");
                }
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    /**
     * 层序输出二叉树
     * @param root
     */
    public static void printTreeLevel(TreeNode root){
        Solution102 solution = new Solution102();

        List<List<Integer>> out = solution.levelOrder(root);
        StringBuffer str = new StringBuffer("[");
        for (List<Integer> list : out) {
            str.append("[");
            for (Integer o : list) {
                str.append(o.toString()).append(",");
            }
            str.deleteCharAt(str.length()-1);
            str.append("],");
        }

        str.deleteCharAt(str.length()-1).append("]");
        System.out.println(str.toString());
    }
}
