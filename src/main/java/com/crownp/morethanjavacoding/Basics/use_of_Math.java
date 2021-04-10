package com.crownp.morethanjavacoding.Basics;

/**
 * @ClassName use_of_Math
 * @Description TODO
 * @Author qgp
 * @Date 2019/10/11 15:42
 * @Version 1.0
 **/
public class use_of_Math {
    public static void main(String[] args) {
        System.out.println("返回绝对值：" + Math.abs(-250));
        System.out.println("求开方：" + Math.sqrt(4));
        System.out.println("返回第一个参数的第二的参数的次方："+ Math.pow(2,4));
        System.out.println("返回随机数：" + Math.random()); // [0.0,1.0)

        System.out.println("四舍五入,返回double类型:"+ Math.rint(10.1));
        System.out.println("四舍五入,返回double类型:"+ Math.rint(10.5));
        System.out.println("四舍五入,返回double类型:"+ Math.rint(10.7));
        System.out.println("round四舍五入，float时返回int值，double时返回long值"+ Math.round(10.42));
        System.out.println("round四舍五入，float时返回int值，double时返回long值"+ Math.round(10.511));
        System.out.println("ceil天花板的意思，就是返回大的值的整数，注意一些特殊值"+ Math.ceil(-0.1));
        System.out.println("floor地板的意思，就是返回小的值的整数"+ Math.floor(-0.7));

        System.out.println("PI的常量：" + Math.PI);
        System.out.println("e的常量：" + Math.E);
        System.out.println("求e的任意次方：" + Math.exp(1));

        System.out.println("弧度转化为角度：" + Math.toDegrees(Math.PI/4)); //PI 180度对应的弧度
        System.out.println("角度转化为弧度：" + Math.toRadians(180));

        System.out.println("取余数：" + Math.IEEEremainder(9,2));
        System.out.println("求log10为底的对数" + Math.log10(100));
        System.out.println("log的自然对数，即以e为底" + Math.log(Math.E));

    }
}
