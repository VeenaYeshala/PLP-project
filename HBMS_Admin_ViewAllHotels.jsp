<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<tr><h2>All Rooms </h2></tr>
<tr>
<th>Hotel Id</th>
<th>City</th>
<th>Hotel Name</th>
<th>Address</th>
<th>description</th>
<th>Average rate per night</th>
<th>Hotel Phone Number1</th>
<th>Hotel Phone Number2</th>
<th>Rating</th>
<th>Hotel Email</th>
<th>Hotel Fax</th>
</tr>
<c:forEach var="hotelList" items="${hotelList}">
<tr>
<td>
 <c:out value="${hotelList.hotelId}"/>
 </td>
 <td>
  <c:out value="${hotelList.city}"/>
  </td>
  <td>
  <c:out value="${hotelList.hotelName}"/>
  </td>
  <td>
  <c:out value="${hotelList.hotelAddress}"/>
  </td>
  <td>
  <c:out value="${hotelList.description}"/>
  </td>
  <td>
  <c:out value="${hotelList.avgRatePerNight}"/>
  </td>
  <td>
  <c:out value="${hotelList.phoneNo1}"/>
  </td>
  <td>
  <c:out value="${hotelList.phoneNo2}"/>
  </td>
  <td>
  <c:out value="${hotelList.rating}"/>
 
  </td>
  <td>
  <c:out value="${hotelList.hotelEmail}"/>
  </td>
  <td>
  <c:out value="${hotelList.fax}"/>
  </td>
  
  
  
  
  
 
 </c:forEach>
  


</table>
</center>
<br><br>
</div>
</body>
</html>