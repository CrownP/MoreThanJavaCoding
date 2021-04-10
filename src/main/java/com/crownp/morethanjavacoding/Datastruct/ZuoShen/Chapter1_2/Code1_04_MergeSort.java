package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter1_2;

/**
 * @Author: crownp
 * @Description: 归并排序
 * @Date: 2020/03/07 0:22
 */
public class Code1_04_MergeSort {
    /*
    * 【归并排序流程】
    * 1.递归函数包含了，将其划分为左右两部分，以及 调用merge函数对这两个子过程排序
    * 2.merge函数排序的过程是，创建辅助数组，p1指针指向第一个字过程的左边，p2指针指向第二个子过程的左边
    *       谁小把谁放进辅助数组里。
    * 3.递归函数的出口是：L=R，说明只有一个数，无需再分割
    *
    * */

    /* 这是一个主函数 */
    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        sortProcess(array, 0, array.length - 1);
    }

    /* 这是一个递归过程 */
    public static void sortProcess(int[] array, int L, int R) {
        //递归出口：L=R的时候，只有一个数了，不能再分了
        if (L == R) {
            return;
        }

        //分治。求出中点
        int mid = L + ((R - L) >> 2);  //相当于(L+R)/2
        sortProcess(array, L, mid); //两个子过程排好序
        sortProcess(array, mid + 1, R);

        //分治完两边以后，调用merge函数进行排序合并。
        merge(array, L, mid, R);
    }


    /* merge函数没有递归，就是迭代 */
    public static void merge(int[] array, int L, int mid, int R) {
        // 生成固定长度的辅助数组
        int[] help = new int[R - L + 1];

        // help数组索引
        int i = 0;

        // 定义 p1、p2 指针分别指向左边最左边和右边最左边
        int p1 = L;
        int p2 = mid + 1;


        // 当p1和p2都没有走到尽头的时候，才执行while循环
        while (p1 <= mid && p2 <= R) {
            if (array[p1] < array[p2]) {
                help[i++] = array[p1++];  //先赋值了，再++，即先执行 help[0] = array[p1]，然后在++
            } else {
                help[i++] = array[p2++];
            }
        }

        //有且只有一个越界的时候，把还没越界的复制到help数组里
        //如果p1没越界，潜台词是p2已经越界了。针对p2同理
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= R) {
            help[i++] = array[p2++];
        }

        //把help数组的元素拷贝回array数组的L到R
        for (int j = 0; j < help.length; j++) {
            array[L + j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{6,5,4,3,2,1};
        mergeSort(array);
        System.out.println(array[5]);
    }

}
