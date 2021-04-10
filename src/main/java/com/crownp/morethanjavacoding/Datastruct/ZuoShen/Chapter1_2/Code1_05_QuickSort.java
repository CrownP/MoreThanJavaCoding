package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: 快速排序
 * @Date: 2020/03/08 1:06
 */
public class Code1_05_QuickSort {

    /**
     * 经典快排的实现
     */

    /* 主函数 */
    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        quickSortCore(array, 0, array.length - 1);
    }

    /* 递归函数 */
    public static void quickSortCore(int[] array, int left, int right) {

        // 递归终止条件
        if (left >= right) {
            return;
        }

        /* partision操作 */
        int dp = left;  // 定义分界点 divide point。左边小于分界点，右边大于等于分界点
        for (int i = left; i < right; i++) {
            if (array[i] < array[right]) {  // 以右边的数为基准点pivot
                swap(array, dp++, i);  // 所有分界点左边的数都小于pivot，如果不小于则放最左边并让分界点向前挪一个
            }
        }
        swap(array, right, dp); // 基准数归位
        quickSortCore(array, left, dp - 1);
        quickSortCore(array, dp + 1, right);

    }


    /* 交换函数 */
    public static void swap(int[] array, int i, int j) {
        // 如果数字相同，异或会变成0
        /*array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];*/
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4, 7, 8, 9, 1, 4, 5, 2, 2};
        /**quickSort(array);
        for (int a : array) {
            System.out.println(a);
        }*/
    }


}
