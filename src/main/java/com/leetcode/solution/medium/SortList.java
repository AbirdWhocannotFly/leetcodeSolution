package com.leetcode.solution.medium;

import com.leetcode.solution.structure.ListNode;

/**
 * 148 排序链表
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author yangguang14
 * @date 2020/6/2.
 */
public class SortList {
    /**
     * 归并
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //处理边界
        if (head == null || head.next == null) {
            return head;
        }
        //计算链表长度
        int length = 0;
        ListNode lnode = head;
        while (lnode != null) {
            lnode = lnode.next;
            length++;
        }
        // 4 3 2 5 8 1
        //从1-n归并处理
        //定义span归并跨度
        int span = 1;
        //排序后节点发生变化，需要记录头
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //记录本轮次的头
        ListNode pre = null;
        //定义两个合并链表的头指针
        ListNode h1 = null;
        ListNode h2 = null;
        while (span < length) {
            //开始本轮跨度合并
            //定义指针初始化
            pre = dummy;
            while (pre.next != null) {
                h1 = pre.next;
                int i = 0;
                //第一部分链表尾部
                ListNode t1 = h1;
                for (i = 1; i < span && t1.next != null; i++) {
                    //计算第一部分尾部
                    t1 = t1.next;
                }
                //如果只有一部分，直接拼接
                if (t1.next == null) {
                    pre.next = h1;
                    pre = t1;
                    continue;
                }
                //第二部分头指针
                h2 = t1.next;
                //断开连接
                t1.next = null;
                //第二部分链表尾部
                ListNode t2 = h2;
                for (i = 1; i < span && t2.next != null; i++) {
                    //第二部分头指针后移
                    t2 = t2.next;
                }
                //记录被断开的点
                ListNode nextPre = t2.next;
                //断开第二部分
                t2.next = null;
                //合并两个有序链表(span由小变大，范围有序)
                while (h1 != null && h2 != null) {
                    if (h1.val > h2.val) {
                        pre.next = h2;
                        h2 = h2.next;
                    } else {
                        pre.next = h1;
                        h1 = h1.next;
                    }
                    pre = pre.next;
                }
                //直接拼接剩余部分
                pre.next = h1 == null ? h2 : h1;
                //将pre推到合并链表结尾
                while (pre.next != null) {
                    pre = pre.next;
                }
                //将pre连接nextPre，进行未完成部分合并
                pre.next = nextPre;
            }
            //将span*2，扩大区间
            span *= 2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initList(new int[]{-1, 5, 3, 4, 0});
        System.out.println(new SortList().sortList(head).toString());
    }
}
