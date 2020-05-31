package com.leetcode.solution.daily;

import com.leetcode.solution.structure.TreeNode;

/**
 * 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author yangguang14
 * @date 2020/5/31.
 */
public class Solution101 {

    /**
     * 递归
     * 迭代维护队列一次入队节点。每次出队两个节点进行比较
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            //同时为空返回true
            return true;
        } else if (left != null && right != null) {
            //都不为空比较值
            boolean valEquals = left.val == right.val;
            //如果值相等比较左右子树
            if (valEquals){
                boolean leftEquals = isSymmetric(left.left, right.right);
                boolean rightEquals = isSymmetric(left.right, right.left);
                return leftEquals && rightEquals;
            }
        }
        //其他情况返回false
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.initTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new Solution101().isSymmetric(root));
    }
}
