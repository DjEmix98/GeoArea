<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GeoArea</title>
</head>

<body>
	<p>${risultato}</p>
	<a href="inserisci?id=0">Inserisci città</a>
	<br><a href="continenti"style="color: black;">Torna alla home</a>
	<br>
	<c:forEach items="${list}" var="citta">
		<a>${citta.nome}&nbsp;</a>
		<a href="elimina?codiceNazione=${citta.countryCode}&id=${citta.id}"
			style="color: red;">Elimina</a>
		<a href="inserisci?&id=${citta.id}&codiceNazione=${citta.countryCode}"
			style="color: green;">&nbsp;Modifica</a>
		<br>
	</c:forEach>
</body>
</html>
