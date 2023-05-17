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
			<h1>NEW License</h1>
			<form:form action="/licencia/new" method="post" modelAttribute="licencia">
				<div class="row mb-3">
					<form:errors class="text-danger" path="comuna" />
				</div>
				<div class="form-outline mb-4">
					<form:input class="form-control" type="text" path="comuna" id="comuna" />
					<form:label class="form-label" for="comuna" path="comuna">State</form:label>
				</div>
				<div>
					<input type="submit" class="btn btn-primary" value="Crear" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>