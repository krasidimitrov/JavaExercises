<%@ page import="loginform.User" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/15/12
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h2>Login SUCCESSFUL</h2>
<br/>

<%--<%--%>
    <%--User user = (User) request.getAttribute("user");--%>
<%--%>--%>

<jsp:useBean id="user" class="loginform.User" scope="request"></jsp:useBean>

<%--Hello <%=user.getUserName()%>--%>
Hellp <jsp:getProperty name="user" property="userName"/>

</body>
</html>