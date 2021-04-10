package com.crownp.morethanjavacoding.Datastruct.ZuoShen.Chapter3_4;

public class Code3_08_ZigZagPrintMatrix {

	/**
	 *【之字形打印矩阵】
	 * 比如：
	 * 	 1 2 3
	 *	 4 5 6  ->  1,2,4,7,5,3,6,8,9
	 *	 7 8 9
	 *
	 *【思路】
	 * 先去两个点指向左上角，一个 向右、再向下移动；一个向下、再向右移动
	 */
	public static void printMatrixZigZag(int[][] matrix) {
		int a = 0;  //向右、再向下移动的点
		int b = 0;
		int c = 0;  //向下、再向右移动的点
		int d = 0;
		int endR = matrix.length - 1; //有多少行
		int endC = matrix[0].length - 1;  //有多少列
		boolean flag = false;  // flag为flase，从下往上打印
		while (a != endR + 1) {  // 如果等于就越界了，不用遍历了
			printLevel(matrix, a, b, c, d, flag);
			if (b == endC)
				a++;
			else
				b++;
			if (c == endR)
				d++;
			else
				c++;
			flag = !flag;

		}
		System.out.println();
	}

	public static void printLevel(int[][] matrix, int a, int b, int c, int d, boolean flag) {
		if (flag) {  // flase时，斜下打印
			while (a != c+1) {  // cd不动，ab会走到cd的位置，但如果超过一个了，就不行了会越界
				System.out.print(matrix[a++][b--] + " ");
			}
		} else {  // true,就斜上打印
			while (d != b+1) {  // ab不动，
				System.out.print(matrix[c--][d++] + " ");
			}
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, {5, 6, 7, 8}, {9, 10, 11, 12}};
		printMatrixZigZag(matrix);

	}

}
