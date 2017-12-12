<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<%@include file="HBMS_Admin_HomePage.jsp" %>
<div class="page2">
<center>
	<table border=1 class="table">
		<form:form method="post" modelAttribute="add" action="addHotelData">
<tr><h2>Add Hotel</h2></tr>
			<tr>
				<td>City:</td>
				<td><form:select path="city" required="true">
						<form:option value="" label="----Please select----" />
						<form:options items="${cityList }" />
					</form:select> <form:errors path="city" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Hotel Name</td>
				<td><form:input path="hotelName" name="hotelName" /> <form:errors
						path="hotelName" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><form:textarea path="hotelAddress" name="address" /> <form:errors
						path="hotelAddress" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><form:textarea path="description" name="description" /> <form:errors
						path="description" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Average Rate Per Night</td>
				<td><form:input path="avgRatePerNight" name="avgRatePerNight" />
					<form:errors path="avgRatePerNight" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Phone Number1</td>
				<td><form:input path="phoneNo1" name="phoneNo1" /> <form:errors
						path="phoneNo1" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Phone Number2</td>
				<td><form:input path="phoneNo2" name="phoneNo2" /> <form:errors
						path="phoneNo2" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Rating</td>
				<td><form:select path="rating" required="true">
						<form:option value="" label="----Please select----" />
						<form:options items="${rating }" />
					</form:select> <form:errors path="rating" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="hotelEmail" name="hotelEmail" /> <form:errors
						path="hotelEmail" cssStyle="color:red" /></td>

			</tr>
			<tr>
				<td>Fax</td>
				<td><form:input path="fax" name="fax" /> <form:errors
						path="fax" cssStyle="color:red" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" class="href"/></td>
			</tr>
		</form:form>
	</table>
	
</center>
	</div>
</body>
</html>