package com.crownp.morethanjavacoding.Basics.ConcurrencyAndMultithreading;

/**
 * @Author: crownp
 * @Description: 嵌套锁死锁
 * @Date: 2020/03/05 16:46
 */
public class ThreadDeadlock1 {
    /**
     * 【Synchronized方式嵌套锁】
     * 线程Thread1先获取了LockA，然后在同步块里嵌套竞争锁LockB。而线程Thread2先获取锁LockB，然后在同步块里嵌套竞争锁LockA。
     * （此时LockA被Thread1占有，并且在等待LockB；而LockB被Thread2占有，并且在等待LockA。造成了死锁。）
     */
    public static void main(String[] args) {
        //创建对象锁A和B
        final Object LockA = new Object();
        final Object LockB = new Object();

        //创建线程1
        Thread thread1 = new Thread(() -> {
            //获取锁A
            synchronized (LockA) {
                try {
                    System.out.println("Thread1: now i got LockA");
                    //线程1 sleep的时候，不会释放对象锁，此时线程2获取到时间片运行并竞争了对象锁B。
                    //线程1超时等待自动唤醒后，想去竞争锁B，就会进入等待状态
                    Thread.sleep(10001);
                    synchronized (LockB) {
                        System.out.println("Thread1: now i got LockB");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //创建线程2
        Thread thread2 = new Thread(() -> {
            synchronized (LockB) {
                System.out.println("Thread2: now i got LockB");
                try {
                    Thread.sleep(10001);
                    synchronized (LockA) {
                        System.out.println("Thread2: now i got LockA");
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}
