package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code09_CodeIntegrity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/03/02 0:21
 */
public class CodeIntegrity1 {
    /**
     * 【调整数组顺序使奇数位于偶数前面】 面试题21
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 【思路】
     * 1.遍历这个数组，奇数放在一个集合、偶数放在一个集合，然后再分别把其放回到数组里头
     */

    public void reOrderArray(int[] array) {
        List<Integer> ji = new ArrayList<>();
        List<Integer> ou = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                ou.add(array[i]);
            } else {
                ji.add(array[i]);
            }
        }
        int m = 0;
        for (Integer integer : ji) {
            array[m] = integer;
            m += 1;
        }
        for (Integer integer : ou) {
            array[m] = integer;
            m += 1;
        }
    }
}
