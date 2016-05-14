<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-13
  Time: 下午4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.sql.*, java.util.*" %>
<%@ page import="me.liuchuang.beans.*" %>
<jsp:useBean id="userDAO" class="me.liuchuang.dao.UserDAO" scope="session"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        userDAO.addUser(user);
        response.sendRedirect("index.jsp");
    %>
</body>
</html>
