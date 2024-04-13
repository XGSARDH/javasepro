<%--
  Created by IntelliJ IDEA.
  User: SARDH
  Date: 2024/3/27
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <!--Java脚本段-->
  <%
    // 获取参数
    String uname = request.getParameter("uname");
    //获取request作用域
    String upwd = (String) request.getAttribute("upwd");

    // 输出内存
    out.print(uname);
    out.print("---------");
    out.print(upwd);
  %>
  $END$
  </body>
</html>
