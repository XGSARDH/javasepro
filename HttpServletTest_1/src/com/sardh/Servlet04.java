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
 *  服务端行为
 */
@WebServlet("/s04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // 接受参数
        String uname = request.getParameter("uname");
        System.out.println("Servlet04 uname: " + uname);

        
    }
}
