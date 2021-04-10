package com.crownp.morethanjavacoding.Datastruct.SwardOffer.Other;

import java.util.ArrayList;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/04 1:41
 */
public class DrawToAbstract {
    /**
     * 【顺时针打印矩阵】 面试题29
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     */
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        // 数组为null时返回null
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int x1 = 0; //指向左上角x坐标
        int y1 = 0; //指向左上角y坐标
        int x2 = matrix[0].length - 1; //指向右下角x坐标
        int y2 = matrix.length - 1; //指向右下角y坐标

        //循环终止条件。有限避免了非正方矩阵的情况
        while (x1 <= x2 && y1 <= y2) {

            // 左上角，从左到右
            for (int i = y1; i <= x2; i++) {
                arrayList.add(matrix[y1][i]);
            }
            // 从上到下
            for (int j = y1 + 1; j <= y2; j++) {
                arrayList.add(matrix[j][x2]);
            }
            // 如果y1=y2了就不处理了，避免重复
            if (y1 != y2) {
                // 右下角，从右到左
                for (int m = x2 - 1; m >= x1; m--) {
                    arrayList.add(matrix[y2][m]);
                }
            }
            if (x1 != x2) {
                // 接着从下到上
                for (int n = y2 - 1; n > y1; n--) {
                    arrayList.add(matrix[n][x1]);
                }
            }

            x1 = x1 + 1;
            y1 = y1 + 1;
            x2 = x2 - 1;
            y2 = y2 - 1;
        }

        return arrayList;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}, {2}, {3},{4},{5}};
        ArrayList arrayList = new DrawToAbstract().printMatrix(matrix);
        System.out.println(arrayList);
    }
}
