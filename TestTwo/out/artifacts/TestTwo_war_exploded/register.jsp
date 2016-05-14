<%--
  Created by IntelliJ IDEA.
  User: liuchuang
  Date: 16-5-13
  Time: 下午8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String errMsg = (String) session.getAttribute("err");
    if (errMsg != null) {%>
<div style="color:red;"><%=errMsg%>
</div>
<% session.removeAttribute("err");
}
%>
<html>
<head>
    <title>REGISTER</title>
</head>
<body>
<form action="RegisterServlet">
    USERNAME:<input type="text" name="username"><br/>
    PASSWORD:<input type="password" name="password"><br/>
    REPASSWORD:<input type="password" name="repassword"><br/>
    <input type="submit" value="register">
    <input type="reset" value="reset">
</form>
</body>
</html>
