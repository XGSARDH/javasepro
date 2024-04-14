package com.reflection;

public class Test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    // 最后结果是100,是因为100的赋值在后
    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}