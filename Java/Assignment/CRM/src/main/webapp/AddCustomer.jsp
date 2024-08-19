<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Customer Form</title>
</head>
<body>
    ${msg }
	<jsp:include page="HeaderCustomer.html"></jsp:include>
	<div class="px-4 py-5 my-5">
		<div class="col-lg-6 mx-auto">
			<h4 class="display-5 fw-bold text-body-emphasis">Add New
				Customer</h4>

			<jsp:include page="CustomerForm.html"></jsp:include>
		</div>
	</div>
</body>
</html>