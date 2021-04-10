package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code06_SeekAndSort;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/23 15:49
 */
public class SeekAndSort0 {
    /**
     * 【旋转数组的最小数字】
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public int minNumberInRotateArray(int[] array) {

        // 方法二：二分法思想。时间复杂度为O(logn)
        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }

        return array[mid];

        // 做法一：直接从头到尾遍历，时间复杂度为O(n)。这样肯定是达不到面试要求的
        /*int index = 0;
        while (array[index] <= array[index + 1] && index + 1 < array.length) {
            ++index;
            if (index == array.length - 1) {
                return array[0];
            }
        }
        return array[index + 1];*/


        // 做法二：二分法做法
        /*int low = 0 ; int high = array.length-1;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (array[mid] > array[high]){
                low = mid+1;
            } else if (array[mid] == array[high]){
                high = high-1;
            } else {
                high = mid;
            }
        }
        return array[low];*/
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 5};
        int temp = new SeekAndSort0().minNumberInRotateArray(array);
        System.out.println(temp);
    }
}
