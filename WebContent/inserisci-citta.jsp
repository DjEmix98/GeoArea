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
	<form name="citta" action="inserimento">
		<select name="codiceNazione">
			<c:forEach items="${lista}" var="nazioni">
				<option value="${nazioni.code}">${nazioni.nome}</option>
			</c:forEach>
			<option value="${codiceNazione.code}" selected>${codiceNazione.nome}</option>
		</select>
		<p>
			Inserisci nome regione: <input type="text" name="regione"
				value="${citta.district}">
		</p>
		<p>
			Inserisci nome città:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="text" name="cittaNome" value="${citta.nome}">
		</p>
		<p>
			Inserisci popolazione:&nbsp;&nbsp; <input type="text"
				name="popolazione" value="${citta.population}">
		</p>
		<input type="hidden" value="${id}" name="id"> <input
			type="submit" value="Esegui">
	</form>
</body>
</html>