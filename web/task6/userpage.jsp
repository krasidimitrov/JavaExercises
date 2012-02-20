<%@ page import="task6.*" %>
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
    IBankRepository bank = new DatabaseBankRepository(databaseHelper);
%>
<%
    if(session.getAttribute("userName") == null){
        response.sendRedirect("/war/task6/index.jsp");
    }
%>
<body>
<h2>
    Your current balance is: <%=bank.getBalance(session.getAttribute("userName").toString())%>
</h2>

<form action="../depositServlet" method="post">
    Amount to deposit: <input type="text" name="deposit"/>
    <br/>
    <input type="submit" value="Deposit"/>
</form>
<form action="../withdrawServlet" method="post">
    Amount to withdraw: <input type="text" name="withdraw" />
    <br />
    <input type="submit" value="Withdraw">
</form>

</body>
</html>