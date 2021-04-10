package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code11_ExamplesToAbstract;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/04 16:41
 */
public class ExampleToAbstract2 {
    /**
     * 【从上往下打印二叉树】 面试题32
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 【思路做法】
     * 考察的是层数遍历，不能使用递归了。
     * 1.使用队列特性，先把根节点添加进队列
     * 2.出队列，判断是否有左右孩子，依次添加进队列里
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList arrayList = new ArrayList();
        if (root == null) {
            return arrayList;
        }
        //定义一个队列，遍历该队列，并依次把左右孩子添加到队列。遍历的节点的值便是结果。
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点添加进去
        queue.add(root);
        while (!queue.isEmpty()) {
            arrayList.add(queue.peek().val);

            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.poll();
        }
        return arrayList;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        ArrayList arrayList = new ExampleToAbstract2().PrintFromTopToBottom(treeNode1);
        System.out.println(arrayList);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
