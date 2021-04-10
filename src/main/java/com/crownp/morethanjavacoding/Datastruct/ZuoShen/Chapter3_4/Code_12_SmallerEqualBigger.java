package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

/**
 * 【将单向链表划分为左边小、中间相等、右边大的形式】
 * 参数：一个单链表、一个中心点pivot
 */
public class Code_12_SmallerEqualBigger {

	/**
	 * 解法一：转变成荷兰国旗问题。
	 * 1、遍历一遍链表、获取链表长度
	 * 2、定义链表长度大小的数组，再遍历一遍链表，把节点存放在数组里
	 * 3、按照节点的值进行荷兰国旗排序
	 * 4、遍历数组，重构链表
	 */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {  // 空判断
            return head;
        }
        Node cur = head;  // 当前指针，指向单链表某节点
        int i = 0;
        while (cur != null) {  // 第一次遍历单链表，获取链表长度
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];  // 创建固定长度的数组
        i = 0;
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {  // 第二次遍历链表，把节点存放在数组里
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);  // 对数组进行划分
        for (i = 1; i != nodeArr.length; i++) {  // 第三次遍历数组，重构链表
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }
	/* 荷兰国旗划分函数 */
    public static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                swap(nodeArr, --big, index);
            }
        }
    }
    /* 交换函数 */
    public static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }


	/**
	 * 解法二：利用桶特性来解决(保证了额外空间复杂度为O(1)，且节点相对顺序不变)
	 * 1、定义6个变量，如下
	 * 2、根据这6个变量构建三段单链表 less、equal、more，代表小于部分、等于部分和大于部分
	 * 3、遍历链表，分别将对应的结点放到对应区域
	 * 4、将三段链表重连即可
	 */
	public static Node listPartition2(Node head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        // head1 = listPartition1(head1, 4);
        head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

    /* 单链表节点类 */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
