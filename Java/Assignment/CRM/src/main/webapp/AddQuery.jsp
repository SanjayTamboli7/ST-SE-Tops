<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Query Form</title>
</head>
<body>
    ${msg }
	<jsp:include page="HeaderQuery.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">Add New
				Query</h4>

			<%-- <jsp:include page="QueryForm.html"></jsp:include> --%>
			<%@ include file="QueryForm.jsp" %>
		</div>
	</div>
</body>
</html>