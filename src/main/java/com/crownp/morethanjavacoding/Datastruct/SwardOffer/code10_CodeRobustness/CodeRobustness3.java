package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code10_CodeRobustness;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/03 23:26
 */
public class CodeRobustness3 {
    /**
     * 【树的子结构】 面试题26
     * 输入两颗二叉树A、B，判断B是不是A的
     *
     * 【思路总结】
     * 1、方法一前序递归遍历root1的树，如果根 root1.val==root2.val 、调用方法二
     * 2、方法二前序递归遍历以root1和root2作为根节点的左孩子与右孩子；（大问题化为小问题）
     * 3、递归出口： 1) root2为空，顺利匹配直到root2遍历完了，返回true
     *              2) root1为null，root1遍历完root2还没遍历完，返回flase
     *              3) root1.val ！= root2.val ，返回false
     */

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        Boolean result = false;
        //当 root1 和 root2 都不为0的时候才进行比较
        if (root1 == null || root2 == null) {
            return false;
        }
        //当root1的值与root2的值相等的时候，调用方法HasSubtree1来判断root1的孩子节点的值是否与root2的相等
        if (root1.val == root2.val) {
            result = HasSubtree1(root1, root2);
        }
        //如果前面返回的result为false，说明没匹配成功。接着遍历root1的左孩子、右孩子
        if (!result) {
            result = HasSubtree(root1.left, root2);
        }
        if (!result) {
            result = HasSubtree(root1.right, root2);
        }
        //返回结果
        return result;
    }


    public boolean HasSubtree1(TreeNode root1, TreeNode root2) {
        //如果root2已经遍历完了还能匹配的上，返回true
        if (root2 == null) {
            return true;
        }
        //如果root1遍历完了，root2还没遍历完，返回flase
        if (root1 == null) {
            return false;
        }
        //如果root1与root2出现值不相等的情况了，返回flase
        if (root1.val != root2.val) {
            return false;
        }
        //通过递归同时遍历以root1与root2位根节点的子树。始终是通过根左右的方式来遍历
        return HasSubtree1(root1.left, root2.left) && HasSubtree1(root1.right, root2.right);
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
