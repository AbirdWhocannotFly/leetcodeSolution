package com.leetcode.solution.structure;

/**
 * 单向链表
 *
 * @author yangguang14
 * @date 2020/5/16.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 构建单链表
     * @param nums
     * @return
     */
    public static ListNode initList(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        return head;
    }

    /**
     * 拼接两个链表
     * @param head
     * @param tail
     * @return
     */
    public static ListNode concat2List(ListNode head, ListNode tail) {
        if (head == null) {
            return tail;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
        return head;
    }

    /**
     * 构建循环链表
     * @param nums
     * @param pos
     * @return
     */
    public static ListNode initCycleList(int[] nums, int pos) {
        if (nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            tail.next = new ListNode(nums[i]);
            tail = tail.next;
        }
        if (pos > -1) {
            ListNode cycle = new ListNode(-1);
            cycle.next = head;
            for (int i = 0; i < (pos % nums.length); i++) {
                cycle.next = cycle.next.next;
            }
            tail.next = cycle.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("head:" + this.val);
        ListNode next = this.next;
        while (next != null) {
            sb.append("-->" + next.val);
            next = next.next;
        }
        sb.append("-->null");
        return sb.toString();
    }

}
