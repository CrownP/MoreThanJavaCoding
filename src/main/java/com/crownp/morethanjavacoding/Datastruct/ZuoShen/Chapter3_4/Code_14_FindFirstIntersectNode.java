package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

public class Code_14_FindFirstIntersectNode {

	/* 链表节点类 */
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	/* 主函数 */
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {  //链表null判断
			return null;
		}
		Node loop1 = getLoopNode(head1);  // 获取链表1的入环节点；如果是null，说明无环
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {  // 获取两个无环单链表的相交点
			return noLoop(head1, head2);
		}										// 如果一个链表有环，一个链表无环，绝对不相交
		if (loop1 != null && loop2 != null) {  // 获取两个有环单链表的相交点
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}


	/**
	 * 判断单链表是否有环，有就返回入环节点，没就返回null
	 * （重点思路：快慢指针，快指针走两步、慢指针走一步，相遇后，快指针回到头结点，然后快慢指针走一步，再相遇就是入环节点）
	 * （也可以通过哈希表的方式，遍历单链表并存于hashmap，如果过程中某节点出现过了，说明有环）
	 */
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; // n1 -> slow
		Node n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}


	/**
	 * 获取两个无环单链表的相交节点（如果返回null，说明不相交）
	 * (除此解答方法外，还可以用哈希表。遍历单链表1并存放在hashMap中，遍历单链表2看是否在hashMap中有这个节点，以此来确定是否相交 )
	 * @param head1
	 * @param head2
	 * @return
	 */
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		int n = 0;  // 记录两个链表的差值
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {  // 此时，cur1、cur2分别指向链表最后一个结点。如果最后一个节点不相等，绝对不相交，返回null
			return null;
		}
		cur1 = n > 0 ? head1 : head2;  // 如果n大于0，说明head1链表长度较长，指向cur1
		cur2 = cur1 == head1 ? head2 : head1; // cur2指向短链表头部
		n = Math.abs(n); // 取绝对值为正值
		while (n != 0) {  // 让长链表先走n步
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {  //同时走，知道 cur1 = cur2时，找到了相交的节点
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}


	/**
	 * 获取两个有环的单链表相交的节点（如果返回null，说明不相交）
	 * @param head1 头指针
	 * @param loop1 环入口结点
	 * @param head2
	 * @param loop2
	 * @return
	 */
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {  // 如果单链表1、2的入环节点相等，说明肯定相交。但入环节点不是相交点
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {  // 如果loop1 != loop2，说明有可能相交也有可能不相交。
			cur1 = loop1.next;
			while (cur1 != loop1) {  // 遍历loop1的next，如果遍历一遍返回本身，说明不相交。
				if (cur1 == loop2) { // 如果遍历到有一个节点等于 loop2，说明相交。以loop1或loop2作为相交点都可以
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectNode(head1, head2).value);

	}

}
