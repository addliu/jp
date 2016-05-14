<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-13
  Time: 下午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.sql.*, java.util.*" %>
<%@ page import="me.liuchuang.beans.*" %>
<jsp:useBean id="userDAO" class="me.liuchuang.dao.UserDAO" scope="session"/>
<%
    session.setAttribute("id", request.getParameter("id"));
%>
<html>
<head>
    <title>EDIT</title>
</head>
<body>
<form action="EditServlet">
    USERNAME:<input type="text" name="username"></br>
    PASSWORD:<input type="password" name="password"></br>
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <input type="submit" value="submit">
</form>
</body>
</html>
