package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 * 服务端指导
 * 客户端行为
 * 存在俩次请求
 * 地址栏会发生改变
 * request和response对象不共享
 */
@WebServlet("/s04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //Welcome
        System.out.println("Servlet04");
        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        String output = "?uname=123";

        // 请求参数
        String uname = request.getParameter("uname");
        System.out.println("uname: " + uname);

        // 重定向跳转到05
        response.sendRedirect("s05"+output);

    }

}
