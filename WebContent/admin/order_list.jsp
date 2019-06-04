<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<link href="../css/style.css" rel="stylesheet">
<title>Manage OrderList-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
		
			<div class="col-12">
				<h3>Books Order Management</h3>
			</div>
			<c:choose>
				<c:when test="${message!=null}">
					<div class="col-12">
						<h4 class="message">${message}</h4>
					</div>
				</c:when>
				<c:otherwise>
					<br>
					<br>
				</c:otherwise>
			</c:choose>

			<div class="col-12">
				<table border=1 class="table table-striped table-bordered">
					<tr>
						<th>Index</th>
						<th>Ordered ID</th>
						<th>Ordered By</th>
						<th>Book Copies</th>
						<th>Total</th>
						<th>Payment method</th>
						<th>Status</th>
						<th>Order Date</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="order" items="${listOrder}" varStatus="status">
					<tr>
							<td>${status.index + 1 }</td>
							<td>${order.orderId }</td>
							<td>${order.customer.fullname}</td>
							<td>${order.getBookCopies()}</td>
							<td><fmt:formatNumber value="${order.total}" type="currency" />
							</td>
							<td>${order.paymentMethod}</td>
							<td>${order.status }</td>
							<td>${order.orderDate }</td>
							<td><a href="view_order?id=${order.orderId}">Details</a> <a
								href="edit_order?id=${order.orderId}">Edit</a> <a
								href="javascript:confirmDelete(${order.orderId})">Delete</a></td>
						</tr>					
					</c:forEach>

				</table>
			</div>
			</div>
			
<jsp:directive.include file="admin_footer.jsp" />
<script type="text/javascript">
function confirmDelete(orderId){
	if(confirm("Are u sure to delete order with ID "+ orderId+" ?")){
	window.location = "delete_order?id="+orderId;
		}
}
</script>
</body>
</html>
