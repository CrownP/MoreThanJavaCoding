package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/18 15:37
 */
public class Tree4 {
    /**
     * 【按之字形顺序打印二叉树】面试题32题目三
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     * <p>
     * 【思路】
     * 设两个栈，s1存放奇数层，s2存放偶数层
     * 遍历s1节点的同时按照左子树、右子树的顺序加入s2，
     * 遍历s2节点的同时按照右子树、左子树的顺序加入s1
     */

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>(); // 定义返回的结果数组

        if (pRoot == null) {
            return arrayLists;
        }

        Stack<TreeNode> s1 = new Stack(); // 存放奇数层
        Stack<TreeNode> s2 = new Stack(); // 存放偶数层
        s1.push(pRoot); // 存在根节点，把根节点放在奇数层

        // s1或者s2不空的时候，进入while循环
        while (!s1.empty() || !s2.empty()) {
            // 如果s1不为空，先pop出来并且存到s2。pop完以后s2就不是空了
            ArrayList<Integer> integers = new ArrayList<>(); //存放奇数层
            ArrayList<Integer> integers1 = new ArrayList<>(); //存放偶数层
            while (!s1.empty()) {
                TreeNode treeNode = s1.pop();
                if (treeNode.left != null) {
                    s2.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    s2.push(treeNode.right);
                }
                integers.add(treeNode.val);
            }
            if (!integers.isEmpty()){
                arrayLists.add(integers);
            }

            // 如果s2不为空

            while (!s2.empty()) {
                TreeNode treeNode1 = s2.pop();
                if (treeNode1.right != null) {
                    s1.push(treeNode1.right);
                }
                if (treeNode1.left != null) {
                    s1.push(treeNode1.left);
                }
                integers1.add(treeNode1.val);
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
   /* public static void main(String[] args) {
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
        System.out.println(root.left.left.val);
        new Tree4().Print(root);
    }*/


    /*
     * define a treeNode Class
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
