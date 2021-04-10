package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

import java.util.Arrays;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/17 22:42
 */
public class Tree1 {
    /**
     * 【重建二叉树】 面试题7
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假定输入的前序遍历和中序遍历的结果中都不包含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * <p>
     * 【思路】
     * 1、既然是树，那么就是要用递归了。把左右子树分别按在其根节点上。
     * 2、数组就要判断边界
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        // 数组不能为0
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        // 根节点
        TreeNode rootNode = new TreeNode(pre[0]);

        // 数组长度为1时，直接返回一个root
        if (pre.length == 1) {
            return rootNode;
        }

        // 获取中序的根节点的位置
        int rootMinIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                rootMinIndex = i;
                break;
            }
        }

        // 然后把左右子树通过递归的思想，安在根节点上 。Range范围，copyOfRange按范围复制，左闭右开。
        rootNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootMinIndex + 1), Arrays.copyOfRange(in, 0, rootMinIndex));
        rootNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootMinIndex + 1, pre.length), Arrays.copyOfRange(in, rootMinIndex + 1, in.length));
        return rootNode;
    }


    // 测试入口
    /*public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        new Tree1().reConstructBinaryTree(pre, in);
    }*/


    //Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


