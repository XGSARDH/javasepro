package com.sardh.a03threadcase3;

import com.sardh.a02threadcase2.MyRun;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo_create03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 多线程的第三种启动方式:
         *      特点: 可以获取到多线程运行的结果
         *      1. 创建一个类MyCallable实现Callable接口
         *      2. 重写call (是有返回值的, 表示多线程运行的结果)
         *
         *      3. 创建MyCallable的对象 (表示多线程要执行的对象)
         *      4. 创建FutureTask的对象 (作用管理多线程运行的结果)
         *      5. 创建Thread的对象, 并启动 (表示线程)
         *
         */

        MyCallable myCallable = new MyCallable();

        FutureTask<Integer> integerFutureTask = new FutureTask<>(myCallable);

        Thread thread = new Thread(integerFutureTask);

        thread.start();

        Integer integer = integerFutureTask.get();
        System.out.println(integer);

    }

}
