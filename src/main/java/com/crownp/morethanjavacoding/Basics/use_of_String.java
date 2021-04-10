package com.crownp.morethanjavacoding.Basics;

/**
 * @Description String的一些常用方法
 * @Author qgp
 * @Date 2019/10/31 9:34
 **/
public class use_of_String {
    public static void main(String[] args) {
        String string = "abcde";
        String string1 = "AABBCC";
        System.out.println("string：" + string);
        System.out.println("string1：" + string1);

        System.out.println("返回string所指定的索引的字符：" + string.charAt(1));
        System.out.println("取出字符串内第int i到int j位置的字符串，区间为[}：" + string.substring(0,2));
        System.out.println("取出剩下子串：" + string.substring(1));
        System.out.println("将两字符串连接：" + string.concat(string1));
        System.out.println("测试string是否以de结尾：" + string.endsWith("de"));
        System.out.println("将字符串转化为byte字节数组：" + string.getBytes());
        System.out.println("将字符串转化为char字符数组：" + string.toCharArray());
        System.out.println("替代掉字符，所有都替代" + string1.replace("a","d"));

        System.out.println("小写变大写：" + string.toUpperCase());
        System.out.println("大写变小写：" + string1.toLowerCase());
    }

    /**
     int length()    返回字符串的长度
     char charAt (int index)     返回index所指定的字符
     String substring(int1,int2)     取出字符串内第int1位置到int2的字符串
     String concat(String str)   将两字符串连接
     boolean endsWith(String str)    测试字符串是否以str结尾
     boolean startsWith(String str)  测试字符串是否以str开始

     char[] getBytes     将字符串转换成字节数组返回
     char[] toCharArray  将字符串转换成字符数组

     String replace(char old ,char new)  将old用new替代
     String toLowerCase()    将字符串内的字符改写成小写
     String toUpperCase()    将字符串内的字符改写成大写

     String valueOf(int index)   将数字index的内容用字符串表示

     String[] split(String str)//将str作为分隔符进行字符串分解，分解后的字字符串在字符串数组中返回。
     contains(String str)//判断参数s是否被包含在字符串中，并返回一个布尔类型的值。
     String trim()//截去字符串两端的空格，但对于中间的空格不处理。
     public String replaceAll(String regex, String replacement)//该方法用字符replacement的内容替换当前字符串
                                中遇到的所有和字符串regex相匹配的子串，应将新的字符串返回。



     进制转换：使用Long类中的方法得到整数之间的各种进制转换的方法：
     Long.toBinaryString(long l)//二进制
     Long.toOctalString(long l)//十进制
     Long.toHexString(long l)//十六进制
     Long.toString(long l, int p)//p作为任意进制

     **/
}
