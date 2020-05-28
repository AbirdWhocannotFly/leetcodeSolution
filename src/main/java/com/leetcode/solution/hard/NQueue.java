package com.leetcode.solution.hard;

import com.leetcode.solution.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后
 * https://leetcode-cn.com/problems/n-queens/
 *
 * @author yangguang14
 * @date 2020/5/27.
 */
public class NQueue {
    //记录皇后数量
    private int n;
    //记录结果
    List<List<String>> res = new ArrayList<List<String>>();
    //记录限制条件-列
    int[] cols;
    //记录限制条件-对角线
    int[] diagonal;
    //记录限制条件-反对角线
    int[] backDiagonal;

    //记录皇后位置
    int[] queues;

    public List<List<String>> solveNQueens(int n) {
        //初始化变量
        this.n = n;
        cols = new int[n];
        //对角线计算规则（正向（左下到右上方向）对角线，一增一减则row+col = m；反向对角线一起增加减少 row - col = n；均为常数）
        //校验对角线是否可达，即可使用对角线数组值来确认
        //其中反向对角线为做差，避免数组索引出现负数，可统一将结果+另一个常数计算。
        diagonal = new int[2 * n];
        backDiagonal = new int[2 * n];

        queues = new int[n];
        backtrack(0);
        return res;
    }

    /**
     * 回溯算法处理每行数据
     *
     * @param row
     */
    private void backtrack(int row) {

        //判断是否达到结束条件
        if (row == n) {
            //如果当前行 == n，则说明所有可行row都已遍历结束，本轮处理完成，可组装结果
            addRes();
            return;
        }
        //在当前行遍历每列寻找可行解，如果找到则递归处理下一行
        for (int i = 0; i < n; i++) {
            boolean valid = checkValid(row, i);
            if (valid) {
                //如果当前位置为可行，则加入
                addCurr(row, i);
                //并递归
                backtrack(row + 1);
                //递归结束，回溯
                removeCurrVal(row, i);
            }
        }
    }

    private void addRes() {
        //组装结果
        List<String> currRes = new ArrayList<>();
        //遍历queues数组
        for (int i = 0; i < queues.length; i++) {
            StringBuilder sb = new StringBuilder();
            //获取皇后位置
            int index = queues[i];
            for (int j = 0; j < n; j++) {
                if (j == index) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            currRes.add(sb.toString());
        }
        res.add(currRes);
    }

    /**
     * 回溯，去除当前值并解除相关限制
     *
     * @param row
     * @param col
     */
    private void removeCurrVal(int row, int col) {
        //取消当前行皇后位置
        queues[row] = -1;
        //更新取消三个限制条件
        cols[col] = 0;
        diagonal[row + col] = 0;
        backDiagonal[row - col + n] = 0;
    }

    /**
     * 记录当前值，并加入限制条件
     *
     * @param row
     * @param col
     */
    private void addCurr(int row, int col) {
        //记录当前行皇后位置
        queues[row] = col;
        //更新三个限制条件
        cols[col] = 1;
        diagonal[row + col] = 1;
        backDiagonal[row - col + n] = 1;
    }

    /**
     * 判断当前位置是否是可行解
     *
     * @param row
     * @param col
     * @return
     */
    private boolean checkValid(int row, int col) {

        return cols[col] + diagonal[row + col] + backDiagonal[row - col + n] == 0;
    }

    public static void main(String[] args) {

        int n = 4;
        PrintUtil.printListListString(new NQueue().solveNQueens(n));
    }
}
