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