<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.sql.*, java.util.*" %>
<%@ page import="me.liuchuang.beans.*" %>
<jsp:useBean id="userDAO" class="me.liuchuang.dao.UserDAO" scope="session"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="RegisterServlet">
    USERNAME:<input type="text" name="username"></br>
    PASSWORD:<input type="password" name="password"></br>
    <input type="submit" value="submit">
</form>
</body>
</html>
