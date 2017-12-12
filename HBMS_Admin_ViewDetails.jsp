<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="page2">
<center>
<%@include file="HBMS_Admin_HomePage.jsp" %>
<table class="table">


<tr>
<td><a href="viewListOfHotels" class="href">~~View List Of Hotels</a></td>
</tr>


<tr>
<td><a href="viewBookingsOfSpecificHotel" class="href">~~View Bookings of specific hotel</a></td>
</tr>
<tr>
<td><a href="bookingDetailsForSpecificDate" class="href">~~View Bookings for specific Date</a></td>
</tr>

</table></center></div>
</body>
</html>