package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;


public class Code3_09_FindNumInSortedMatrix {

    /**
     * 【在行列都排好序的矩阵中找数】
     * 要求时间复杂度O(N+M) ,空间复杂度O(1)
     */
    public static boolean isContains(int[][] matrix, int K) {
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int i = row;
        int j = 0;
        while (i != -1 || j != col++) {  //这里边界条件，做错了！！！！！！！
            if (matrix[i][j] == K) {
                return true;
            }
            if (matrix[i][j] > K) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 18;
        System.out.println(isContains(matrix, K));
    }

}
