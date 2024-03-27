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
@WebServlet("/s05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        System.out.println("Servvlet05");

        // 设置域对象内容
        request.setAttribute("name","admin");
        request.setAttribute("age",18);
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        request.setAttribute("list",list);

        // 请求转发跳转
        //request.getRequestDispatcher("/s06").forward(request,response);
        request.getRequestDispatcher("index.jsp").forward(request,response);

        // 获取域对象内容

        // 删除域对象内容
        
    }
}
