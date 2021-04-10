package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/18 21:00
 */
public class Tree5 {
    /**
     * 【把二叉树打印成多行】 面试题32题目二
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     *
     * 【思路】
     * 一、使用两个队列，一个存第一层，一个存第一层的所有子节点，依次类推直到两个队列都为空。
     * 二、Java使用队列：Queue queue = new LinkedList();   这样使用的原因是LinkedList类实现了Queue接口
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }
        Queue<TreeNode> queue1 = new LinkedList<>(); //存放奇数层
        Queue<TreeNode> queue2 = new LinkedList<>(); //存放偶数层
        queue1.add(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>(); //存queue1的值
            ArrayList<Integer> integers1 = new ArrayList<>(); //存queue2的值
            // queue1不为空时
            while (!queue1.isEmpty()){
                TreeNode treeNode = queue1.poll();
                if (treeNode.left != null) {
                    queue2.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue2.add(treeNode.right);
                }
                integers.add(treeNode.val);
            }
            // queue2不为空时
            while (!queue2.isEmpty()){
                TreeNode treeNode = queue2.poll();
                if (treeNode.left != null) {
                    queue1.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue1.add(treeNode.right);
                }
                integers1.add(treeNode.val);
            }
            if (!integers.isEmpty()){
                arrayLists.add(integers);
            }
            if (!integers1.isEmpty()){
                arrayLists.add(integers1);
            }
        }
        System.out.println(arrayLists);
        return arrayLists;
    }

    /*
     * 测试入口
     * @param args
     */
    /*public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        root.left = root2;
        root.right = root3;
        root.left.left = root4;
        root.left.right = root5;
        root.right.left = root6;
        root.right.right = root7;
        new Tree5().Print(root);
    }*/

    /*
     * define a Tree Class
     * */
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
