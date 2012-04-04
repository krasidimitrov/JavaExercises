<%@ page import="java.util.List" %>
<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/22/12
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
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
<%
    if(session.getAttribute("bookPosition") == null){
        response.sendRedirect(getPath()+"/pageServlet");
    }
    List<Book> bookArray = (ArrayList<Book>) session.getAttribute("bookArray");

%>
<body>
<div style="text-align: center; width: 400px; margin-left: auto; margin-right: auto; background-color: #d3d3d3;">


    <%
        if(bookArray != null){
        for(int i=0; i<bookArray.size(); i++){

     %>
    <div style="text-align: center; width: 400px; margin-left: auto; margin-right: auto; background-color: #d3d3d3;">
        <div style="text-align: center; width: 400px; margin-left: auto; margin-right: auto; background-color: #ffa4d4;">
           <a href=<%=getPath()+"/bookServlet?bookId="+i%>><%=bookArray.get(i).getTitle()%> </a>
        </div>
        <div style="text-align: center; width: 400px; margin-left: auto; margin-right: auto; background-color: #b4ffb3;">
            Publisher: <%=bookArray.get(i).getPublisher()%>
        </div>
        <div style="text-align: center; width: 400px; margin-left: auto; margin-right: auto; background-color: #d3e0ff;">
        Year: <%=bookArray.get(i).getYearOfPublishing()%>
        </div>
    </div>
    <br />
    <%
       }}
    %>
<%=session.getAttribute("pageNumber")%>
    <br />
<a href="<%=getPath()%>/pageServlet?changeValue=first"><<</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=getPath()%>/pageServlet?changeValue=back">back</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=getPath()%>/pageServlet?changeValue=next">next</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=getPath()%>/pageServlet?changeValue=last">>></a>
</div>

</body>
</html>