<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet"
	type="text/css" />
<title>Insert title here</title>
</head>
<body>

	<%@include file="HBMS_Admin_HomePage.jsp"%>
	<div class="page2">
	<form:form>
<center>
		<table border=1 class="table">
			<tr>
				<h2>Rooms</h2>
			</tr>
			<tr>
				<th>Hotel Id</th>
				<th>City</th>
				<th>Hotel Name</th>
			</tr>
			<c:forEach var="hotelList" items="${hotelList}">
				<tr>
					<td><a href="hotelRooms?hId=${hotelList.hotelId}"
						class="href">${hotelList.hotelId}</a></td>
					<td><c:out value="${hotelList.city}" /></td>
					<td><c:out value="${hotelList.hotelName}" /></td>
				</tr>
			</c:forEach>



		</table><br>
		</center>
	</form:form>
	
</div>
</body>
</html>