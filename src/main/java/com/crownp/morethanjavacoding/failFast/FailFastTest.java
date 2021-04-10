package com.crownp.morethanjavacoding.failFast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName FailFastTest
 * @Description fail-fast案例测试和与案例分析
 * @Author qgp
 * @Date 2019/9/20 11:17
 * @Version 1.0
 **/

/**
 * 一、ArrayList环境下运行结果：
 * 抛出异常 java.util.ConcurrentModificationException ，即产生了fail-fast事件
 *
 *
 * 二、结果说明：
 * (01) FastFailTest中通过 new ThreadOne().start() 和 new ThreadTwo().start() 同时启动两个线程去操作list。
 *      ThreadOne线程：向list中依次添加0,1,2,3,4,5。每添加一个数之后，就通过printAll()遍历整个list。
 *      ThreadTwo线程：向list中依次添加10,11,12,13,14,15。每添加一个数之后，就通过printAll()遍历整个list。
 * (02) 当某一个线程遍历list的过程中，list的内容被另外一个线程所改变了；
 *      就会抛出ConcurrentModificationException异常，产生fail-fast事件。
 *
 *
 * 三、解决方法：
 * fail-fast机制，是一种错误检测机制。它只能被用来检测错误，因为JDK并不保证fail-fast机制一定发生。
 * 若在多线程环境下使用fail-fast机制的集合，建议使用“java.util.concurrent”包下对应的类即可。即，将代码
 * ----- private static List<String> list = new ArrayList<String>();
 * 替换为
 * ----- private static List<String> list = new CopyOnWriteArrayList<String>();
 * 则可以解决该错误。
 *
 *
 * 四、原理分析
 * 实际上原理就是ArrayList使用时存在两个标志，modCount 和 expectModCount ，当两者不一致时则抛出fail-fast；
 * 而ArrayList无论是add()、remove()、还是clear()，只要涉及到修改集合中元素的个数时，都会改变modCount的值；
 * 自然在多线程操作时，线程a遍历时，调用checkForComodification()比较 "expectModCount" 与 "modCount"的大小，
 *    而 前者等于N，后者由于被线程b修改变成 N+1 ，这样，就抛出了异常，产生了fail-fast事件
 *
 *
 * 五、分析CopyOnWriteArrayList源码如何避免fail-fast
 * (01) 和ArrayList继承于AbstractList不同，CopyOnWriteArrayList没有继承于AbstractList，它仅仅只是实现了List接口。
 * (02) ArrayList的iterator()函数返回的Iterator是在AbstractList中实现的；而CopyOnWriteArrayList是自己实现Iterator。
 * (03) ArrayList的Iterator实现类中调用next()时，会“调用checkForComodification()比较‘expectedModCount’和‘modCount’的大小”；
 *      但是，CopyOnWriteArrayList的Iterator实现类中，没有所谓的checkForComodification()，更不会抛出ConcurrentModificationException异常！
 *
 *
 * 更多查看 Iterable 与 ArrayList 源码，或者参考文章“http://wangkuiwu.github.io/2012/02/04/collection-04-fail-fast/”
 *
 */
public class FailFastTest {

    private static List<String> list = new ArrayList<>();

    //private static List<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args){
        // 同时启动两个线程对list进行操作
        new ThreadOne().start();
        new ThreadTwo().start();

    }


    /**
     * 打印list集合的私有方法
     */

    private static void printAll() {
        System.out.println();

        String value ;
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            value = (String) iter.next();
            System.out.println(value + ", ");
        }
    }


    /**
     * 向list中依次添加0，1，2，3，4，5，每添加一个数之后，就通过 printAll()遍历整个list
     */
    private static class ThreadOne extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i<6) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }


    /**
     * 向list中依次添加10，11，12，13，14，15，每添加一个数之后，就通过printAll()遍历整个list
     */
    private static class ThreadTwo extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i<16) {
                list.add(String.valueOf(i));
                printAll();
                i++;
            }
        }
    }


}
