package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向与请求转发的区别
 *      1. 请求转发的地址栏不会发生改变, 重定向的地址栏会发生改变
 *      2. 请求转发只有一次请求, 重定向有俩次请求
 *      3. 请求转发时request对象克共享, 重定向时request对象不共享
 *      4. 请求转发是服务端行为, 重定向是客户端行为
 *      5. 请求转发时地址只能是当前站点下的资源, 重定向的地址可以是任何地址
 *      6.
 */
@WebServlet("/s06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //Welcome
        System.out.println("Servlet06");
        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        // 请求参数
        String uname = request.getParameter("uname");
        System.out.println("uname:" + uname);

        // 设置request域对象
        request.setAttribute("upwd","123456");

        // 请求转发
        //request.getRequestDispatcher("index.jsp").forward(request,response);

        // 重定向
        //response.sendRedirect("index.jsp");

        // 重定向跳转到百度
        //response.sendRedirect("http://www.baidu.com");

        // 请求转发到百度 (404)
        //request.getRequestDispatcher("http://www,baidu.com").forward(request,response);

    }

}
