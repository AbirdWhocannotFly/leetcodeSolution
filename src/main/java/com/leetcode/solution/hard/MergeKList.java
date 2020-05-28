package com.leetcode.solution.hard;

import com.leetcode.solution.structure.ListNode;

/**
 * 合并K个排序链表
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author yangguang14
 * @date 2020/5/28.
 */
public class MergeKList {

    /**
     * 归并合并
     * 第二种解法：优先级队列，维护k个头部，出队（直到队为空）一个，将出队node的next（如果存在）加入
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);

    }

    /**
     * 二分合并链表list
     *
     * @param lists
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode[] lists, int left, int right) {
        //定义出口
        if (left == right) {
            return lists[left];
        }
        if (left > right) {
            return null;
        }
        //计算二分边界
        int mid = (left + right) / 2;
        //递归计算左半部分和右半部分
        return mergeTwoList(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 合并两个有序链表
     *
     * @param merge
     * @param merge1
     * @return
     */
    private ListNode mergeTwoList(ListNode merge, ListNode merge1) {
        //定义一个头，尾节点，标记合并后的链表
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        //定义两个指针，遍历两个链表
        ListNode first = merge;
        ListNode second = merge1;
        //当两个链表都不为空
        while (first != null && second != null) {
            //比较值
            if (first.val < second.val) {
                //合并一个节点并更新被合并的链表指针后移
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            //更新尾节点指针后移
            tail = tail.next;
        }
        //判断是否存在某个链表未合并完成，拼接到tail(此处即使second也为空也不影响结果)
        tail.next = first != null ? first : second;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.initList(new int[]{1,4,5});
        ListNode l2 = ListNode.initList(new int[]{1,3,4});
        ListNode l3 = ListNode.initList(new int[]{2,6});
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        System.out.println(new MergeKList().mergeKLists(listNodes));
    }
}
