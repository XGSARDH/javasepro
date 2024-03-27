package com.sardh;

import com.sardh.Servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class MyServlet implements Servlet {

    @Override
        public void init(ServletConfig servletConfig)throws ServletException {
        System.out.println("Servlet is initializing.");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest var1, ServletResponse var2)throws ServletException, IOException {
        // 专门向客服端提供响应的方法
        System.out.println("Servlet is providing service");
    }

    @Override
    public String getServletIofo() {
        return null;
    }

    @Override
    public void destroy(){
        System.out.println("Servlet is currently being destroyed");
    }

}