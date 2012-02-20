<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/16/12
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%!
    List<String> links = new LinkedList<String>();
%>
<body>
    <%
        String pageToGo = request.getParameter("page");
        if(!links.contains(pageToGo)){
            links.add(pageToGo);
            session.setAttribute("message","Hello newcomer!");
        } else {
            session.setAttribute("message","Hello old timer!");
        }
        response.sendRedirect(pageToGo);
    %>
</body>
</html>