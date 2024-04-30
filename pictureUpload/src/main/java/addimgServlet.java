
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addimgServlet")
public class addimgServlet extends HttpServlet {
    //为类可持久化
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("-----------------------dfdsf");
        request.setCharacterEncoding("utf-8");
        //通过工具类获取成员的信息
        String file = getServletContext().getRealPath("/head_img/");
        Map<String,String> map = new FileUpload().File_upload(request,file);
        System.out.println("1");
        //创建img对象用来封装数据
        Img img = new Img();
        try {
            BeanUtils.populate(img,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("servlet获取的img数据为:"+img);
        //创建service对象将头像数据存入到表中
        /*
        UserDaoImpl userDao  = new UserDaoImpl();
        userDao.addimg(img);
        */



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
