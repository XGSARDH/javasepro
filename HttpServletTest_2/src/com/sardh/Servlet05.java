package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 *
 */
@WebServlet("/s05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //Welcome
        System.out.println("Servlet05");
        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        // 请求参数
        String uname = request.getParameter("uname");
        System.out.println("uname" + uname);

    }

}
