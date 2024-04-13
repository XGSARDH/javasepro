# Why it woek?And how it work?
## RespanseServlet
```java


import java.io.IOException;
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
        String buttonClicked = request.getParameter("buttonClicked");
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
}
```
为什么多加一行在什么什么目录下都会导致失败?

## web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>ResponseServlet</servlet-name>
        <servlet-class>ResponseServlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ResponseServlet</servlet-name>
        <url-pattern>/response</url-pattern>
    </servlet-mapping>
</web-app>

```

## html
```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Button Click Example</title>
  <script>
    function sendRequest() {
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "response", true);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
      xhr.onreadystatechange = function() {
        if (xhr.readyState === 4) {
          if (xhr.status === 200) {
            alert("Button clicked successfully!");
          } else {
            alert("Failed to click button!");
          }
        }
      };
      xhr.send("buttonClicked=true");
    }
  </script>
</head>
<body>
<h2>Click the button below to send request to backend</h2>
<button onclick="sendRequest()">Click me!</button>
</body>
</html>
```
### 为我说明这一段代码的每一行的意思

这段代码是一个简单的HTML页面，包含了一个按钮和一些JavaScript代码，用于在按钮点击时向后端发送请求。下面是每一行代码的解释：

1. `<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>`
    - 这是一个JSP（Java Server Pages）页面的指令，用于指定页面的属性，包括语言、内容类型和页面编码。
2. `<!DOCTYPE html>`
    - 这是HTML5的文档类型声明，指定了HTML文档的类型和版本。
3. `<html>`
    - 这是HTML文档的根元素，表示页面的开始。
4. `<head>`
    - 这是HTML文档的头部部分，在这里可以包含一些元数据和脚本。
5. `<meta charset="UTF-8">`
    - 这个`meta`标签指定了文档的字符编码为UTF-8，确保页面中的文本能够正确地显示。
6. `<title>Button Click Example</title>`
    - 这是页面的标题，显示在浏览器的标题栏中。
7. `<script>`
    - 这是JavaScript代码的开始标签，用于在HTML文档中嵌入JavaScript代码。
8. `function sendRequest() { ... }`
    - 这是一个JavaScript函数`sendRequest()`的定义，该函数用于发送HTTP请求到后端。函数内部包含了使用XMLHttpRequest对象发送POST请求的代码。
9. `var xhr = new XMLHttpRequest();`
    - 这行代码创建了一个新的XMLHttpRequest对象，用于向服务器发送HTTP请求。
10. `xhr.open("POST", "response", true);`
    - 这行代码配置了XMLHttpRequest对象，指定了要发送的请求类型（POST），请求的URL（“response”），以及请求是否异步执行（true表示异步执行）。
11. `xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");`
    - 这行代码设置了HTTP请求的头部信息，指定了请求的内容类型为表单形式的数据。
12. `xhr.onreadystatechange = function() { ... };`
    - 这行代码为XMLHttpRequest对象的`onreadystatechange`事件指定了一个回调函数，该函数会在请求状态发生改变时被调用。
13. `if (xhr.readyState === 4) { ... }`
    - 这是一个条件语句，检查XMLHttpRequest对象的`readyState`属性是否为4，表示请求已完成。
14. `if (xhr.status === 200) { ... }`
    - 这是另一个条件语句，检查XMLHttpRequest对象的`status`属性是否为200，表示服务器成功处理了请求。
15. `xhr.send("buttonClicked=true");`
    - 这行代码发送了HTTP请求到服务器，请求的内容是字符串`"buttonClicked=true"`，用于告知服务器按钮被点击了。
16. `</script>`
    - 这是JavaScript代码的结束标签。
17. `</head>`
    - 这是HTML文档头部的结束标签。
18. `<body>`
    - 这是HTML文档的主体部分，包含了页面的可见内容。
19. `<h2>Click the button below to send request to backend</h2>`
    - 这是一个标题标签，显示在页面中，提示用户点击按钮向后端发送请求。
20. `<button onclick="sendRequest()">Click me!</button>`
    - 这是一个按钮元素，当用户点击按钮时会调用`sendRequest()`函数，向后端发送HTTP请求。
21. `</body>`
    - 这是HTML文档主体的结束标签。
22. `</html>`
    - 这是HTML文档的结束标签，表示页面的结束。