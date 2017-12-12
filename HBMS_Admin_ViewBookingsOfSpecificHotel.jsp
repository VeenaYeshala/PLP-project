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
<br><br><br>
<form:form   modelAttribute="bookingsDto"   action="displayBookingsForSpecificHotel">

<table class="table">
<tr><h2>Bookings for Specific Hotel</h2></tr>
<tr>
<td><h4>Enter Hotel Id :</h4></td><td><form:input path="hotelId" name="hotelId"/><form:errors
						path="hotelId" cssStyle="color:red" />
</td></tr><tr><td>
<input type="submit" value="Find" class="href"/></td>
</tr>

</table>


</form:form>
</center></div>
</body>
</html>