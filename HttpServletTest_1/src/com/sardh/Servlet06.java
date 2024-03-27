package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  request作用域
 *      通过该对象可以子啊一个请求中船体数据. 作用范围:在一次请求中有效,即服务器端始终有效. (请求转发跳转即时有效)
 *
 */
@WebServlet("/s06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        System.out.println("Servvlet06");

        // 设置域对象内容

        // 获取域对象内容
        String name = (String) request.getAttribute("name");
        System.out.println(name);
        Integer age = (Integer) request.getAttribute("age");
        System.out.println("age" + age);
        List<String> list = (List<String>) request.getAttribute("list");
        if(list!=null){
            System.out.println(list.get(0));
        }

        // 删除域对象内容
        
    }
}
