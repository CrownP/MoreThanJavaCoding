package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code03_LinkedList;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/17 16:48
 */
public class SwardOffer_LinkedList2 {
    /**
     * 【删除链表中重复的结点】面试题18的题目二
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针，例如：
     * 链表1->2->3->3->4->4->5 处理后为 1->2->5
     *
     * 【思路】
     * 1、先定义个头结点，避免前面两个节点重复。删除重复节点后，头结点与重复节点的下一个节点相连。最终返回结果的时候直接返回 头结点 的 next 节点即可
     * 2、定义两个指针，pre指向确认不重复的节点，首先指向 头结点；last节点指向待判断是否重复的节点，限制向 pHead
     * 3、然后判断重复就行了，注意last.next 不能为null的异常
     *
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        // 定义一个头结点。避免前面两个结点重复。并且始终指向确认不重复的那个结点
        ListNode head = new ListNode(0);
        head.next = pHead;

        // 定义指针p、last，指向第一个节点pHead
        ListNode pre = head;
        ListNode last = pHead;

        // 开始遍历链表
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后一个结点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                // 此时last的下一个节点与last节点是不相同的，删除重复节点，将其与pre指针指向的节点相连
                pre.next = last.next;
                last = last.next;
            } else {
                // 确认该节点是不重复的结点
                pre = last;
                last = last.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(5);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        ListNode listNode5 = new SwardOffer_LinkedList2().deleteDuplication(listNode);
        System.out.println(listNode5.next.next.val);
    }
}
