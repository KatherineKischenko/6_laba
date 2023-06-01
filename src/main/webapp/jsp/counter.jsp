<%--
  Created by IntelliJ IDEA.
  User: asrie
  Date: 03.04.2023
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Count Words</title>
        <link href="styles/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    <h1>Подсчет количества встречаемого слова</h1>
    <%
        if(request.getAttribute("count") != null){
            out.println("<h5>В данном тексте слово "+request.getAttribute("searchWord")+" встречается "+ request.getAttribute("count")+" раз </h5>");
        }
        else{
            out.println("<h5> В данном тексте нет этого слова");
        }
    %>
    <button id="back" onclick="location.href='/'">Назад</button>
    </body>
</html>
