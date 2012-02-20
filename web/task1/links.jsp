<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/15/12
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%!


%>
<form action="">
    <a href="../linkCounterServlet?link=link1" name="link1" >Link 1</a> Clicked: <%= session.getAttribute("link1count")%>
    <br/>
    <a href="../linkCounterServlet?link=link2" name="link2">Link 2</a> Clicked: <%= session.getAttribute("link2count")%>
    <br/>
    <a href="../linkCounterServlet?link=link3" name="link3">Link 3</a> Clicked: <%= session.getAttribute("link3count")%>
</form>

</body>
</html>