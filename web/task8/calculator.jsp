<%--
  Created by IntelliJ IDEA.
  User: clouway
  Date: 2/21/12
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" type="text/css" href="calculatorStyle.css" />
    <script type="text/javascript" src="calculatorLogic.js" charset="utf-8"></script>
</head>

<%!
    private String getResult(Object message){
        if(message != null){
            return message.toString();
        }
        return "";
    }
%>
<body>
<div id="mainDiv"
     style="margin: auto; position: relative; width: 215px; height: 250px; background-color: azure;">
    <form action="../calculator" method="post">
        <input type="text" name="calcField" id="calcField" class="calcField" onchange="validateNumber()" value="<%=getResult(session.getAttribute("result"))%>"/>
        <button type="button" id="clear" onclick="calcField.value = ''">CE</button>
        <br/>
        <button type="button" id="7" onclick="calcField.value += '7'">7</button>
        <button type="button" id="8" onclick="calcField.value += '8'">8</button>
        <button type="button" id="9" onclick="calcField.value += '9'">9</button>
        <button type=button id="back" onclick="backOneCharacter()"><-</button>

        <br/>
        <button type="button" id="4" onclick="calcField.value += '4'">4</button>
        <button type="button" id="5" onclick="calcField.value += '5'">5</button>
        <button type="button" id="6" onclick="calcField.value += '6'">6</button>
        <button type="button" id="/" onclick="writeOperation('/')">/</button>
        <br/>
        <button type="button" id="1" onclick="calcField.value += '1'">1</button>
        <button type="button" id="2" onclick="calcField.value += '2'">2</button>
        <button type="button" id="3" onclick="calcField.value += '3'">3</button>
        <button type="button" id="*" onclick="writeOperation('*')">*</button>
        <br/>
        <button type="button" id="0" onclick="calcField.value += '0'">0</button>
        <button type="button" id="=" onclick="submit()">=</button>
        <button type="button" id="-" onclick="writeOperation('-')">-</button>
        <button type="button" id="+" onclick="writeOperation('+')">+</button>


    </form>

</div>

</body>
</html>