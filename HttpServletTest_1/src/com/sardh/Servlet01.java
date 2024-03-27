//URL:
// http://localhost:8080/sTest/


package com.sardh;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/s01")
public class Servlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        // 提取请求的完整URL
        String url = request.getRequestURL() + "";
        System.out.println("Get the complete URL of the request: " + url);

        // 获取客户端请求的部分URL
        String uri = request.getRequestURL() + "";
        System.out.println("Get partial URLs requested by the client: " + uri);

        // 获取请求行中的参数部分
        String queryString = request.getQueryString();
        System.out.println("Get the parameter section in the request line: " + queryString);

        // 获取客户端的请求方式 (GET和POST)
        String method = request.getMethod();
        System.out.println("Get request method: " + method);

        // 获取当前协议版本
        String prototol = request.getProtocol();
        System.out.println("Get the current protocol version: " + prototol);

        // 获取项目的站点名
        String webapp = request.getContextPath();
        System.out.println("Get the site name of the project: " + webapp);

        /*获取请求的参数*/
        //获取请求名称的参数值
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

        System.out.println("uname: " + uname);
        System.out.println("upwd: " + upwd);

        //获取指定名称的参数的所有参数值,返回字符串数组
        String[] hobbys = request.getParameterValues("hobby");
        if(hobbys != null && hobbys.length > 0) {
            for (String hobby: hobbys) {
                System.out.println("hobby: " + hobby);
            }
        }

    }

}
