package com.sardh.a01threadcase1;

public class ThreadDemo_create1 {

    public static void main(String[] args) {

        /**
         * 多线程的第一种启动方式:
         *  1. 自己定义一个类继承Thread
         *  2. 重写run方法
         *  3. 创建子类的对象, 并启动线程
         */

        MyThread myThread01 = new MyThread();
        MyThread myThread02 = new MyThread();
//        myThread.run(); // 这个仅仅是调用一个方法

        myThread01.setName("线程1");
        myThread02.setName("线程2");

        myThread01.start(); // 这个是开启一个线程
        myThread02.start(); // 这个是开启一个线程
    }


}






















