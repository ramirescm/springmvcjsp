<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>List of teams</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">
		<a class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/team/add">New team</a>
		<h1>List of teams</h1>
		<table class="table">
			<thead>
				<tr>
					<th width="10%">#</th>
					<th width="15%">name</th>
					<th width="10%">actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="team" items="${teams}">
					<tr>
						<td>${team.id}</td>
						<td>${team.name}</td>
						<td><a
							class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/team/${team.id}">Edit</a>
							<a
							class="btn btn-primary" role="button" href="${pageContext.request.contextPath}/team/delete/${team.id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<p>
			<a href="${pageContext.request.contextPath}/index.html">Home page</a>
		</p>
	</div>
</body>
</html>