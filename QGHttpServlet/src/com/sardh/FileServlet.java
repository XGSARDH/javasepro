package com.sardh;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@MultipartConfig
@WebServlet("/file")
public class FileServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("file init");
        response.setContentType("image/png");
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("icon.png");
        if (inputStream == null) {
            // 如果找不到资源，可以发送一个错误响应
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
            return;
        }
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            // 复制输入流到输出流
            IOUtils.copy(inputStream, outputStream);
            // IOUtils.copy方法会关闭inputStream，但不需要关闭outputStream
        }
    }
}
