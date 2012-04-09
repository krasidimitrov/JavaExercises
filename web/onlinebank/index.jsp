
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%!
        private String getPath(){
            return getServletConfig().getServletContext().getContextPath();
        }
    %>

</head>

<body style="background-color: #d5e2ff">
<div style="position: relative;">
    <div align="center"
         style="background-color: #b7b8ff; width: 200px; height: 160px; margin-left: auto; margin-right: auto;">
        <form action="<%=getPath()%>/loginServlet" method="post">
            Username: <input type="text" name=userName>
            <br/>
            Password: <input type="password" name="password">
            <br/>
            <input type="submit" value="Login">
            <br/>
            <br/>
            <a href="<%=getPath()%>/onlinebank/register.jsp">create account</a>
        </form>
    </div>
    <div align="center">
        <h3>Users online:<%=request.getAttribute("onlineUsersCount")%>
        </h3>
        <br />
        <h2 ><%if(request.getParameter("errorMessage") != null) out.println(request.getParameter("errorMessage"));%></h2>
    </div>
</div>
</body>
</html>