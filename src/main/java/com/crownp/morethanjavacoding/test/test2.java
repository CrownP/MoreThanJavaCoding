package com.crownp.morethanjavacoding.test;

import java.util.Scanner;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/10 19:38
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int target = scanner.nextInt();
        int head = 1;
        while (head != target) {
            int tail = head + 1;
            while (tail != target + 1) {
                if ((tail + head) * (tail - head + 1) / 2 == target) {
                    break;
                }
                tail++;
            }
            if ((tail + head) * (tail - head + 1) / 2 == target) {
                for (int i = head; i <= tail; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            head++;

        }
    }
}
