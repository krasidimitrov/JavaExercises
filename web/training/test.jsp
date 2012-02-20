<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/14/12
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<h3>Testing JSPs</h3>
<%!
public int add(int a, int b){
    return a+b;
}
%>


<%
    int i = 1;
    int j = 2;
    int k;
    k = i+j;
//    out.println("Value of k is "+k);
%>

The Value of k is: <%=k%>

<%
    k=add(35643, 87658);
%>
<br />
The value of k is: <%=k%>

<%
    for(i=0; i<5; i++) {
 %>
<br /> i = <%=i%>
<%    }
%>
</body>
</html>