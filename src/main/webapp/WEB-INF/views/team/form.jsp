<jsp:include page=../taglibs.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>Add team page</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>

<body>
	<h1>Add team page</h1>
	<a href="${pageContext.request.contextPath}/team/add">Add new team</a>
	<br /> ${message}
	<form:form method="POST" commandName="team" action="${pageContext.request.contextPath}/team">
		<form:hidden path="id" />
		Name:
		<form:input path="name" /> 
		<form:errors path="name" class="control-label" />
		<input type="submit" value="Save" /></td>
					
	</form:form>

	<p>
		<a href="${pageContext.request.contextPath}/index.html">Home page</a>
	</p>
</body>
</html>