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
	<c:forEach items="${list}" var="continenti">
		<a href="nazioni?continente=${continenti}">${continenti}</a>
	</c:forEach>
	<form>
		<select name="codiceNazione">
			<c:forEach items="${lista}" var="nazione">
				<option value="${nazione.code}">${nazione.nome}</option>
			</c:forEach>
		</select>
		<p>Da qui avvia una ricerca specifica!</p>
		<p>Scrivi città da ricercare:</p>
		<input type="text" name="ricercaCity"><br>
		<p>Scrivi numero popolazione:</p>
		<input type="text" name="nPopolazione"> <input type="radio"
			name="operatore" value="maggiore" checked> Maggiore <input
			type="radio" name="operatore" value="minore"> Minore<br>
		<input type="submit" formaction="ricerca">
	</form>
</body>
</html>