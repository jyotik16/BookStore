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
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<!-- Libraries CSS Files -->
<link href="../lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<h3 align="center" class="py-2">Administrative Dashboard</h3>
	<hr width="60%;"/>
	<div class="container" align="center">
		<div class="col-12">
			<h4 align="center">QuickActions</h4>
				<a href="user_form.jsp">NewUser</a> &nbsp; 
				<a href="category_form.jsp">NewCategory</a> &nbsp; 
				<a href="new_book">NewBook</a> &nbsp; 
				<a href="customer_form.jsp">NewCustomer</a> &nbsp;
			</div>
			<hr width="70%;"/>
				<div class="col-12 text-center">				
					<h4>Recent Sales</h4>
					<table class="table table-striped table-bordered text-center">
						<thead>
							<tr>
							<th>Order ID </th>
							<th>Ordered By</th>
							<th>Book Copies</th>
							<th>Total</th>
							<th>Payment Method</th>
							<th>Status</th>
							<th>Order Date</th>
						</tr>
						</thead>
						<tbody>
							<c:forEach items="${listMostRecentSales}" var="order"
								varStatus="status">
								<tr>
									<td><a href="view_order?id=${order.orderId}">${order.orderId}</a></td>
									<td>${order.customer.fullname}</td>
									<td>${order.bookCopies}</td>
									<td><fmt:formatNumber value="${order.total}" type="currency" /></td>
									<td>${order.paymentMethod}</td>
									<td>${order.status}</td>
									<td>${order.orderDate}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
				<hr width="70%;"/>
				<div class="col-12 text-center">
					<h4>Recent Reviews</h4>
					<table class="table table-striped table-bordered text-center">
						<thead>
							<tr>
							<th>Book </th>
							<th>Rating</th>
							<th>Headline</th>
							<th>Customer</th>
							<th>Review on</th>
						</tr>
						</thead>
						<tbody>
					<c:forEach items="${listMostRecentReviews}" var="review">
						<tr>
							<td>${review.book.title}</td>
							<td>${review.rating}</td>
							<td><a href="edit_review?id=${review.reviewId}">${review.headline}</a></td>
							<td>${review.customer.fullname}</td>
							<td>${review.reviewTime}</td>
						</tr>
					</c:forEach>
				</tbody>
				</table>
				</div>
				<hr width="60%" />
		<div class="col-12 mb-2 pb-4">			
			<h4>Statistics</h4>
			Total Users: ${totalUsers} &nbsp;&nbsp;&nbsp;&nbsp; Total Books:
			${totalBooks} &nbsp;&nbsp;&nbsp;&nbsp; Total Customers:
			${totalCustomers} &nbsp;&nbsp;&nbsp;&nbsp; Total Reviews:
			${totalReviews} &nbsp;&nbsp;&nbsp;&nbsp; Total Orders: ${totalOrders}
			
		</div>
		<hr width="70%" />
	</div>
	<jsp:directive.include file="admin_footer.jsp" />
</body>
</html>