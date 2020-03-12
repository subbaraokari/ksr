<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge Planner</title>
<link rel="stylesheet" href="/resources/css/form.css">
</head>
<body>
	<div id="container">
		<div id="content">
			<h1 class="title">Recharge Planner</h1>
			<table>
				<f:form action="check" modelAttribute="customerDetails">
					<tr>
						<td><f:label path="name">Enter your name</f:label></td>
						<td><f:input id="name" type="text" path="name" /></td>
						<td><f:errors id="nameErr" path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td><f:label path="mobileNo">Enter your mobile no</f:label></td>
						<td><f:input type="text" id="mobileNo" path="mobileNo" /></td>
						<td><f:errors path="mobileNo" id="mobileNoErr"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><f:label path="previousRechargeDate">Your previous Recharge Date</f:label></td>
						<td><f:input path="previousRechargeDate"
								id="re_date" /></td>
						<td><f:errors path="previousRechargeDate" id="re_date_err"
								cssClass="error" /></td>
					</tr>
					<tr>
						<td><f:label path="previousSelectedPackage">Your Previous Selected Package</f:label></td>
						<td><f:select id="plan" path="previousSelectedPackage">
								<f:options items="${customerDetails.packageNames}" />
							</f:select></td>
					</tr>
					<tr>
						<td><input id="submit" class="check-btn" type="submit"
							value="Check Status" /></td>
					</tr>
				</f:form>
			</table>
			<h1 id="msg">${msg}</h1>
		</div>
	</div>
</body>
</html>