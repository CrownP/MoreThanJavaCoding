package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code07_RecursionAndLoops;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/24 21:44
 */
public class RecursionAndLoops0 {
    /**
     * 【斐波那契数列】 面试题10
     * 题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39。
     * <p>
     * 提示：斐波那契数列 0、1、1、2、3、5...... 即 f(n) = f(n-1) + f(n-2) n>1 , 从第0项开始
     */


    //【改进的方法】从下往上计算，这种思路的时间复杂度是O(n)
    public int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 0;
        for (int i = 2; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    //【简单递归做法】面试官不希望看到的，效率低，重复元素多，容易栈溢出
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }


    /*public static void main(String[] args) {
        int a = new RscursionAndLoops0().Fibonacci1(5);
        System.out.println(a);
    }*/
}
