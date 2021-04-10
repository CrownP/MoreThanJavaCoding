package com.crownp.morethanjavacoding.Basics;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName jdk8_newFeature
 * @Description TODO
 * @Author qgp
 * @Date 2019/10/25 10:08
 * @Version 1.0
 **/
public class jdk8_newFeature {
    public static void main(String[] args) {
        lambda();
    }
    public static void lambda(){
        //遍历list集合
        System.out.println("遍历List集合:");
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.forEach((str) -> System.out.print(str + " "));
    }
}
