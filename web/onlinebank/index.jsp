<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper" %>
<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository" %>
<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

</head>

<body style="background-color: #d5e2ff">
<div style="position: relative;">
    <div align="center"
         style="background-color: #b7b8ff; width: 200px; height: 160px; margin-left: auto; margin-right: auto;">
        <form action="../loginServlet" method="post">
            Username: <input type="text" name=userName>
            <br/>
            Password: <input type="password" name="password">
            <br/>
            <input type="submit" value="Login">
            <br/>
            <br/>
            <a href="register.jsp">create account</a>
        </form>
    </div>
    <div align="center">
        <h3>Users online:<%=request.getAttribute("onlineUsersCount")%>
        </h3>
    </div>
</div>
</body>
</html>