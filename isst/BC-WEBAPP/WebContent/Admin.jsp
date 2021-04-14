<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vista de usuarios</title>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>
<h2>Admin</h2>
<p><b>Número de clientes y comercios registrados: </b>${fn:length(clientes)}</p>
<h2>Clientes</h2>
<table border="1">
<c:forEach items="${clientes}" var="clientei">
<tr>
<td>${clientei.email}</td>
<td>${clientei.location}</td>
<td>${clientei.type}</td>

</tr>
</c:forEach>
</table>

<h2>Comercios</h2>
<table border="1">
<c:forEach items="${comercios}" var="comercioi">
<tr>
<td>${comercioi.email}</td>
<td>${comercioi.location}</td>

</tr>
</c:forEach>
</table>
</body>
</html>