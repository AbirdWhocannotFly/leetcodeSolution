package com.leetcode.solution.daily;

import com.leetcode.solution.structure.TreeNode;

import java.util.Stack;

/**
 * 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author yangguang14
 * @date 2020/5/11.
 */
public class Solution98 {

    /**
     * 深度优先遍历，二叉搜索树的中序遍历为递增顺序
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {

        if (root == null ||
                (root.left == null && root.right == null)) {
            return true;
        }
        double inorder = -Double.MAX_VALUE;
        Stack<TreeNode> stack = new Stack();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{10, 5, 15, null, null, 6, 20};
        TreeNode root = TreeNode.initTree(input);
        System.out.println(new Solution98().isValidBST(root));

    }


}
