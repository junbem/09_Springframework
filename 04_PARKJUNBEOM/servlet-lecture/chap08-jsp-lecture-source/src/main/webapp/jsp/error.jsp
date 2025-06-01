<%--
  Created by IntelliJ IDEA.
  User: woori
  Date: 2025-05-21
  Time: 오후 4:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    // isErrorPage="true'로 설정 시 exception 내장 객체를 사용할 수 있따.
    String exceptionType = exception.getClass().getTypeName();
    String exceptionmessage = exception.getMessage();
  %>
<h1><%= exceptionType %></h1>
<h1><%= exceptionmessage%></h1>
</body>
</html>
