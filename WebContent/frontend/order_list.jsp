<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet">
<title>Order History-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">
			<div class="col-12 py-2">
				<h3>My Order History</h3>
			</div>
			<c:if test="${fn:length(listOrders) == 0}">
				<h4>You have not placed any orders.</h4>
			</c:if>
			<c:if test="${fn:length(listOrders) > 0}">		
			<div class="col-10">
				<table border=1 class="table">
					<tr>
						<th>Index</th>
						<th>Ordered ID</th>
						<th>Quantity</th>
						<th>Total Amount</th>									
						<th>Order Date</th>
						<th>Status</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="order" items="${listOrders}" varStatus="status">
					<tr>
					<td> ${status.index + 1 } </td>
					<td> ${order.orderId } </td>
					<td> ${order.getBookCopies()} </td>
					<td> <fmt:formatNumber value="${order.total}" type="currency" /> </td>
					<td> ${order.orderDate } </td>
					<td> ${order.status } </td>
					<td> 
					<a href="show_order_detail?id=${order.orderId}">View Details</a>	
					</td>
					</tr>					
					</c:forEach>

				</table>
			</div>
			</c:if>			
			</div>
<jsp:directive.include file="footer.jsp" />
</body>
</html>
