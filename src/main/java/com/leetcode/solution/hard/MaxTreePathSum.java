package com.leetcode.solution.hard;

import com.leetcode.solution.structure.TreeNode;

/**
 * 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * @author yangguang14
 * @date 2020/5/29.
 */
public class MaxTreePathSum {

    //定义类变量存储结果值
    int sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //遍历
        maxGain(root);
        return sum;
    }

    /**
     * 计算当前节点最大路径
     * @param root
     * @return
     */
    private int maxGain(TreeNode root){

        //定义出口
        if (root == null){
            return 0;
        }
        //计算左子树，如果小于0，舍弃该节点
        int left = Math.max(maxGain(root.left),0);
        //计算右子树
        int right = Math.max(maxGain(root.right),0);
        //计算以当前节点为根的路径和
        int curr = root.val + left + right;
        //更新最大值
        sum = Math.max(sum,curr);
        //返回当前子树中最长的链
        return root.val + Math.max(left,right);
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{-10,9,20,null,null,15,7};
        TreeNode root = TreeNode.initTree(input);
        System.out.println(new MaxTreePathSum().maxPathSum(root));
    }
}
