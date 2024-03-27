package com.servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public void init(ServletConfig config)throws ServletException{
        super.init(config);
    }
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("第一个Servlet类");
        out.println("</body></html>");
    }
}

