<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/14/12
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clock</title>
</head>
<body>
<%@include file="/training/hello.jsp"%>

The time is: <%=new Date()%>

</body>
</html>