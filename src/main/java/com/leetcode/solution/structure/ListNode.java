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
