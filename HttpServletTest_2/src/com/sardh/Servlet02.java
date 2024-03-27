package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字节乱码问题
 *      getWriter()         字符输出流(输出字符串)
 *
 *      一起用会报错:java.lang.IllegalStateException: 已为此响应调用getWriter（）
 *      设置服务端的编码格式: response.setCharacterEncoding("UTF-8");
 *      设置客户端的编码格式和响应类型: response.setHeader("content-type","text/html;charset=UTF-8");
 *      这个可以同时设置服务端和客户端的编码格式: response.setContentType("text/html;charset=UTF-8");
 */
@WebServlet("/s02")
public class Servlet02 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        // 设置服务端的编码格式
        //response.setCharacterEncoding("UTF-8");
        // 设置客户端的编码格式和响应类型
        //response.setHeader("content-type","text/html;charset=UTF-8");

        // 这个可以同时设置服务端和客户端的编码格式
        response.setContentType("text/html;charset=UTF-8");

        // 读取字符输出流
        PrintWriter writer = response.getWriter();

        //输出数据
        writer.write("<h2>你好<h2>");

    }

}
