package com.sardh;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Welcome");

        // 设置响应的内容类型
        response.setContentType("text/plain");

        // 获取前端发送的数据
        String buttonClicked = request.getParameter("buttonClicked1");
        System.out.println(buttonClicked);

        // 根据按钮点击情况发送不同的响应码
        if (buttonClicked != null && buttonClicked.equals("true")) {
            // 响应码 200 表示成功
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Button clicked!");
        } else {
            // 响应码 400 表示客户端错误
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Button not clicked!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // 设置响应类型:
        response.setContentType("text/html");
        // 获取输出流
        PrintWriter printWriter = response.getWriter();
        // 写入响应
        printWriter.write("<h1>Hello World<h1>");

        printWriter.flush();
    }

}