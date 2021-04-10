package com.crownp.morethanjavacoding.Basics;

import java.util.Scanner;

/**
 * @ClassName testof_switchCase
 * @Description TODO
 * @Author qgp
 * @Date 2019/10/8 9:35
 * @Version 1.0
 **/
public class testof_switchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        switch (i){
            case 0:
                System.out.println("星期日");
                break;
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            default:
                System.out.println("Null");
                break;
        }
    }
}
