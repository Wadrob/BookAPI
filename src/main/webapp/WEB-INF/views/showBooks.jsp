<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Show Books</title>
</head>
<body>
<c:forEach items="${books}" var="book" varStatus="loop">
    <p>Książka ${book.id}</p>
    ISBN: ${book.isbn}    <br>
    Tytuł: ${book.title}   <br>
    Autor: ${book.author}   <br>
    Wydawca: ${book.publisher}   <br>
    Gatunek: ${book.type}   <br>
</c:forEach>
<form method="post" action="">
    <p>DODAJ NOWĄ KSIĄŻKĘ</p>
    <input type="text" name="isbn" placeholder="ISBN"><br>
    <input type="text" name="title" placeholder="TYTUŁ"><br>
    <input type="text" name="author" placeholder="AUTOR"><br>
    <input type="text" name="publisher" placeholder="WYDAWCA"><br>
    <input type="text" name="type" placeholder="GATUNEK"><br>
    <input type="submit" name="Wyślij">
</form>
</body>
</html>
