package com.crownp.morethanjavacoding.Datastruct.SwardOffer.Other;

/**
 * @Author: crownp
 * @Description: 面试思路
 * @Date: 2020/03/04 1:03
 */
public class InterviewThinking {
    /**
     * 【二叉树的镜像】 面试题27
     * 操作给定二叉树，将其变换为源二叉树的镜像。
     * <p>
     * 【思路】
     * 递归方式前序遍历二叉树的每个节点，如果遍历到的节点有子节点，就交换它的子节点。
     */

    public void Mirror(TreeNode root) {
        // 根节点为空了，返回
        if (root == null) {
            return;
        }
        // 左右孩子都为null，返回
        if (root.left == null && root.right == null) {
            return;
        }
        // 否则就是左右孩子有一个为null或均不为null
        if (root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        //递归遍历左右孩子
        Mirror(root.left);
        Mirror(root.right);

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
