<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/14/12
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<%
String userName = request.getParameter("name");
if(userName !=null && userName != ""){
    session.setAttribute("sessionUserName", userName);
//    application.setAttribute("applicationUserName", userName);
    pageContext.setAttribute("pageContextUserName", userName);
    pageContext.setAttribute("applicationUserName",userName, PageContext.APPLICATION_SCOPE);
    pageContext.findAttribute("name");
}

%>
<br />
The user name in the request object is: <%=userName%>
<br />
The user name in the session object is: <%=session.getAttribute("sessionUserName")%>
<br />
The user name in the application/context object is: <%=application.getAttribute("applicationUserName")%>
<br />
The user name in the page context object is: <%=pageContext.getAttribute("pageContextUserName")%>


</body>
</html>