package com.crownp.morethanjavacoding.Basics;

/**
 * @ClassName String_StringBuilder_StringBuffer
 * @Description TODO
 * @Author qgp
 * @Date 2019/9/20 14:35
 * @Version 1.0
 **/
public class String_StringBuilder_StringBuffer {
    /**
     * 1.String对象: 使用final修饰的字符串数组存储，不可变，是线程安全的
     *
     * 2.StringBuilder：线程不安全的
     *
     * 3.StringBuffer：对方法加了同步锁，或者对调用的方法加了同步锁，所以是线程安全的
     *
     * 性能分析：
     *     每次对String类型进行改变的时候，都会生成一个新的String对象，然后将指针指向新的String对象。
     *     StringBuffer每次都是对自身对象进行操作，而不是生成新的对象并改变对象引用。
     *     相同情况下使用StringBuilder相比使用StringBuffer仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。
     *
     * 总结：
     *     操作少量数据，适合用String。
     *     单线程操作字符串缓冲区下操作大量数据，适合用StringBuilder
     *     多线程操作字符串缓冲区下操作大量数据，适合StringBuffer
     */
}
