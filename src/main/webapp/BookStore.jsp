<%--
  Created by IntelliJ IDEA.
  User: KaizerSX
  Date: 19.05.2018
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>BooksStore</title>
    <style type="text/css">

        .tdser {background: #cccccc;}


        td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: black;
            color: #333;
            background-color: #fff;
        }

        table { border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;}

    </style>

</head>
<body>

<table >
    <tr id="toptr">
        <td class="tdser">ID</td>
        <td class="tdser">NAME</td>
        <td class="tdser">AUTHOR</td>
        <td class="tdser">YEAR</td>
    </tr>

<c:forEach items="${Books}" var="book">
    <tr id="downtr">
        <td>${book.id}</td>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td>${book.year}</td>
        <td><a href="/books?action=delete&id=${book.id}">delete</a></td>
        <td><a href="/books?action=update&id=${book.id}">update</a></td>
    </tr>
</c:forEach>


</table>
<br>
<br>
<form action="/books" method="post">



    Book name:<input type="text" name="bookname" value="${booking.name}"><br><br>
    Book author:<input type="text" name="bookauthor" value="${booking.author}"><br><br>
    Book year:<input type="text" name="bookyear" value="${booking.year}"><br><br>
    <input type="hidden" value="new" name="action">
    <input type="hidden" value="${booking.id}" name="bookingid">
              <input type="submit" value="submit">

</form>




</body>
</html>
