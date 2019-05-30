<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css"	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Customer Profile-Online BookStore</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<hr width="60%;" />
	<div align="center">
	<h4>Welcome, ${loggedCustomer.fullname}</h4>
	</div>
	<div class="container" align="center">
	<table class="customer">
	<tr>
	<td><b>E-mail:</b><td>${loggedCustomer.email}</td>
	</tr>
	<tr>
	<td><b>Fullname:</b><td>${loggedCustomer.fullname}</td>
	</tr>
	<tr>
	<td><b>Address:</b><td>${loggedCustomer.address}</td>
	</tr>
	<tr>
	<td><b>PhoneNo:</b><td>${loggedCustomer.phone}</td>
	</tr>
	<tr>
	<td><b>City:</b><td>${loggedCustomer.city}</td>
	</tr>
	<tr>
	<td><b>Zipcode:</b><td>${loggedCustomer.zipcode}</td>
	</tr>
	<tr>
	<td><b>Country:</b><td>${loggedCustomer.country}</td>
	</tr>	
	<tr> 
	<td colspan="2" align="center">
	<b><a href="edit_profile">Edit Profile</a></b> &nbsp; &nbsp; &nbsp;
	<b><a href="${pageContext.request.contextPath}">Go to Shopping</a></b>
	</td>
	
	</tr>
	</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>	
	
	
	
	
	
	