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
	<form>
	<button type="submit" value = "${codec}" name = "codice" formaction = "inserisci">Inserisci città</button> <br>
	</form>
	<c:forEach items="${list}" var="citta">
		<a>${citta.nome}&nbsp;</a><a href="elimina?codice=${citta.countryCode}&id=${citta.id}" style = "color:red;" >Elimina</a><br>
	</c:forEach>
</body>
</html>
