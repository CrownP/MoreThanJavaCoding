/*
 * Copyright 2021 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.crownp.morethanjavacoding.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式
 * @Author: qinguanpu
 * @Date: 2021/04/20 14:47
 */
public class WaysToCreateThread {

    /**
     * 一、继承Thread类并重写run方法
     */
    public static class ExtendThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child Thread !");
        }

        public static void main(String[] args) {
            ExtendThread extendThread1 = new ExtendThread();
            extendThread1.start();
        }
    }

    /**
     * 二、实现Runnable接口的run方法
     */
    public static class RunnableTask implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread());
            System.out.println("I am a child Thread !");
        }

        public static void main(String[] args) {
            RunnableTask runnableTask = new RunnableTask();
            Thread thread1 = new Thread(runnableTask);
            thread1.start();
            new Thread(runnableTask).start();
        }
    }

    /**
     * 三、实现Callable接口，使用FutureTask方式
     */
    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return "hello";
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            // 创建异步任务
            FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
            // 启动线程
            Thread thread1 = new Thread(futureTask, "thread1");
            thread1.start();
            String result = futureTask.get();
            System.out.println(result);
        }
    }

}
