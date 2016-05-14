<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-13
  Time: 上午11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.sql.*, java.util.*" %>
<%@ page import="me.liuchuang.beans.*" %>
<jsp:useBean id="userDAO" class="me.liuchuang.dao.UserDAO" scope="session"/>
<table border="1">
    <th>id</th>
    <th>name</th>
    <th>password</th>
    <th colspan="2">operation</th>
    <%
        List<User> users = userDAO.query();
        String edit = "EDIT";
        String delete = "DELETE";
        for (User user : users) {
            out.print("<tr>" + "<td>" + user.getId() + "</td>");
            out.print("<td>" + user.getUsername() + "</td>");
            out.print("<td>" + user.getPassword() + "</td>");
            out.print("<td><a href='edit.jsp?id=" + user.getId() + "'>" +  edit
                    + "</a></td>");
            out.print("<td><a href='delete.jsp?id=" + user.getId() + "'>"  +
                    delete + "</a></td>" + "</tr>");
        }
    %>

</table>
<br/>
<a href="register.jsp">REGISTER</a>

