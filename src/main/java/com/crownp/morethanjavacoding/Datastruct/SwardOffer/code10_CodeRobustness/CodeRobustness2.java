package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code10_CodeRobustness;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/03 21:03
 */
public class CodeRobustness2 {
    /**
     * 【合并两个排序的链表】 面试题25
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * 【思路】
     * 递归的思想。定义一个头结点，判断list1和list2的值谁小，就把谁安上去
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode newListNode;
        if (list1.val < list2.val) {
            newListNode = list1;
            newListNode.next = Merge(list1.next, list2);
        } else {
            newListNode = list2;
            newListNode.next = Merge(list1, list2.next);
        }
        return newListNode;
    }


    /* define a ListNode Class*/
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
