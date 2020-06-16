package com.leetcode.solution.daily;

import com.leetcode.solution.structure.TreeNode;
import com.leetcode.solution.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author yangguang14
 * @date 2020/6/16.
 */
public class Solution297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        reSerialize(root, sb);
        return sb.toString();
    }

    public String reSerialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            return sb.append("null").append(",").toString();
        }
        sb.append(root.val).append(",");
        reSerialize(root.left, sb);
        reSerialize(root.right, sb);
        return sb.substring(0, sb.lastIndexOf(",")).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(strs));
        return reDeserialize(list);
    }

    private TreeNode reDeserialize(List<String> list) {
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = reDeserialize(list);
        root.right = reDeserialize(list);
        return root;
    }

    public static void main(String[] args) {
        Solution297 solution = new Solution297();
        Integer[] input = new Integer[]{-10, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNode.initTree(input);
        String data = solution.serialize(root);
        System.out.println(data);
        root = solution.deserialize(data);
        PrintUtil.printTreeLevel(root);
    }
}
