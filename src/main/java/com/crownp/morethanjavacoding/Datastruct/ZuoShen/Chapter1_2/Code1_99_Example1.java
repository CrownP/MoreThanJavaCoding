package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/08 23:53
 */
public class Code1_99_Example1 {
    /**
     * 【题目：】
     * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序.
     *
     * 【思路】
     * 1.遍历数组找到最大最小值。定义三个数组的n+1个桶，包含了boolean、min、max；该桶是否存过数、最小值、最大值
     * 2.遍历数组，把每一个数放到对应的桶中。桶的划分是按数的范围划分，比如最小值0最大值99，有10个桶，0号桶存0~9的数
     * 3.从0号桶的下号桶开始，找到一个非空的桶与离它最近的左边的非空的桶，计算当前最小值减去前一个的最大值，并用全局变量保存，直到遍历完。
     *
     */

    public static int maxGap(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int len = array.length;
        int min = Integer.MAX_VALUE;   //最小值初始化为最大，目的是为了比较找出最小
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {  //找到最小值和最大值
            min = Math.min(min, array[i]);
            max = Math.max(max, array[i]);
        }
        if (max == min) {    //如果最大值等于最小值，说明只有一种数，返回0
            return 0;
        }

        // 定义三种桶信息,桶的长度为 n+1 。每一个桶包含了三个信息：是否放过元素、最小值、最大值
        boolean[] hasNum = new boolean[len + 1];
        int[] mins = new int[len + 1];
        int[] maxs = new int[len + 1];

        // 在遍历一遍，并把数组放到对应桶号里
        int bucketNum = 0;
        for (int i = 0; i < len; i++) {
            bucketNum = getBucketNum(array[i], len, min, max);
            mins[bucketNum] = hasNum[bucketNum] ? Math.min(mins[bucketNum], array[i]) : array[i]; //如果没存过元素，直接存
            maxs[bucketNum] = hasNum[bucketNum] ? Math.max(maxs[bucketNum], array[i]) : array[i]; //如果存过元素，找到最大或最小的
            hasNum[bucketNum] = true;  //将该桶号置位ture，说明已经存过元素了
        }

        // 找到每一个非空桶和离它最近的左边的非空桶，用当前最小减前一个的最大
        int maxGap = 0;  // 定义全局变量最大差值
        int lastMax = maxs[0];  //0号桶最大的值。从0号桶开始，0号和n-1号绝对不为空桶
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                maxGap = Math.max(maxGap, mins[i] - maxs[lastMax]);
                lastMax = maxs[i];
            }
        }

        return maxGap;
    }

    /* 确定一个数来自于第几号桶的方法 */
    public static int getBucketNum(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
