<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Order Details-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">
		<c:if test="${order == null}">
		<h4>Sorry,You are not athorized to view this order </h4>
		</c:if>
		<c:if test="${order !=null }">
		<div class="row">		
		<div class="col-10" style="margin-left:20%;">
		<h3>Your Order ID: ${order.orderId} </h3>
		<table class="table borderless" >
		<tr>
			<td><b>Ordered By:</b></td>
			<td>${order.customer.fullname}</td>
		</tr>
		<tr>
			<td><b>Order Date:</b></td>
			<td>${order.orderDate}</td>
		</tr>
		<tr>
			<td><b>Quantity:</b></td>
			<td>${order.getBookCopies()}</td>
		</tr>
		<tr>
			<td><b>Total Amount:</b></td>
			<td><fmt:formatNumber value="${order.total}" type="currency" /></td>
		</tr>
		<tr>
			<td><b>Recipient Name:</b></td>
			<td>${order.recipientName}</td>
		</tr>
		<tr>
			<td><b>Recipient Phone no:</b></td>
			<td>${order.recipientPhone}</td>
		</tr>
		<tr>
			<td><b>Payment Method:</b></td>
			<td>${order.paymentMethod}</td>
		</tr>
		<tr>
			<td><b>Ship To:</b></td>
			<td>${order.shippingAddress}</td>
		</tr>		
		
		</table>
		</div>
		</div>
		<div class="row py-2" >
		<div class="col-10" style="margin-left:10%;">
		<h4>Ordered Books</h4>
		<table class="table">
		<tr>
			<th>Index</th> <th>Book</th><th>Author</th><th>Price</th><th>Quantity</th><th>SubTotal</th>
		</tr>
		<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
		<tr>
			<td>${status.index +1} </td>
			<td><img style="vertical-align:middle;"src="data:image/jpg;base64,${orderDetail.book.base64Image}" width="64" height="78"/> 
				<a href="view_book?id=${orderDetail.book.bookId}"">${orderDetail.book.title}</a>
			</td>
			<td> ${orderDetail.book.author}</td>
			<td> <fmt:formatNumber value="${orderDetail.book.price}" type="currency" /></td>
			<td> ${orderDetail.quantity}</td>
			<td> <fmt:formatNumber value="${orderDetail.subtotal}" type="currency" /></td>
		</tr>
		</c:forEach>
		<tr>
		<td colspan="4" align="right">TOTAL:</td>
		<td> ${order.getBookCopies()}</td>
		<td> ${order.total}</td>
		</tr>
		</table>		
		</div>
		</div>
		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>
