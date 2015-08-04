<jsp:include page="/WEB-INF/views/taglibs.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>Team</title>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	<div class="container">

		<h1>Add team page</h1>
		<br /> ${message}
		<div class="col-lg-6">

			<form:form class="form-horizontal" role="form" method="POST"
				commandName="team" action="${pageContext.request.contextPath}/team">

				<form:hidden path="id" />

				<div class="form-group">
					<div class="col-sm-10 col-sm-offset-2">
						<a class="btn btn-primary" role="button"
							href="${pageContext.request.contextPath}/team/list">Back to
							list</a> <a class="btn btn-primary" role="button"
							href="${pageContext.request.contextPath}/team/add">New</a> <input
							type="submit" class="btn btn-success" value="Save" />

					</div>
				</div>

				<div class="form-group">
					<form:label path="name" class="col-sm-2 control-label">Name</form:label>
					<div class="col-sm-10">
						<form:input path="name" class="form-control" />
						<form:errors path="name" />
					</div>
				</div>
			</form:form>

			<p></p>
		</div>
	</div>
</body>
</html>