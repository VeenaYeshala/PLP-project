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
		<form:form method="POST" modelAttribute="updateRoom"
			action="updateOneRoom">
			<tr><h2>Update Room</h2></tr>
			<tr>
				<td>HotelId</td>
				<td><form:input value="${roomDto.roomId}" path="roomId"
						readonly="true" /></td>
			</tr>


			<tr>
				<td>HotelId</td>
				<td><form:input value="${roomDto.hotelId}" path="hotelId"
						name="hotelId" readonly="true" /></td>
			</tr>

			<tr>
				<td>Room Id</td>
				<td><form:input value="${roomDto.roomId}" path="roomId"
						name="roomId" readonly="true"/> <form:errors path="roomId" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Room Type</td>
				<td><form:input value="${roomDto.roomType}" path="roomType"
						name="roomType" /> <form:errors path="roomType"
						cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Per Night rate</td>
				<td><form:input value="${roomDto.perNightRate}"
						path="perNightRate" name="perNightRate" /> <form:errors
						path="perNightRate" cssStyle="color:red" /></td>
			</tr>

			<tr>
				<td>Availability</td>
				<td><form:input value="${roomDto.availability}" path="availability"
						name="availability" /> <form:errors path="availability"
						cssStyle="color:red" /></td>
			</tr>

<tr><td><a href="home" class="href">Home</a></td>
			<td><input type="submit" value="update" class="href"/></td>
</tr>
		</form:form>
	</table>
</center></div>
</body>
</html>