package com.crownp.morethanjavacoding.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/05 20:41
 */
public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String[] strings = string.split(" ");
        Stack<String> stringStack = new Stack<>();
        for (String s : strings) {
            stringStack.push(s);
        }
        while (!stringStack.empty()) {
            System.out.print(stringStack.pop() + " ");
        }
    }
}
