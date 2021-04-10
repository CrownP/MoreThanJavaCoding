package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/18 1:12
 */
public class Tree2 {
    /**
     * 【二叉树的下一个结点】面试题8
     * 给定一个二叉树和其中一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的节点不仅包含左右子结点，同时包含指向父节点的指针。
     * <p>
     * 【思路】 结合树图分析
     * 1、二叉树为null，返回空
     * 2、若pNode存在右孩子：找到右子树最左边的一个结点便是所要的结点。直接判断当前节点的left节点是否为null
     * 3、若pNode不存在右孩子：
     *  是父节点的的左孩子，那么父节点便是下一个结点
     *  若不是，将当前结点指向其父节点，进入while循环继续判断
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 二叉树为null判断
        if (pNode == null) {
            return null;
        }

        // 如果有右子树，找右子树最左边的结点
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }

        // 如果没有右子树，找父节点
        while (pNode.next != null) {
                // 如果当前节点是父节点的左孩子，返回父节点
            if (pNode == pNode.next.left) {
                return pNode.next;
            } else {
                // 否则就往上找其父节点
                pNode = pNode.next;
            }
        }
        //  退回根节点还没找到，返回null，说明这个结点是尾结点没有下一个结点。
        return null;
    }


    // define a Tree
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父节点的指针。卧槽！！！无情！！

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
