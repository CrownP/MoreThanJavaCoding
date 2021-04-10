package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/06 21:25
 */
public class Code1_02_SelectionSort {
    /**
     * 【实现思路】
     * 1、0到length-1范围中选择一个最小的数放在0上
     * 2、1到length-1范围中选择一个最小的数放在1上
     * 3、重复上述操作，时间复杂度为O（n^2）
     */

    public static void selectionSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        // 范围， 0~n-2
        for (int i = 0; i < array.length - 1; i++) {
            //一次遍历找到最小值的index
            int minIndex = i;
            //此时范围为 1~n-1
            for (int j = i + 1; j <= array.length - 1; j++) {

                /*if (array[j] < array[minIndex]) {
                    minIndex = j;
                }*/
                minIndex = array[j] < array[minIndex] ? j : minIndex;
            }
            //将最小值放到最左边
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }


    }

    public static void main(String[] args) {
        int[] arr = Constant.array;
        selectionSort(arr);
        System.out.println(arr[4]);
    }
}
