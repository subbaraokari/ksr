<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recharge Planner</title>
<link rel="stylesheet" href="/resources/css/form.css">
</head>
<body>
	<div>
		<a href="./?lang=en"><spring:message
				code="english.lang" /></a> <a
			href="./?lang=ge"><spring:message
				code="german.lang" /></a> <a
			href="./?lang=fr"><spring:message
				code="french.lang" /></a>
	</div>
	<div id="container">
		<div id="content">
			<h1 class="title">Recharge Planner</h1>
			<table>
				<f:form action="check" modelAttribute="customerDetails">
					<tr>
						<td><spring:message code="customer.name"/></td>
						<td><f:input id="name" type="text" path="name"/></td>
						<td><f:errors id="nameErr" path="name" cssClass="error">
							<spring:message code="customer.namevalidationmsg" /></f:errors></td>
					</tr>
					<tr>
						<td><spring:message code="customer.mobileno" /></td>
						<td><f:input type="text" id="mobileNo" path="mobileNo" /></td>
						<td><f:errors path="mobileNo" id="mobileNoErr"
								cssClass="error" >
							<spring:message code="customer.mobilenovalidationmsg" /></f:errors></td>
					</tr>
					<tr>
						<td><spring:message code="customer.previousrechargedate" /></td>
						<td><f:input path="previousRechargeDate" id="re_date" /></td>
					</tr>
					<tr>
						<td><spring:message code="customer.previouspackage"/></td>
						<td><f:select id="plan" path="previousSelectedPackage">
								<f:options items="${customerDetails.packageNames}" />
							</f:select></td>
					</tr>
					<tr>
						<td><button id="submit" class="check-btn" type="submit"
							value="Check Status"><spring:message code="button.check" /></button></td>
					</tr>
				</f:form>
			</table>
			<h1 id="msg">${msg}</h1>
		</div>
	</div>
</body>
</html>