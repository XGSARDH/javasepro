package com.reflection;

// 测试类什么时候会初始化
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 1. 主动引用
        //Son son = new Son();

        //  反射产生主动引用
        //Class.forName("com.reflection.Son");

        // 不会产生类的引用的方法
        //System.out.println(Son.b);// 子类没有被初始化

        //Son[] array = new Son[5];// 父类和子类都没有被初始化, 这个并没有类的初始化,只是给了一片空间

        //System.out.println(Son.M);// 父类和子类都没有被初始化

    }
}

class Father{
    static  int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;

    static final int M = 1;

}