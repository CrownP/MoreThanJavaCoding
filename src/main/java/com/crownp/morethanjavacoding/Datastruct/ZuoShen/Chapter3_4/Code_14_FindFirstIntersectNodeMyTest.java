package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;


/**
 * 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 * 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 * 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 * 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 * 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 * 空间复杂度请达到O(1)。
 */
public class Code_14_FindFirstIntersectNodeMyTest {


    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1 = getLoopNode(head1);  //判断链表1是否有环
        Node loop2 = getLoopNode(head2);  //判断链表2是否有环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 判断单链表是否有环，有就返回入环节点，没就返回null
     * （重点思路：快慢指针，快指针走两步、慢指针走一步，相遇后，快指针回到头结点，然后快慢指针走一步，再相遇就是入环节点）
     */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head.next.next;  // 快指针
        Node slow = head.next;  // 慢指针
        while (fast != null) {
            if (fast == slow) {  //如果相等，跳出循环
                break;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        fast = head;  // 快指针回到头结点
        while (fast != slow) {  //如果相等，跳出循环
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node noLoop(Node head1, Node head2) {
        return null;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        return null;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        /*head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);*/

        // 0->9->8->6->7->null
       /* Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);*/

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        Node node = getLoopNode(head1);
        System.out.println(node.value);


        // 0->9->8->2...
        /*head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);*/

        // 0->9->8->6->4->5->6..
        /*head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);*/

    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

}
