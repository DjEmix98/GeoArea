<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ricerca Specifica</title>
</head>
<body>
<a href="continenti" style="color: black;">Torna alla home</a><br>
	<c:forEach items="${lista}" var="citta">
		<p>${citta.nome}" popolazione: "${citta.population}</p>
		<br>
	</c:forEach>
	<p>${error}</p>
</body>
</html>