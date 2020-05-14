package com.leetcode.solution.daily;

import com.leetcode.solution.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @author yangguang14
 * @date 2020/5/14.
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        //层序遍历使用队列先入先出逐层遍历根，左右节点。队列中当前存储即每层数据。
        // 依次出队后将节点子节点放入队列，形成层序遍历
        //所以只需要记录当前队列长度，出队该长度即当前层遍历完成
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        queue.add(root);
        while (!queue.isEmpty()){
            //链表存储当前层数据
            List<Integer> temp = new ArrayList<>();
            //记录当前层的数据量
            int tempSize = queue.size();
            for (int i = 0; i < tempSize; i++) {
                //出队
                TreeNode tempRoot = queue.remove();
                //存储已遍历
                temp.add(tempRoot.val);
                //将子节点入队
                if (tempRoot.left != null){
                    queue.add(tempRoot.left);
                }
                if (tempRoot.right != null){
                    queue.add(tempRoot.right);
                }
            }
            //当前层遍历完成将临时链表加入结果集
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeNode.initTree(input);
        List<List<Integer>> res = new Solution102().levelOrder(root);
        for (List<Integer> temp : res) {
            for (int value : temp){
                System.out.print(value+",");
            }
            System.out.println();
        }

    }
}
