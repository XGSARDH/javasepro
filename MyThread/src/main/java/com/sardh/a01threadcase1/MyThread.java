package com.sardh.a01threadcase1;

public class MyThread extends Thread{
    @Override
    public void run() {
        // 书写线程要执行的代码
        System.out.println(getName() + "This a thread.");
    }
}
