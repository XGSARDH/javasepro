package com.sardh;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        /*
        public static ExecutorService newCachedThreadPool()
        public static ExecutorService newFixedThreadPool(int nThread)
        */

        // 1. 获取线程池对象
        ExecutorService pool1 = Executors.newCachedThreadPool();

        // 2. 提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        // 3. 销毁线程池
        // pool1.shutdown();

        // 1. 获取线程池对象
        ExecutorService pool2 = Executors.newFixedThreadPool(1);

        // 2. 提交任务
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());
        pool2.submit(new MyRunnable());

    }

}
