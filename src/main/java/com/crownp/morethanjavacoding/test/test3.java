package com.crownp.morethanjavacoding.test;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/10 20:49
 */
public class test3 {
    /**
     * 时间复杂度依然是n^2
     * @param array
     * @param target
     */
    public static void getTwoNum1(int[] array, int target) {
        int p1 = 0;
        int p2 = 1;
        Boolean flag = false;
        while (p1 != array.length - 1) {
            if (p2 != array.length) {
                if ((array[p1] + array[p2]) == target) {
                    System.out.print(array[p1] + " " + array[p2] + ", ");
                    p2 = p1 + 1;
                    p1++;
                    flag = true;
                } else {
                    p2++;
                }
            } else {
                p2 = p1 + 2; // 由于这一步，理论上时间复杂度依然是O(n^2)
                p1++;
            }

        }

        if (!flag) {
            System.out.println("[-1,-1]");
        }
    }


    /**
     * 这个方法，时间复杂度为O(N*logN)
     * @param array
     * @param target
     */
    public static void getTwoNum2(int[] array, int target) {
        int fir = 0; //第一个数索引
        int sec = 1; //第二个数索引
        int end = array.length-1; //最后一个数索引
        while (fir != end) { //如果fir到end，跳出循环。这个操作时间复杂度O(N)
            int target2 = target-array[fir]; //现在找这个数，通过二分法查找，时间复杂度O(logN)

        }
    }

    // 二分法查找数组中的某个数
    public static Integer getTwoNum2Core(int[] array, int sec,int end,int target2) {

        while (sec<=end) {
            int mid = (sec+end)/2;
            if (array[mid] == target2) {
                return array[mid];
            } else if (array[mid] < target2) {
                sec = mid+1;
            } else {
                end = mid-1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 9, 10, 13};
        int target = 5;
        int sec = 0;
        int end = 4;
        int a = getTwoNum2Core(array,sec,end,target);
        System.out.println(a);
    }
}
