package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  请求转发跳转
 *  可以由服务端跳转到客户端
 *      1. 服务端行为
 *      2. 地址栏不发生改变
 *      3. 从始至终只有一个请求
 *      4. resquest数据可以共享
 */
@WebServlet("/s03")
public class Servlet03 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // 接受参数
        String uname = request.getParameter("uname");
        System.out.println("Servlet03 uname: " + uname);

        // 请求转发跳转到service04
        //request.getRequestDispatcher("s04").forward(request,response);

        // 请求转发跳转到login页面
        request.getRequestDispatcher("login.html").forward(request,response);
    }
}
