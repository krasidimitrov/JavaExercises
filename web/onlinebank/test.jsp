<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.DatabaseHelper" %>
<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.UsersOnlineRepository" %>
<%@ page import="com.clouway.jspandservlet.onlinebank.persistance.DatabaseUsersOnlineRepository" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/16/12
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

    <%
        UserSessions sessions = request.getAttribute("sessions");

    %>
</head>

<%--<%--%>
    <%--if (session.getAttribute("userName") != null) {--%>
        <%--response.sendRedirect("/war/onlinebank/userpage.jsp");--%>
    <%--}--%>
<%--%>--%>
<body style="background-color: #d5e2ff">
<div style="position: relative;">
    <div align="center"
         style="background-color: #b7b8ff; width: 200px; height: 160px; margin-left: auto; margin-right: auto;">
        <form action="../testServlet" method="post">
            <input type="submit" value="Login">
        </form>
    </div>
    <%= "Context Path: " + request.getServletPath() %>
    <%= request.getAttribute("test") == null ? "No Parameter Was Found" : request.getAttribute("test") %>
</div>
</body>
</html>