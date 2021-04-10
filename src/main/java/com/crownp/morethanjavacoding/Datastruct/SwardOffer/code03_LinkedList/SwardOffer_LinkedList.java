package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code03_LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/17 15:42
 */
public class SwardOffer_LinkedList {
    /**
     * 【从尾到头打印链表】面试题6
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList
     * 【思路】
     * 1.遍历链表，然后利用栈的后进先出的特性
     * 2.利用递归，每次都是输出ListNode的下一个节点
     */

    private ArrayList<Integer> integerArrayList = new ArrayList<>();

    // 方法一：递归方法解决。缺点：当链表非常长的时候，可能会导致函数调用栈溢出，程序的鲁棒性就没有那么好。
    /*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            integerArrayList.add(listNode.val);
        }
        return integerArrayList;
    }*/
    // 方法二：利用栈的后进先出的特性解决。
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null){
            Stack<Integer> stack = new Stack<>();
            stack.push(listNode.val);
            while (listNode.next!=null){
                listNode = listNode.next;
                stack.push(listNode.val);
            }
            while (!stack.empty()){
                integerArrayList.add(stack.pop());
            }
            return integerArrayList;
        }
        return integerArrayList;
    }

    // 测试入口
   /* public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        new SwardOffer_LinkedList().printListFromTailToHead1(listNode);
    }*/
}




