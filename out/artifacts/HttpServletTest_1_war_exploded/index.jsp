<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: SARDH
  Date: 2024/3/27
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--如果要在jsp中写java代码,需要卸载脚本段中--%>
  <h2>index页面</h2>
  <%
  // 获取域对象
    String name = (String) request.getAttribute("name");
    System.out.println(name);
    Integer age = (Integer) request.getAttribute("age");
    System.out.println("age" + age);
    List<String> list = (List<String>) request.getAttribute("list");
    if(list!=null){
      System.out.println(list.get(0));
    }

  %>

  $END$
  </body>
</html>
