package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code03_LinkedList;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/17 16:48
 */
public class SwardOffer_LinkedList1 {
    /**
     * 【链表中环的入口结点】 面试题23
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
     * <p>
     * 【思路】
     * 1、判断是否有环：快慢指针，有环一定相遇，没环快指针指向null
     * 2、获取环的结点数量：快慢指针相遇后，慢指针（走一步）再走一圈回到自身就能获取到 结点个数
     * 3、获取环的入口结点：快慢指针指向头结点，快指针一定环的结点个数的步数，然后快慢指针均只移动一步，相遇的结点便是环的入口结点
     *
     * 【重点】4、一步到胃的解题思路：相遇后快慢指针均只走一步，再次相遇的结点便是入口结点
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break; //此时相遇
            }
        }
        // 代表没有环的情况
        if (fast == null || fast.next == null) {
            return null;
        }
        // 慢指针指向头结点
        slow = pHead;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

   /* public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode1;
        ListNode listNode4 = new SwardOffer_LinkedList1().EntryNodeOfLoop(listNode);
        System.out.println(listNode4.val);
    }*/
}
