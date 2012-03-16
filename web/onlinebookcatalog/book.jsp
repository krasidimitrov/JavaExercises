<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.bussiness.Book" %>
<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.bussiness.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.persistance.DatabaseHelper" %>
<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.persistance.DataSourceCreator" %>
<%@ page import="com.clouway.jspandservlet.onlinebookcatalog.bussiness.CommentRowMapper" %>
<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/28/12
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%
//    if(session.isNew()){
//       response.sendRedirect("/war/onlinebookcatalog/catalog.jsp");
//    }
    Book currentBook = (Book) session.getAttribute("currentBook");
    List<Comment> commentArrayList = (List<Comment>) session.getAttribute("commentArrayList");

%>
<body>
<div style="text-align: center; width: 800px; margin-left: auto; margin-right: auto; background-color: #d3d3d3;">


        <div style="text-align: center; margin-left: auto; margin-right: auto; background-color: #ffa4d4;">
        <%=currentBook.getTitle()%>
        </div>
    <div style="text-align: center; margin-left: auto; margin-right: auto; background-color: #b4ffb3;">
        <%=currentBook.getDescription()%>
    </div>
    <form action="../commentServlet" method="post">
    nick: <input type="text" name="userName" /> <input type=submit value="Send"/>
        <br />
    <textarea name="comment" rows="5" cols="90"></textarea>
    </form>
    <%
        for(int i=0; i<commentArrayList.size(); i++){

    %>
        <div style="text-align: center; margin-left: auto; margin-right: auto; background-color: #d3e0ff;">
          <%=commentArrayList.get(i).getUserName()%>   
        </div>
    <div style="text-align: center; margin-left: auto; margin-right: auto; background-color: #f8f7ff;">
        <%=commentArrayList.get(i).getComment()%>
    </div>

    <br />
    <%
      }
    %>
</div>

</body>
</html>