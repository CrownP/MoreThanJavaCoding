package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code07_RecursionAndLoops;

/**
 * @Author: crownp
 * @Description: TODO
 * @Date: 2020/02/26 20:37
 */
public class RecursionAndLoops1 {
    /**
     * 【跳台阶】 面试题10题目二
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 【思路】
     * 把n级台阶的跳法看成n的函数，记为f(n)。
     * 当n大于2的时候，第一次的跳的跳法有两种，要么跳1级、要么跳2级，此时跳法数目等于后面的f(n-1)种。
     * 所有，不难看出这是一个斐波那契数列。 f(n) = f(n-1) + f(n-2)
     */

    public int JumpFloor(int target) {
        // 符合斐波那契数列
        int third = 0; //最终的数
        int first = 1;
        int second = 2;
        if (target == 1 || target == 0) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        for (int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


    /**
     * 【变态跳台阶】 面试题10题目二变种
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 【思路】
     * 用数学归纳法可以证明 f(n)=2*f(n-1)  记住公式吧！！！
     */
    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }


    /**
     * 【矩形覆盖】 跳台阶变种，依旧是斐波那契数列
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 【思路】
     * 假如n为8，即用8个2*1的矩形来覆盖2*8的大矩形。
     * 先把2*8的矩阵的覆盖方法，记为f(8)。用第一个1*2矩形覆盖最左边时，有两种方法要么竖着放要么横着放。
     * 如果竖着放，那么剩下，f(7)种；
     * 如果横着放，那么还必须有一个横着放，剩下f(6);
     * 所以，依旧是一个斐波那契数列，f(n) = f(n-1) + f(n-2)
     */
    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target-1) + RectCover(target-2);  // 递归做法，时间复杂度差。循环做的话为O(n)
    }
}
