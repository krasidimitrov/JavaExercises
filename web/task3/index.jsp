<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/16/12
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="../dispatcherServlet">
    <input type="radio" name="page" value="/war/com.clouway.jspandservlet.task3/page1.jsp"> Go to page 1<br>
    <input type="radio" name="page" value="/war/com.clouway.jspandservlet.task3/page2.jsp"> Go to page 2<br>
    <input type="radio" name="page" value="/war/com.clouway.jspandservlet.task3/page3.jsp"> Go to page 3<br>
    <br />
    <input type="submit" />
</form>


</body>
</html>