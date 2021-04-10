package com.crownp.morethanjavacoding.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description 获取全组合的算法设计，例输入 1，2，4，8 ； 返回1、2、3、4、5、6、7 。
 * @Author qgp
 * @Date 2019/10/23 16:33
 **/
public class FullAssemblyUtil {
    public static void main(String[] args) {
        int num = 8;
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 4, 8));
        System.out.println(getFullAssembly(list, num).toString());

    }


    public static List<Integer> getFullAssembly(List<Integer> list, int n) {
        //去掉元素n
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next() == n) {
                iter.remove();
            }
        }

        List<Integer> list1 = new ArrayList<>();
        int size = list.size();
        for (int i = 1; i <= (1 << size) - 1; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    count += list.get(j);
                }
            }
            System.out.println(count);
            list1.add(count);
        }
        //Collections.sort(list1);
        return list1;
    }
}
