package com.leetcode.solution.medium;

import com.leetcode.solution.structure.ListNode;

/**
 * 两两交换链表中的节点
 * @author yangguang14
 * @date 2020/6/4.
 */
public class SwapNodePairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        //虚拟节点指向头结点
        dummy.next = head;
        //指向未处理部分
        ListNode nextHead = head.next.next;
        //将虚拟节点指向头结点的下一个节点作为新头结点
        dummy.next = head.next;
        //将新头结点指向原头结点
        dummy.next.next = head;
        //将原头结点指向后面的链表处理结果
        head.next = swapPairs(nextHead);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initList(new int[]{1,2,3,4,5,6});
        System.out.println(new SwapNodePairs().swapPairs(head).toString());
    }
}
