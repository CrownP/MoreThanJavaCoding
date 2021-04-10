package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code10_CodeRobustness;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/28 20:36
 */
public class CodeRobustness1 {
    /**
     * 【反转链表】 面试题24
     * 输入一个链表，反转链表后，输出新链表的表头。
     * 【思路】
     * 移动指针！比如有链表 1->2->3->4->5
     * （1）指针 newHead 指向1的前头为null，
     * （2）指针 currentHead 指向1
     * （3）new一个listNode结点保存 currentHead 的next结点。避免短链。
     * 此时操作：
     * （1）currentHead.next = newHead;
     * （2）newHead = currentHead;
     * （3）currentHead = listNode;
     */
    public ListNode ReverseList(ListNode head) {
        // null 判断
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null;
        ListNode currentHead = head;
        while (currentHead != null) {  // 最终currentHead指向null，newHead为新的头
            ListNode listNode = currentHead.next; // 缓存currentHead的下一个结点，避免断链
            currentHead.next = newHead;
            newHead = currentHead;
            currentHead = listNode;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode listNode = new CodeRobustness1().ReverseList(listNode1);
        System.out.println(listNode.next.next.val);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
