package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code11_ExamplesToAbstract;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/04 21:58
 */
public class ExampleToAbstract3 {
    /**
     * 【二叉搜索树的后序遍历序列】 面试题33
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 【思路】
     * 假设二叉搜索树的后序遍历为 {5,7,6,9,11,10,8}，发现根节点是8，然后左子树都比8小，右子树都比8大，
     * 然后就可以通过递归实现代码。
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    public boolean judge(int[] sequence, int start, int end) {
        //递归终止条件：数组长度为1
        if (start >= end) {
            return true;
        }
        //找到根节点
        int root = sequence[end];
        //找到左右子树分界点
        int i = start;
        while (sequence[i] < root) {
            ++i;
        }
        //判断右子树是否都比root大
        for (int j = i; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //递归调用判断左右子树
        return judge(sequence, start, i - 1) && judge(sequence, i, end - 1);
    }

    public static void main(String[] args) {
        int[] se = new int[]{5, 7, 6, 9, 11, 10, 8};
        Boolean b = new ExampleToAbstract3().judge(se, 0, se.length - 1);
        System.out.println(b);
    }
}
