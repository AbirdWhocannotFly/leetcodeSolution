package com.leetcode.solution.medium;

import com.leetcode.solution.structure.ListNode;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author yangguang14
 * @date 2020/6/1.
 */
public class DetectCycle {

    /**
     * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        //遍历链表
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //如果两个指针相遇，说明有环
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        //如果有环，检查环节点
        if (flag) {
            slow = head;
            int count = 0;
            //重新遍历链表直到相遇
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
                count++;
            }
            System.out.println("环起点索引为：" + count);
            return slow;
        } else {
            System.out.println("无环");
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.initCycleList(new int[]{3,2,0,-4},3);
        System.out.println(new DetectCycle().detectCycle(head).val);
    }
}
