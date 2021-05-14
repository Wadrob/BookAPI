<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>SHOW BOOK</title>
</head>
<body>


<p>Wybrano książkę o id <c:out value="${book.id}">BŁĘDNE ID</c:out></p>
ISBN: <c:out value="${book.isbn}">PUSTE</c:out>    <br>
Tytuł: <c:out value="${book.title}">PUSTE</c:out>  <br>
Autor: <c:out value="${book.author}">PUSTE</c:out>  <br>
Wydawca:<c:out value="${book.publisher}">PUSTE</c:out>   <br>
Gatunek: <c:out value="${book.type}">PUSTE</c:out>   <br>

</body>
</html>
