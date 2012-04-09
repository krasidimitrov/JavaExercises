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
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<body>
<div align="center"
     style="background-color: #ffdc9f; width: 500px; height: 300px; margin-left: auto; margin-right: auto;">
    <h2>
        Your current balance is: <%=request.getAttribute("balance").toString()%>
    </h2>

    <form action="<%=getPath()%>/depositServlet" method="post">
        Amount to deposit: <input type="text" name="deposit"/>

        <input type="submit" value="Deposit"/>
    </form>
    <form action="<%=getPath()%>/withdrawServlet" method="post">
        Amount to withdraw: <input type="text" name="withdraw"/>

        <input type="submit" value="Withdraw">
    </form>

    <form action="<%=getPath()%>/logoutServlet" method="post">
        <input type="submit" value="Logout">
    </form>

    <br/>

    <h2><%if (request.getParameter("message") != null) out.println(request.getParameter("message"));%></h2>

</div>
</body>
</html>