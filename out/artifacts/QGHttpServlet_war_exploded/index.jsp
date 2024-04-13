<%--
  Created by IntelliJ IDEA.
  User: SARDH
  Date: 2024/3/28
  Time: 0:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Button Click Example</title>
  <script>
    function sendRequest1() {
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "response", true);
      // 设置相应的内容类型
      // 此处是否可以被更改成其他, 有什么格式要求
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
      xhr.send("buttonClicked1=true");
    }
  </script>
</head>
<body>
<h2>Click the button below to send request to backend</h2>
<button onclick="sendRequest1()">Click me!</button>
<button onclick="sendRequest2()">Click me!</button>
</body>
</html>