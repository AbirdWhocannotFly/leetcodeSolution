package com.leetcode.solution.easy;

import com.leetcode.solution.structure.ListNode;

/**
 * 相交链表
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author yangguang14
 * @date 2020/6/5.
 */
public class Solution160 {

    /**
     * 如果两个链表没有交点，返回 null.
     * 在返回结果后，两个链表仍须保持原有的结构。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //定义两个指针指向两个链表头结点
        ListNode first = headA;
        ListNode second = headB;
        //计算链表长度
        while (first != second) {
            first = first == null ? headB : first.next;
            second = second == null ? headA : second.next;
        }
        return first;
    }

    public static void main(String[] args) {
        ListNode headA = ListNode.initList(new int[]{0,9,1});
        ListNode headB = ListNode.initList(new int[]{3});
        ListNode headC = ListNode.initList(new int[]{2,4});
        headA = ListNode.concat2List(headA,headC);
        headB = ListNode.concat2List(headB,headC);
        System.out.println(new Solution160().getIntersectionNode(headA, headB).val);
    }
}
