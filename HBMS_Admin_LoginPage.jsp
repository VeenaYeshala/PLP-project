<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=<c:url value="/Styles/hotel.css" /> rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
<div class="body"></div>

	<div class="heading"><h3>Welcome To Hotel Management System</h3></div>
	<div class="grad"></div>
 

	
		<form:form method="post" modelAttribute="login" action="validateLogin" class="login-form">
    
	<div class="header">
		
			<div>Admin<span>Login</span></div>
			</div>
		<div class="login">
			<form:input type="text" placeholder="userid" path="userid" value="1001" /><br>
				 <form:errors	path="userid" cssStyle="color:red" />
			
			 <form:input type="password" placeholder="password" path="password" value="admin" /><br>
				<form:errors	path="password" cssStyle="color:red" />
				<input type="submit" value="login">
				
				<p><span style="color:red">${exception}</span></p>
				</div>
				
				
			
		</form:form>
		

</body>
</html>