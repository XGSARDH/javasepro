package com.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 获取系统类加载器的父类加载器-->拓展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        // 获取拓展类加载器的父类加载器-->根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        // 测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        // 测试JDk内置的类是谁家在的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        // 如何获取系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        // C:\Users\SARDH\IdeaProjects\javasepro\out\production\Annotations_Reflections
        // JDk1.8可以看到很多路径
        // 双亲委派机制

    }

}
