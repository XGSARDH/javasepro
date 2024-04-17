package com.volatiledemo;

public class Mythread1 extends Thread {
    @Override
    public void run() {
        /*
        检测金钱是否为100000
         */
        System.out.println("Money is 100000");
        while(Money.money == 100000) {
            // 第九行的句子不能放在这里
            // 在没有加上volatile前放在这里会导致可以读取到为90000的情况
        }

        System.out.println("Money is no longer 100000");
    }
}

