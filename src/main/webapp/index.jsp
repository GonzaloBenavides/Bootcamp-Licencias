<%@page import="org.springframework.ui.Model"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<title>Licenses API</title>
</head>
<body>
	<h1 style="text-align: center;">Welcome to the Licenses API</h1>
	<a href="/persona/new">New Person</a> 	<a href="/licencia/new">New License</a>
	<table class="table table-striped mt-5 border border-1">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License #</th>
				<th>State</th>
				<th>Expiration</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${personas}">
				<tr>
					<td><c:out value="${p.nombre}" /></td>
					<td><c:out value="${p.apellido}" /></td>
					<td><c:out value="${p.licencia.numero}" /></td>
					<td><c:out value="${p.licencia.comuna}" /></td>
					<td><c:out value="${p.licencia.expiracion}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>