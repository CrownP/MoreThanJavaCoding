package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/19 0:00
 */
public class Tree7 {
    /**
     * 【二叉搜索树的第k个结点】面试题54
     * 给定一棵二叉搜索树，请找出其中第k小结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
     *
     * 【什么是二叉搜索树？】
     * 左节点比根节点小，右节点比根节点大叫二叉搜索树。
     *
     * 【思路：】
     * 二叉搜索树的中序遍历的结果可以是一个 递增的数组。中序为：2，3，4，5，6，7，8
     * 考察如何编写中序遍历代码
     * 方法一：递归中序
     * 方法二：非递归中序
     */


    /*一、递归遍历中序做法*/
    int index = 0;

    TreeNode treeNode = null;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k<1){
            return null;
        }
        KthNode(pRoot.left,k);
        ++index;
        if (index == k) {
            treeNode = pRoot;
        }
        KthNode(pRoot.right,k);
        return treeNode;
    }






    /*测试入口*/
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(2);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(8);
        root.left = root2;
        root.right = root3;
        root.left.left = root4;
        root.left.right = root5;
        root.right.left = root6;
        root.right.right = root7;

        TreeNode treeNode = new Tree7().KthNode(root,1);
        System.out.println(treeNode.val);
    }



    /*
     * define a TreeNode Class
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
