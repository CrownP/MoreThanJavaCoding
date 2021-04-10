package com.crownp.morethanjavacoding.Basics;

import java.util.Scanner;

/**
 * @ClassName use_of_scanner
 * @Description Scanner的用法详解
 * @Author qgp
 * @Date 2019/10/21 9:18
 * @Version 1.0
 **/
public class use_of_Scanner {

    /**
     * next()    一个一个字符串的读取
     * nextLine()   一行一行的读字符串
     */


    /**
     * 输入一个整数
     */
    public static void inputInt() {
        System.out.print("请输入一个整数：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println("您输入的整数为：" + num);
        System.out.println("----------");
    }

    /**
     * 按行输入字符串
     */
    public static void inputStringByline() {
        System.out.print("请输入字符串：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.print("你输入的字符串为：" + s);
        System.out.println("----------");
    }

    /**
     * 输入一个数组
     */
    public static void inputArray() {
        System.out.print("请输入一个数组：");
        Scanner scanner = new Scanner(System.in);
        String arrString = scanner.nextLine();
        String[] arr = arrString.split(" ");

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
        System.out.println("----------");
    }

    /**
     * 输入二维数组
     */
    public static void inputTwoArray() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[][] array = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                array[i][j] = in.nextInt();
            }
        }
    }

    /**
     * hasNext用法
     */
    public static void useOfHasnext() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextInt());
        }
    }

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(a);
        System.out.println(b);*/
        //inputInt();
        //inputStringByLine();
        //inputArray();
        useOfHasnext();
    }
}

