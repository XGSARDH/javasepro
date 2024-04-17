package com.synchronizeddemo;

public class Mythread2 extends Thread {
    @Override
    public void run() {
        /*
        修改金钱的值为90000
         */

        synchronized (Money.class) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Money.money = 90000;
        }
    }
}
