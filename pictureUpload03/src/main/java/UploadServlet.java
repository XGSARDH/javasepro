import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.nio.file.*;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private final String UPLOAD_DIR = "/path/to/uploaded";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Part filePart = request.getPart("avatar");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            File uploadDir = new File(UPLOAD_DIR);

            if (!uploadDir.exists() && !uploadDir.mkdirs()) {
                out.println("{\"status\": \"error\", \"message\": \"Failed to create directory.\"}");
                return;
            }

            filePart.write(UPLOAD_DIR + File.separator + fileName);
            out.println("{\"status\": \"success\", \"url\": \"http://localhost:8080/uploaded/" + fileName + "\"}");
        } catch (Exception e) {
            e.printStackTrace();
            out.println("{\"status\": \"error\", \"message\": \"" + e.getMessage() + "\"}");
        } finally {
            out.flush();
        }
    }
}
