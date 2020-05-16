package com.leetcode.solution.daily;

import com.leetcode.solution.structure.ListNode;

/**
 * K 个一组翻转链表
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author yangguang14
 * @date 2020/5/16.
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        //虚拟头部指针，next节点指向结果链表头部
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //记录本次翻转头部前置指针
        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            //end指针向后移动k次选出本次需翻转数据或直到链表结尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //如果已经到达链表尾部，结束循环
            if (end == null) {
                break;
            }
            //记录下次起点
            ListNode next = end.next;
            //记录本次起点
            ListNode start = pre.next;
            //断开本次翻转尾部
            end.next = null;
            //翻转并更新pre指向翻转后链表头部
            pre.next = reverse(start);
            //将翻转后链表与后半段链表重新连接
            start.next = next;
            //更新pre指向待翻转链表头部前一个节点
            pre = start;
            //更新end指针
            end = start;

        }
        return dummy.next;
    }

    /**
     * 头插法翻转单链表
     *
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        int k = 3;
        ListNode head = ListNode.initList(nums);
        System.out.println(head.toString());
        System.out.println(new Solution25().reverseKGroup(head, k).toString());

    }

}
