package com.sardh;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

/**
 * 响应数据
 *      getWriter()         字符输出流(输出字符串)
 *      getOutputStream()   字符输出流(输出一组数据)
 *      一起用会报错:java.lang.IllegalStateException: 已为此响应调用getWriter（）
 */
@WebServlet("/s01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        // 读取字符输出流
        PrintWriter writer = response.getWriter();

        //输出数据
        writer.write("Hello");

        //
        ServletOutputStream out = response.getOutputStream();
        // 输出数据
        out.write("Hi".getBytes());
    }

}
