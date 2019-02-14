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
<c:forEach items="${lista}" var="zona">
  <p> ${zona.nome}" popolazione: "${zona.population}</p><br>
</c:forEach>
<p>${error}</p>
</body>
</html>