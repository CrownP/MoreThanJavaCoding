package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code12_DecompositionToSimple;

import java.util.HashMap;

/**
 * @Author: crownp
 * @Description: 分界让复杂问题简单
 * @Date: 2020/03/08 21:21
 */
public class DecompositionToSimple0 {
    /**
     * 【复杂链表的复制】
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
     * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     */


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashMap<RandomListNode,RandomListNode> hashMap = new HashMap<>();  // 哈希表特性存放复制的结点
        RandomListNode cur = pHead;  // 当前节点指针
        while (cur != null) {  // 遍历链表，把节点存在哈希表
            hashMap.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;  // 当前指针返回pHead头结点
        while (cur != null) {  // 遍历链表，重构单链表
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(pHead);
    }

    /* define a Node class */
    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode randomListNode1 = new RandomListNode(1);
        RandomListNode randomListNode2 = new RandomListNode(2);
        RandomListNode randomListNode3 = new RandomListNode(3);
        RandomListNode randomListNode4 = new RandomListNode(4);
        randomListNode1.next = randomListNode2;
        randomListNode2.next = randomListNode3;
        randomListNode3.next = randomListNode4;
        while (randomListNode1!=null) {
            System.out.println(randomListNode1.label);
            randomListNode1 = randomListNode1.next;
        }
        System.out.println(randomListNode1.label);
    }
}
