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
<select name="nazione">
	<c:forEach items="${lista}" var="nazioni">
  <option value="${nazioni.code}">${nazioni.nome}</option>
</c:forEach>
</select>
<p>Inserisci nome regione: <input type="text" name = "regione" value = "${regione}"></p>
<p>Inserisci nome città:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name = "nomeCitta" value ="${nomeCitta}"  ></p>
<p>Inserisci popolazione:&nbsp;&nbsp; <input type="text" name = "popolazione" value = "${popolazione}"></p>
<button type="submit"  formaction = "risultato" name = "id" value = "${id}">Esegui</button>
</form>
</body>
</html>