import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Part filePart = request.getPart("file"); // 从请求中获取文件
            String fileName = getSubmittedFileName(filePart);
            InputStream fileContent = filePart.getInputStream();

            // 指定保存文件的路径（确保路径存在且可写）
            File fileToSave = new File("d:/uploads/" + fileName);
            Files.copy(fileContent, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);

            out.println("<html><body><p>文件上传成功: " + fileName + "</p></body></html>");
        } catch (Exception e) {
            out.println("<html><body><p>文件上传失败: " + e.getMessage() + "</p></body></html>");
        } finally {
            out.close();
        }
    }

    private String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
