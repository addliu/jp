<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-13
  Time: 下午6:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String username = (String) session.getAttribute("username");
  if (username != null && !username.isEmpty()) {%>
You have login, welcome.<%=session.getAttribute("username")%>
<%
  } else {
    out.print("Please login!");
    response.setHeader("refresh", "3; url='login.jsp'");
  }
%>
<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
  </body>
</html>
