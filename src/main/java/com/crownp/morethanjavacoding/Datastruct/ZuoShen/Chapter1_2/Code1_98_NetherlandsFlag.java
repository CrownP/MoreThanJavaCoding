package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: 荷兰国旗问题
 * @Date: 2020/03/10 12:09
 */
public class Code1_98_NetherlandsFlag {


    /**
     * 【荷兰国旗问题】
     * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。
     * 要求额外空间复杂度O(1)，时间复杂度O(N)
     */
    public static void NetherlandsFlag(int[] arr, int num) {
        int less = -1;  // less代表小于区域
        int more = arr.length;  // more代表大于区域
        int cur = 0;  // 代表当前指向的数
        while (cur != more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
    }

    /**
     * 给定一个数组arr，和一个数num，请把小于等于num的数放在数
     * 组的左边，大于num的数放在数组的右边。
     * 要求额外空间复杂度O(1)，时间复杂度O(N)
     */
    public static void two_partition(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int less = -1;  // 0~less 代表小于等于区域，初始时没有所以为-1
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] <= num) {
                swap(arr, ++less, i);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        /*int[] arr = new int[]{1, 3, 5, 7, 4};
        two_partition(arr, 5);
        printArray(arr);*/
        /*int[] arr = new int[]{5,1,1,2,4,5,6,7,8,9};
        NetherlandsFlag(arr, 4);
        printArray(arr);*/
    }
}
