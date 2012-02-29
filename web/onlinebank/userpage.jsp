<%@ page import="com.clouway.jspandservlet.onlinebank.*" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/17/12
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%!
    DatabaseHelper databaseHelper = new DatabaseHelper();
    BankRepository bank = new DatabaseBankRepository(databaseHelper);
    UsersOnlineRepository onlineUsers = new DatabaseUsersOnlineRepository(databaseHelper);
%>
<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("/war/onlinebank/index.jsp");
    }
    try {
        onlineUsers.updateExpirationTime(session.getAttribute("userName").toString(), session.getAttribute("creationTime").toString(), session.getMaxInactiveInterval());
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>
<body>
<div align="center"
     style="background-color: #ffdc9f; width: 500px; height: 300px; margin-left: auto; margin-right: auto;">
    <h2>
        Your current balance is: <%=bank.getBalance(session.getAttribute("userName").toString())%>
    </h2>

    <form action="../depositServlet" method="post">
        Amount to deposit: <input type="text" name="deposit"/>

        <input type="submit" value="Deposit"/>
    </form>
    <form action="../withdrawServlet" method="post">
        Amount to withdraw: <input type="text" name="withdraw"/>

        <input type="submit" value="Withdraw">
    </form>

<form action="../logoutServlet" method="post">
    <input type="submit" value="Logout">
</form>
</div>
</body>
</html>