package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code04_Tree;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/18 22:32
 */
public class Tree6 {
    /**
     * 【序列化二叉树】面试题37
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 二叉树的序列化是指：把一颗二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立
     * 起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过某种符号表示空节点(#)，以 ！表示一个节点值的结束（value!）。
     *
     * 二叉树反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树
     *
     * 【思路】
     * 一、序列化根据前序遍历的方法转化成一个数组，空的用#号代理。 递归
     * 二、反序列化根据这个字符串数组重建二叉树。 递归
     *
     * 【总结】
     * 考察了前序遍历。
     * 递归递归。注意判断null、越界等异常
     */

    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        return Serialize1(root, sb);
    }

    String Serialize1(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1; //指示位置

    TreeNode Deserialize(String str) {
        if (str.isEmpty()){
            return null;
        }
        String[] strings = str.split(",");
        return Deserialize1(strings);
    }
    TreeNode Deserialize1(String[] strings) {
        ++index;
        System.out.println(strings[index]);
        // 如果是#号，说明是一个空节点，不用管，return null
        if (strings[index].equals("#")){
            return null;
        }
        // 不是空的节点，先创建root节点，然后递归方式把左右节点安上去，
        TreeNode root = new TreeNode(Integer.valueOf(strings[index]));  //这是根节点
        root.left = Deserialize1(strings); //首先left递归进去以后还有有递归，必须全部return返回了才到right。第一次递归，相当于在root的左孩子创建了2，然后分散了两个递归，依次类推
        root.right = Deserialize1(strings);
        return root;
    }


    /*
     * 测试入口
     * @param args
     */
   /* public static void main(String[] args) {
        // 前序为：
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

        String s = new Tree6().Serialize(root);
        System.out.println(s);
        TreeNode treeNode = new Tree6().Deserialize(s);
        System.out.println(treeNode.left.right.val);

    }*/


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
