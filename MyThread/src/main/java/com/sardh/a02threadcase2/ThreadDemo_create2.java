package com.sardh.a02threadcase2;

public class ThreadDemo_create2 {
    public static void main(String[] args) {
        /**
         * 多线程的第一种启动方式:
         *  1. 自己实现一个类实现runnable接口
         *  2. 重写run方法
         *  3. 创建子类的对象
         *  4. 创建一个Thread类的对象, 并开启线程
         */

        // 创建MyRun的对象
        // 表示多线程要执行的任务
        MyRun myRun = new MyRun();

        // 创建线程对象
        Thread thread01 = new Thread(myRun);
        Thread thread02 = new Thread(myRun);

        // 给线程设置名字
        thread01.setName("线程1");
        thread02.setName("线程2");

        thread01.start();
        thread02.start();

    }
}
