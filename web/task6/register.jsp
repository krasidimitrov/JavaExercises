<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/16/12
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <div align="center"
         style="background-color: #ffdc9f; width: 200px; height: 150px; margin-left: auto; margin-right: auto;">
        <form action="../registerServlet" method="post">
            Username: <input type="text" name=userName maxlength="20">
            <br/>
            Password: <input type="password" name="password" maxlength="20">
            <br/>
            <input type="submit" value="register">
        </form>
    </div>
</div>
</body>
</html>