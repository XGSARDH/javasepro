package com.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// 获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.reflection.User");

        // 获得类的名字
        System.out.println(c1.getName());//获得包名 + 类名
        System.out.println(c1.getSimpleName());// 获得类名
        System.out.println("=========================");


        // 获得类的属性
        // 只能找到public属性
        Field[] fields = c1.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("-------------------------");

        // 获得类的属性
        // 可以找到全部属性
        fields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获得指定属性的值
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        // 获得类的方法
        System.out.println("=========================");
        // 获得本类及其父类的全部public方法
        Method[] methods = c1.getMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        System.out.println("-------------------------");
        // 获得本类的所有方法
        methods = c1.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method);
        }
        // 获得指定方法
        // 重载
        System.out.println("-------------------------");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println("-------------------------");
        System.out.println(setName);

        // 货期指定的构造器(构造函数)
        Constructor[] constructors = c1.getConstructors();
        System.out.println("=========================");
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println("-------------------------");
        constructors = c1.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(constructor);
        }


    }
}
