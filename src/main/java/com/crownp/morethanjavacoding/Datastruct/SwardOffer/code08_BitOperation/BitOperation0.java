package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code08_BitOperation;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/26 22:01
 */
public class BitOperation0 {
    /**
     * 【二进制中1的个数】 面试题15
     * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
     * 【必备知识】
     * 计算机用二进制存储数字，有符号位，0正1负。
     * 正数的原码补码反码一样。负数反码全部取反，补码为其反码+1
     * 【思路】
     */
    public int NumberOf1(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count += 1;
            }
            n = n >>> 1;
        }

        return count;
    }

    public static void main(String[] args) {
        int n = new BitOperation0().NumberOf1(15);
        System.out.println(n);
    }
}
