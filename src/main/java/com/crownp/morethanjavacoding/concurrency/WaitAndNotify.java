/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.crownp.morethanjavacoding.concurrency;

/**
 * @Author: qinguanpu
 * @Date: 2021/04/20 19:24
 */
public class WaitAndNotify {

    public static volatile Object lockA = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("thread1 get lockA");

                    try {
                        System.out.println("thread1 start wait...");
                        lockA.wait();
                        System.out.println("thread1 end wait...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("thread2 get lockA");
                try {
                    System.out.println("thread2 start wait...");
                    lockA.wait();
                    System.out.println("thread2 end wait...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("thread3 start notify...");
                lockA.notify();
                System.out.println("thread3 end notify...");
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(1000);
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("main thread over!");

    }
}
