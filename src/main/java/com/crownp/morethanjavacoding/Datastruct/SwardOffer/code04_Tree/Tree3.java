package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/18 14:32
 */
public class Tree3 {
    /**
     * 【对称的二叉树】面试题28
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * <p>
     * 【思路】
     * 一、递归。对称条件：（1）左右子树的根节点的值相等；（2）root.left.left == root.right.right ; root.left.right == root.right.left
     * 二、利用DFS深度优先搜索算法 （未学习）
     * 三、利用BFS广度优先搜索算法 （未学习）
     */


    /**
     * 【解法一：递归】
     *
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetricalRecursion(pRoot.left, pRoot.right);
    }

    boolean isSymmetricalRecursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 如果一个为null，一个不为null，肯定不镜像相等
        if (left == null || right == null) {
            return false;
        }
        // 为镜像的条件
        return left.val == right.val  //左右节点值相等
                && isSymmetricalRecursion(left.left, right.right)
                && isSymmetricalRecursion(left.right, right.left);
    }


    /*
     * DFS使用stack来保存成对的节点
     * 1.出栈的时候也是成对成对的 ，
     * 1.若都为空，继续；
     * 2.一个为空，返回false;
     * 3.不为空，比较当前值，值不等，返回false；
     * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
    boolean isSymmetricalDFS(TreeNode pRoot) {
        if (pRoot == null) return true;
        Stack<TreeNode> s = new Stack<>();
        s.push(pRoot.left);
        s.push(pRoot.right);
        while (!s.empty()) {
            TreeNode right = s.pop();//成对取出
            TreeNode left = s.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.push(left.left);
            s.push(right.right);
            s.push(left.right);
            s.push(right.left);
        }
        return true;
    }


    /*
     * BFS使用Queue来保存成对的节点，代码和上面极其相似
     * 1.出队的时候也是成对成对的
     * 1.若都为空，继续；
     * 2.一个为空，返回false;
     * 3.不为空，比较当前值，值不等，返回false；
     * 2.确定入队顺序，每次入队都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
    boolean isSymmetricalBFS(TreeNode pRoot) {
        if (pRoot == null) return true;
        Queue<TreeNode> s = new LinkedList<>();
        s.offer(pRoot.left);
        s.offer(pRoot.right);
        while (!s.isEmpty()) {
            TreeNode left = s.poll();//成对取出
            TreeNode right = s.poll();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            //成对插入
            s.offer(left.left);
            s.offer(right.right);
            s.offer(left.right);
            s.offer(right.left);
        }
        return true;
    }


    // define a tree class
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
