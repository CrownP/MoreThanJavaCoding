package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code11_ExamplesToAbstract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/04 23:24
 */
public class ExampleToAbstract4 {
    /**
     * 【二叉树中和为某一值的路径】 面试题34
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     * 【总结】
     * 这道题不好做，思路是有的，但很难写出好的代码来
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        FindPathCore(root,target,integers,result);

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()<o2.size()){
                    return 1;
                }else return -1;
            }
        });

        return result;
    }

    private void FindPathCore(TreeNode root, int target, ArrayList<Integer> integers, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        }
        int value = root.val;
        integers.add(value);
        if (target == value && root.left==null && root.right== null) {
            result.add(new ArrayList<>(integers));
        } else {
            FindPathCore(root.left,target-value,integers,result);
            FindPathCore(root.right,target-value,integers,result);
        }

        integers.remove(integers.size()-1);
    }




    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(12);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(7);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;

        ArrayList<Integer> integers = new ArrayList<>();

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
