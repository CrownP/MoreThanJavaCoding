package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;


/**
 * 旋转正方形矩阵
 * 比如说:
 * 1 2 3        7 4 1
 * 4 5 6  --->  8 5 2
 * 7 8 9        9 6 3
 */
public class Code3_05_RotateMatrix {

    /* 主函数 */
    public static void rotate(int[][] matrix) {
        //定义两个点[0,0] 和 [n-1,n-1]，指向左上角和右上角
        int a = 0;
        int b = 0;
        int c = matrix.length - 1;
        int d = matrix[0].length - 1;
        while (a < c) {  //如果a=c，说明只剩下中间一个数，不用管
            rotateEdge(matrix, a++, b++, c--, d--);  // 调用交换函数进行处理
        }
    }

    /* 旋转方式的函数 */
    public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
        int times = d - b;  // d-b是列数差
        int tmp = 0; // 定义缓存变量，方便交换
        for (int i = 0; i != times; i++) {  //交换的次数
            tmp = m[a][b + i]; //缓存一个数。如果i是0，就是左上角的数
            m[a][b + i] = m[c - i][b];  // 比如说拿 1 3 9 7做例子，就是把7放到1的位置
            m[c - i][b] = m[c][d - i];
            m[c][d - i] = m[a + i][d];
            m[a + i][d] = tmp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }

}
