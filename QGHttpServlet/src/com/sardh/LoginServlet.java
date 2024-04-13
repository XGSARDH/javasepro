package com.sardh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init success!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("<h1>解锁全新内容<h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置请求体字符编码为UTF-8
        response.setContentType("text/html;charset=UTF-8");

/*        // 读取请求体数据
        BufferedReader reader = request.getReader();
        StringBuilder requestBody = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        reader.close();

        // 在控制台打印请求体数据
        System.out.println("请求体数据: " + requestBody.toString());

        // 在这里您可以对请求体数据进行处理，例如解析JSON或处理表单数据*/

        // 设置响应内容类型为文本
        //response.setContentType("text/plain");
        response.setContentType("application/x-www-form-urlencoded");
        // 返回响应
        response.getWriter().write("Request body data received");

        //获取POST请求携带的表单数据
        Map<String, String[]> map = request.getParameterMap();
        //判断表单是否完整
        if(map.containsKey("username") && map.containsKey("password")) {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            System.out.println("username: " + username);
            System.out.println("password: " + password);
            //权限校验（待完善）
            if(username.equals("zhangsan") == true && password.equals("123456") == true) {
                System.out.println("Login is seccess!");
            }
            else {
                System.out.println("Login is error!");
            }
        }else {
            response.getWriter().write("Error, your form data is incomplete!");
        }
    }

}
