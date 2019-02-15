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
	<c:forEach items="${list}" var="nazioni">
		<a href="citta?codice=${nazioni.code}">${nazioni.nome}</a>
	</c:forEach>
</body>
</html>