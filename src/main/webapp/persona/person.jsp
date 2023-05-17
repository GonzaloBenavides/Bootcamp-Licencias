<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<title>License API</title>
</head>
<body>
	<div class="container">
		<div class="col-ms-12">
			<a href="/">Home</a>
			<h1><c:out value="${persona.nombre} ${persona.apellido}" /></h1>
			<table class="table">
				<tr>
					<td>License Number</td>
					<td><c:out value="${persona.licencia.numero}" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><c:out value="${persona.licencia.comuna}" /></td>
				</tr>
				<tr>
					<td>Expiration Date</td>
					<td><c:out value="${persona.licencia.expiracion}" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>