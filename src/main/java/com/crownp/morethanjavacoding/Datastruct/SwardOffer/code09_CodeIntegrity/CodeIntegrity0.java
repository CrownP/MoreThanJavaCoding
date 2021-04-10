package com.crownp.morethanjavacoding.Datastruct.SwardOffer.code09_CodeIntegrity;

/**
 * @Author: crownp
 * @Description: 代码的完整性
 * @Date: 2020/02/28 20:28
 */
public class CodeIntegrity0 {
    /**
     * 【数值的整数次方】 面试题16
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0。
     *
     * 【思路】
     * 方法一：考虑完特殊情况外(指数是负数或者0，底数是0)，直接通过本身相乘这么多次数的方法。时间复杂度 O(n)
     * 方法二：递归，因为 2^n = 2^(n/2) * 2^(n/2) 。 时间复杂度为 O(logn)
     * 方法三：快速幂。1.写出指数的二进制表达，例如13表达为二进制1101。2.举例:10^1101 = 10^0001*10^0100*10^1000。
     */

    public double Power(double base, int exponent) {
        //1.全面考察指数的正负、底数是否为零等情况。
        //2.写出指数的二进制表达，例如13表达为二进制1101。
        //3.举例:10^1101 = 10^0001*10^0100*10^1000。
        //4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
        if (base == 0 && exponent > 0) {
            return 0.0;
        } else if (base == 0 && exponent < 0) {
            throw new RuntimeException("除0异常");
        }
        double result = 1.0;
        int n = Math.abs(exponent);
        //快速幂的方法
        while (n != 0) {
            if ((n & 1) != 0) { // 如果不是偶数，将result变成一个负数的值来计算
                result = base * result;
            }
            base *= base;
            n = n >> 1; // n除以2
        }
        return exponent > 0 ? result : 1 / result;
    }
}
