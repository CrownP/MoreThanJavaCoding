package com.crownp.morethanjavacoding.Basics.ConcurrencyAndMultithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: crownp
 * @Description: 线程池死锁
 * @Date: 2020/03/05 19:01
 */
public class ThreadDeadlock2 {
    public static void main(String[] args) {

        final ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Long> f1 = executorService.submit(new Callable<Long>() {
            public Long call() throws Exception {
                System.out.println("start f1");
                Thread.sleep(1000);//延时

                Future<Long> f2 = executorService.submit(() -> {
                    System.out.println("start f2");
                    return -1L;
                });

                System.out.println("result" + f2.get());
                System.out.println("end f1");
                return -1L;
            }
        });

    }
}
