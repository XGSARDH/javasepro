import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import com.google.gson.Gson; // 引入Gson库处理JSON

public class ViewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        File folder = new File("d:/uploads/");
        File[] listOfFiles = folder.listFiles();

        String[] files = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                files[i] = listOfFiles[i].getName();
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(files); // 将文件名数组转换为JSON格式
        out.print(json);
        out.close();
    }
}
