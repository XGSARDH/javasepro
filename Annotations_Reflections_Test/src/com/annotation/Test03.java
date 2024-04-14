package com.annotation;

import javax.lang.model.element.Element;
import java.lang.annotation.*;

// 自定义注解
public class Test03 {

    // 注解可以显示赋值, 如果没有默认值, 我们就必须给注解赋值
    // 注解参数没有顺序
    @MyAnnotation2(name = "", school = {"1", "2"})
    public void test01(){

    }

    @MyAnnotation3("0")
    public void test02(){

    }
}

/**
 * @author SARDH
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数 : 参数类型 + 参数名
    String name() default "";
    int age() default 0;
    int id() default -1;// 如果默认值为-1, 代表不存在
    String[] school() default {"1", "2"};

}

/**
 * @author SARDH
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}

