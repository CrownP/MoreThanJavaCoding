package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: 插入排序
 * @Date: 2020/03/06 21:58
 */
public class Code1_03_InsertSort {
    /**
     * 【插入排序实现思路】
     * 类似扑克牌整理牌的时候。
     * 1）0下标范围的数，不动
     * 2）0~1范围，比较大小，如果0比1大，交换
     * 3）0~2范围，先比较1和2，如果发生交换，再比较0和1
     * 4）依次类推
     *
     * 【时间复杂度】
     * 最好情况O(n)
     * 最坏情况O(n^2)
     */
    public static void insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        for (int i = 1; i <= array.length - 1; i++) {
            //i最左边的数，j是i的前一个数
            for (int j = i - 1; j >= 0 && array[j] > array[i]; j--) {

                // 异或交换两个变量的值，在没有申请新的空间的前提下
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];

            }
        }
    }

    public static void main(String[] args) {
        /*int[] array = Constant.array;
        insertSort(array);
        System.out.println(array[4]);*/
        int z = 1;
        z=z++;
        System.out.println(z);
        z = ++z;
        System.out.println(z);
    }
}
