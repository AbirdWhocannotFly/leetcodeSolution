package com.leetcode.solution.daily;

import com.leetcode.solution.structure.TreeNode;
import com.leetcode.solution.util.PrintUtil;

/**
 * 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author yangguang14
 * @date 2020/5/22.
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {


        //根据前序数组中的第一个位置，查找在中序遍历中的位置，对中序数组进行左子树与右子树分组
        //根据左子树长度切分前序数组。进行递归
        return myTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 构建树
     * 根据前序数组中的第一个位置，查找在中序遍历中的位置，对中序数组进行左子树与右子树分组
     * 根据左子树长度切分前序数组。进行递归
     *
     * @param preorder 前序遍历数组
     * @param preStart 前序数组起始索引
     * @param preEnd   前序数组结束索引
     * @param inorder  中序遍历数组
     * @param inStart  中序数组起始索引
     * @param inEnd    中序数组结束索引
     * @return
     */
    private TreeNode myTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[preStart]);
        }
        //初始化根节点
        TreeNode root = new TreeNode(preorder[preStart]);

        //查找根节点在中序中的索引位置
        int rootIndex = findRootInInOrder(inorder, inStart, inEnd, preorder[preStart]);
        //计算根据索引位置切分的数组长度
        int leftLength = rootIndex - inStart;
        //根据切分结果进行左右子树递归
        root.left = myTree(preorder, preStart + 1, preStart + leftLength, inorder, inStart, rootIndex - 1);
        root.right = myTree(preorder, preStart + leftLength + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

    /**
     * 题解中将此方法优化为遍历inorder，存储进hashmap
     * @param inorder
     * @param inStart
     * @param inEnd
     * @param rootVal
     * @return
     */
    private int findRootInInOrder(int[] inorder, int inStart, int inEnd, int rootVal) {
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new Solution105().buildTree(preOrder, inOrder);
        PrintUtil.printTreeLevel(root);

    }
}
