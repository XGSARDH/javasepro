package com.synchronizeddemo;

public class Mythread1 extends Thread {
    @Override
    public void run() {
        /*
        检测金钱是否为100000
         */
        while(true) {
            synchronized (Money.class) {
                if(Money.money != 100000) {
                    System.out.println("Money is no longer 100000");
                    break;
                }
                else {
                    System.out.println("Money is 100000");
                }
            }
        }
    }
}

