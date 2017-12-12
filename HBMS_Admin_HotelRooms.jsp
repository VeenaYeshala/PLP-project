<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>HOTEL ROOMS</title>
</head>
<body>

<%@include file="HBMS_Admin_HomePage.jsp" %>
<div class="page2">
<center>
	<table border=1 class="table">
	<tr><h2>All Rooms in Hotel ${hotelId}</h2></tr>
		<tr>
			<th>Hotel Id</th>
			<th>Room Id</th>
			<th>Room Type</th>
			<th>rate per night</th>
			<th>Availability</th>
			<th colspan='2'>Operations</th>
		</tr>
		<c:forEach var="hotelRoomList" items="${hotelRooms}">
			<tr>
				<td><c:out value="${hotelRoomList.hotelId}" /></td>
				<td><c:out value="${hotelRoomList.roomId}" /></td>
				<td><c:out value="${hotelRoomList.roomType}" /></td>
				<td><c:out value="${hotelRoomList.perNightRate}" /></td>
				<td><c:out value="${hotelRoomList.availability}" /></td>





				<td><a
					href="deleteRooms?hId=${hotelRoomList.hotelId}&rId=${hotelRoomList.roomId}" class="href">Delete</a>

				</td>
				<td><a
					href="updateRooms?hId=${hotelRoomList.hotelId}&rId=${hotelRoomList.roomId}" class="href">Update</a>
				</td>
			</tr>

		</c:forEach>
	</table>
	<center><table class="table"><tr><td>
<a href="addRoom?hId=${hotelId}" class="href3">Add Room</a></td></tr>s	
</table></center>
	</center>
	</div>
	

</body>
</html>