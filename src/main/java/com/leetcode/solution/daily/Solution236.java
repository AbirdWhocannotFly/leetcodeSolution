package com.leetcode.solution.daily;

import static java.lang.System.out;

/**
 * 二叉树的最近公共祖先
 *
 * @author yangguang14
 * @date 2020/5/10.
 */
public class Solution236 {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        dfs(root, p, q);
        return ans;

    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        //如果为null则不符合&&如果已经找到提前结束遍历
        if (root == null || ans != null) {
            return false;
        }
        out.println(root.val);
        //判断本身是否为其中一个
        boolean own = (root.val == p.val || root.val == q.val);
        //判断左子树是否为其中一个
        boolean left = dfs(root.left, p, q);
        //判断右子树是否为其中一个
        boolean right = dfs(root.right, p, q);
        //判断当前节点是否为公共祖先，即本身，左右同时满足两个（因为不存在重复值，可简单判断）
        boolean findFlag = (left && right) || (own && (left || right));
        if (findFlag ) {
            ans = root;
        }
        //返回自身是否为其中一个节点的祖先节点
        return left || right || own;
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        Solution236 solution236 = new Solution236();
        TreeNode root = solution236.initTree(input);
        TreeNode p = solution236.initTree(new Integer[]{7});
        TreeNode q = solution236.initTree(new Integer[]{4});
        out.println(new Solution236().lowestCommonAncestor(root, p, q).val);

    }

    public TreeNode initTree(Integer[] nums) {
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
            TreeNode parent = treeNodes[(i+1) / 2 - 1];
            if (i % 2 != 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
        return tree;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}

