package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: 冒泡排序
 * @Date: 2020/03/06 21:11
 */
public class Code1_01_BubbleSort {
    /**
     * 【算法思路】
     * 1、0到length-1范围中，0和1比较把大的数放在右边，然后1和2的比较一直到比较完，得到右边的数为最大的数
     * 2、然后0到length-2的范围中，继续上述操作
     * 3、时间复杂度为O（n^2）
     */

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int end = arr.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        final int[] ints = new int[]{1,4,2,5,6,3};
        bubbleSort(ints);
        System.out.println(ints[1]);
    }

}
