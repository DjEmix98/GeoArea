<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<p>Inserisci nome città:</p>
<input type="text" name = "nomeCitta">
<button type="submit" name = "codice" value="${code}" formaction = "risultato">Inserisci</button>
</form>
</body>
</html>