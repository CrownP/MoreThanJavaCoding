package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code10_CodeRobustness;

/**
 * @Author: crownp
 * @Description: 代码的鲁棒性
 * @Date: 2020/02/19 20:24
 */
public class CodeRobustness0 {
    /**
     * 【链表中倒数第k个结点】 面试题22
     * 输入一个链表，输出该链表中倒数第k个结点。
     * 【总结】
     * 使用两个指针 fast 和 slow ，fast先走k-1步，然后fast和slow同时走，直到fast.next为空，返回slow结点。
     * 过程中要注意nullpoint异常
     */

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k<1) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i = 1;
        while (fast.next != null) {
            for (; i < k ; i++) {
                fast =  fast.next;
                if (fast == null) {
                    return null;
                }
            }
            if (fast.next == null) {
                return slow;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /* test class */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        head.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode = new CodeRobustness0().FindKthToTail(head,5);
    }


    /*define a Node Class*/
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

}
