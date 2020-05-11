package com.leetcode.solution.structure;

/**
 * 二叉树结构
 *
 * @author yangguang14
 * @date 2020/5/11.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 输入整数数组构建二叉树
     *
     * @param nums
     * @return
     */
    public static TreeNode initTree(Integer[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(nums[0]);
        TreeNode[] treeNodes = new TreeNode[nums.length];
        treeNodes[0] = tree;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == null) {
                continue;
            }
            TreeNode node = new TreeNode(nums[i]);
            treeNodes[i] = node;
            TreeNode parent = treeNodes[(i + 1) / 2 - 1];
            if (i % 2 != 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return tree;
    }
}
