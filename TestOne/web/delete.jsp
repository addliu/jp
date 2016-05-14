<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-14
  Time: 上午8:51
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
    <title>DELETE</title>
</head>
<body>
<%
    User user = userDAO.getUser(Integer.parseInt(
            request.getParameter("id")));
    out.print(user.getId() + "<br/>");
    out.print(user.getUsername() + "<br/>");
    out.print(user.getPassword() + "<br/>");
    out.print("Are you sure to delete this user?");%>
<form action="DeleteServlet" method="post">
    <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
    <input type="submit" name="submit" value="submit">
    <input type="button" value="home" onclick="">
</form>
</body>
</html>
