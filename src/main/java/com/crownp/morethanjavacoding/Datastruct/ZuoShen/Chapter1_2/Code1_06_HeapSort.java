package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

import java.util.Arrays;

/**
 * @Author: crownp
 * @Description: 堆排序
 * @Date: 2020/03/08 22:01
 */
public class Code1_06_HeapSort {

    /**
     * 堆排序，非常重要的数据结构。因为每一次操作数据后梳理为最大最小堆的时间复杂度都为logN，这是非常小的指标。
     * 堆排序时间复杂度O(N*logN)，额外空间复杂度为O(1)，堆是不稳定的排序算法
     */


    /* 主函数 */
    public static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        // 【从0到n-1遍历，构建最大堆】
        for (int i = 0; i <= array.length - 1; i++) {
            heapInsert(array, i);
        }

        // 【构建好最大堆以后，开始排序】
        int heapSize = array.length;  // 现在最大堆范围的长度
        swap(array, 0, --heapSize);  // 将0位置最大数与最后一个数交换，最大堆范围减少一个数
        while (heapSize > 0) {
            heapify(array, 0, heapSize);  // 把交换后的数组再变成一个最大堆
            swap(array, 0, --heapSize);  // 继续交换
        }

    }

    /* 构建最大堆的插入方法（实际是从后往前调整）  index:指向当前待比较的数字  */
    public static void heapInsert(int[] array, int index) {
        //如果待遍历数字比其父节点要大，与父节点交换
        while (array[index] > array[(index - 1) / 2]) {
            swap(array, index, (index - 1) / 2);  //该数字与父节点交换
            index = (index - 1) / 2;  // 交换以后，指针指向交换后的位置，继续比较是否比父节点大
        }
    }

    /* 从前往后调整成最大堆的方法。index：待交换的父节点；heapSize：堆的长度 */
    public static void heapify(int[] array, int index, int heapSize) {
        int left = index * 2 + 1;  //找到该节点的左孩子的索引
        int largest = 0;
        while (left < heapSize) {  // 不越界
            if (left + 1 < heapSize && array[left + 1] > array[left]) {  //如果left+1（即右孩子）存在且数值比左孩子大
                largest = left + 1;  // 最大值索引为右孩子
            } else {
                largest = left;  // 最大值索引为左孩子；
            }

            largest = array[index] < array[largest] ? largest : index;   // 如果index的值比largest，那么令 largest = index

            if (largest == index) {  // 说明此时index依然是最大的，不用交换和继续遍历执行，直接break
                break;
            }
            swap(array, index, largest); // 将index与左右孩子中最大一个交换
            index = largest;  // 进入下一轮循环的index
            left = index * 2 + 1;  // 进入下一轮循环的左孩子
        }
    }

    /* 交换函数 */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 4, 1, 6, 3, 4, 6, 87, 1};
        heapSort(array);
        Arrays.stream(array).forEach(System.out::println);
    }

}
