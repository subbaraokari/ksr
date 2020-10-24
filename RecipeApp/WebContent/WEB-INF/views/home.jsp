<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<h1>welcome to home page</h1>
	<h3>Donating/Requesting</h3>
	<form action="${pageContext.request.contextPath}/req" method="post">
		Request<select name="reqType">
			<option value="donor">Donor</option>
			<option value="requestor">Requestor</option>
		</select>
		<button type="Submit">Submit</button>
	</form>
</body>
</html>