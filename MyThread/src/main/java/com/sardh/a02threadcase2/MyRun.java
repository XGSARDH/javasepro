package com.sardh.a02threadcase2;

public class MyRun implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "This a runnable.");
    }
}
