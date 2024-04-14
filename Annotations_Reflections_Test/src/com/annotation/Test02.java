package com.annotation;

import java.lang.annotation.*;

// 测试元注解
@MyAnnotation
public class Test02 {
    @MyAnnotation
    public void test(){

    }
}

// 定义一个注解
//ElementType.METHOD代表只能放在方法上
@Target(value = {ElementType.METHOD, ElementType.TYPE})

// RetentionPolicy 表示我们的注解在什么地方有效
// runtime > class > sources
@Retention(RetentionPolicy.RUNTIME)

// Documented 表示是否将我们的注解生成在JAVAdoc中
@Documented

// Inherited 子类可以继承父类中的该注解
@Inherited
@interface MyAnnotation{

}