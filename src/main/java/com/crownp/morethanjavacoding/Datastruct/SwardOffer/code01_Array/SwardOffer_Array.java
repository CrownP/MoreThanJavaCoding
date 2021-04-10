package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code01_Array;

/**
 * @Author: crownp
 * @Description: 三道数组题目
 * @Date: 2020/02/08 16:13
 */
public class SwardOffer_Array {

    //【第一道】【二维数组中的查找】

    /**
     * 题目描述：
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean twoDimensionArray(int target, int[][] array) {
        int row = array[0].length;  //一个数组多少个数
        int column = array.length;  //有多少个数组
        int i = column - 1;
        int j = 0;
        // 先取左下角的数来比较，这样的时间复杂度是最小的。
        // 如果target比array[i][j]大，j++；否则，i--；
        while (i >= 0 && j <= row - 1) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }


    //【第二道】【数组中重复的数字】 3

    /**
     * 题目描述：
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * 思路：
     * 1.排序这个数组，时间复杂度为O(nlogn)
     * 2.利用哈希表，从头到尾扫描数组每个数，可用O(1)的时间判断哈希表中是否包含该数字；算法时间复杂度为O(n)，但以牺牲了O(n)的哈希表的空间来完成。
     * 3.
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (length <= 0) {
            return false;
        }
        for (int i = 0; i <= length - 1; i++) {

            if (numbers[i] == i) {
                // 如果下标与下标对应值相等，不作处理
            } else {
                // 如果不相等。
                while (numbers[i] != i) {
                    // 判断要交换的数是否重复
                    if (numbers[i] == numbers[numbers[i]]){
                        duplication[i] = numbers[i];
                        return true;
                    }
                    // 交换数字的操作
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
        }
        return false;
    }

    //【第三道】【构建乘积数组】 66 未完待续

    /**
     * 题目描述：
     *   给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     *   其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     */
    public boolean two(int target, int[][] array) {
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(arr[0][1]);
        System.out.println(arr.length);
        System.out.println(arr[0].length);
    }
}
