<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do usuário</title>
</head>
<body>
<h1>form dados</h1>

<c:if test="${not empty message}">

<h3>Mensagem: <span style="color: red;"> ${mensagem}</span></h3>

</c:if>

<form:form action="save" method="post" modelAttribute="team">
            <form:hidden path="id"/>
	<fieldset>
		<legend>Team</legend>
		<label for="name">Name</label>
		<input type="text" name="name" value="${team.name}" />
		
		<input type="hidden" name="_method" value="put" />
		<input type="hidden" name="id" value="${team.id}" />
		
		<input type="submit" value="SALVAR" />
	</fieldset>
</form:form>

</body>
</html>