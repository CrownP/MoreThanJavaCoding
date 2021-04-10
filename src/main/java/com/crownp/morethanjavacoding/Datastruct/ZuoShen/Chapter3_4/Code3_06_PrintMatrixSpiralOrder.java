package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;


/**
 * 转圈打印矩阵数组。就是这么简单！！！
 */
public class Code3_06_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a <= c && b <= d) {
            printEdge(matrix, a++, b++, c--, d--);  //调用完一次后，a、b都+1指向对角线的下一个点，c、d同理，遍历这个新的矩阵。
        }
    }

    /* 交换方式 */
    public static void printEdge(int[][] m, int a, int b, int c, int d) {
        if (a == c) {  //如果a==c，说明只有一行，只打印这一行。完了以后 a++,b++ c-- d--，就不符合while条件了
            for (int i = b; i <= d; i++) {
                System.out.print(m[a][i] + " ");
            }
        } else if (b == d) {  //如果b=d，说明只有一列
            for (int i = a; i <= c; i++) {
                System.out.print(m[i][b] + " ");
            }
        } else {  //如果不是的话，打印4次
            int curB = b;  //因为a、b为全局变量还不能更改，所以定义新的变量来遍历
            int curA = a;
            // 确定行a，从左往后打印
            while (curB != d) {  // 当curB等于d的时候，说明准备到最后一列的时候，不打印了，然后从上往下
                System.out.print(m[a][curB] + " ");
                curB++;
            }
            // 确定列d，从上往下打印
            while (curA != c) {
                System.out.print(m[curA][d] + " ");
                curA++;
            }
            // 确定行c，从右往左打印
            while (curB != b) {
                System.out.print(m[c][curB] + " ");
                curB--;
            }
            // 确定列b，从下往上打印
            while (curA != a) {
                System.out.print(m[curA][b] + " ");
                curA--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }

}
