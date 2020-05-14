package com.leetcode.solution.daily.han;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName
 * @ClassName 二叉树层序遍历，从坐到右，获取每层节点值
 * @ClassDescription TODO
 * @CreateBy broccoli
 * @CreateAt 2020-05-13
 * @Version 1.0
 */
public class Solution102LevelOrder {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root,1,list);
        return list;
    }

    public void dfs(TreeNode node, int level, List<List<Integer>> res) {
        // 递归执行的终止条件，传入的树节点为空，跳出递归
        if (node == null){
            return ;
        }

        // 逻辑处理层，判断 进来的树所在的层 和 res的size 比较
        if (level > res.size() ) {
            // 新开辟一个数组 存储当前node的值
            List<Integer> v = new ArrayList<>();
            v.add(node.val);
            res.add(v);
        } else {
            // 获取上一层地址对应的数组，往里添值
            List<Integer> v = res.get(level -1);
            v.add(node.val);
        }

        // 下探到下一层
        dfs(node.left, level+1, res);
        dfs(node.right, level+1, res);
    }

    /**
     * @Description //数组 转成 二叉树
     * @Author Broccoli
     * @Date 2020-05-14 0:11
     * @Param [array, index]
     * @return TreeNode
     */
    public TreeNode createBinaryTreeByArray(Integer []array,int index) {
        TreeNode tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public static  void main(String[] args) {
//        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        /**
         *             3
         *           /   \
         *          9     20
         *               /  \
         *             15   7
         */

        Integer[] arr = new Integer[]{7,2,8,1,6,null,10,null,null,3,null,null,null,
                9,11,null,null,null,null,null,5,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,4};
        /**
         *           7
         *        /    \
         *     2         8
         *   /   \        \
         *  1    6        10
         *       /       /  \
         *      3        9   11
         *        \
         *        5
         *       /
         *      4
         */

        TreeNode treeNode = new Solution102LevelOrder().createBinaryTreeByArray(arr,0);

        List<List<Integer>> out = new Solution102LevelOrder().levelOrder(treeNode);
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
