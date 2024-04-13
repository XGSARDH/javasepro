package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// 动态地创建对象, 通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 获得Class对象
        Class c1 = Class.forName("com.reflection.User");

        // 构造一个对象
        User user = (User) c1.getDeclaredConstructor().newInstance(); // 本质是调用了类的无参构造器
        System.out.println(user);

        // 通过构造器构造对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("1", 1, 18);
        System.out.println(user2);

        // 通过反射调用普通方法
        User user3 = (User) c1.getDeclaredConstructor().newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "Test_user3");
        System.out.println(user3.getName());

        // 通过反射操作属性
        User user4 = (User) c1.getDeclaredConstructor().newInstance();
        Field name = c1.getDeclaredField("name");

        // 不能直接操作私有属性, 我们需要关闭程序的安全检测
        name.setAccessible(true);
        name.set(user4, "Test_user4");
        System.out.println(user4.getName());

    }
}
