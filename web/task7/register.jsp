<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/20/12
  Time: 1:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<%!
    private String getMessage(Object message){
        if(message != null){
            return message.toString();
        }
        return "";
    }
%>

<body>
<div>
    <div align="center"
         style="background-color: #ffdc9f; width: 600px; height: 250px; margin-right: auto; text-align: left">
        <form action="../register" method="post">
            First name: <input type="text" name="firstName" maxlength="15"/>  <%=getMessage(session.getAttribute("firstNameMessage"))%>
            <br/>
            Last name: <input type="text" name="lastName" maxlength="15"/> <%=getMessage(session.getAttribute("lastNameMessage"))%>
            <br/>
            EGN: <input type="text" name="egn" maxlength="10"/> <%=getMessage(session.getAttribute("egnMessage"))%>
            <br/>
            Age: <select name="age">
            <% for (int i = 18; i <= 118; i++) { %>
            <option value="<%=i%>"><%=i%>
            </option>
            <%}%>
        </select>
            <br/>
            Address: <input type="text" name="address" maxlength="100"/> <%=getMessage(session.getAttribute("addressMessage"))%>
            <br/>
            Username: <input type="text" name="userName" maxlength="20"/> <%=getMessage(session.getAttribute("userNameMessage"))%>
            <br/>
            Password: <input type="password" name="password" maxlength="20"/> <%=getMessage(session.getAttribute("passwordMessage"))%>
            <br/>
            Confirm password: <input type="password" name="confirmPassword" maxlength="20"/> <%=getMessage(session.getAttribute("confirmPasswordMessage"))%>
            <br/>
            <input type="submit" value="Register"/>
        </form>
    </div>
</div>

</body>
</html>