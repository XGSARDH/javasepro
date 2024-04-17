package com.synchronizeddemo;

public class SynchronizedDemo {

    public static void main(String[] args) {
        Mythread1 t1 = new Mythread1();
        Mythread2 t2 = new Mythread2();

        t1.start();
        t2.start();

    }

}


