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
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<meta charset="ISO-8859-1">
<title>Manage CustomerList-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
		<div class="row">
			<div class="col-12 py-2">
				<h3>Customer Management</h3>
				<a href="customer_form.jsp">Create New Customer </a>

			</div>
			<c:choose>
				<c:when test="${message!=null}">
					<div class="col-sm-12">
						<h4 class="message">${message}</h4>
					</div>
				</c:when>
				<c:otherwise>
					<br>
					<br>
				</c:otherwise>
			</c:choose>

			<div class="col-sm-12">
				<table border=1 class="table">
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>E-mail</th>
						<th>Fullname</th>
						<th>City</th>
						<th>Country</th>
						<th>Registered Date</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="customer" items="${listcustomer}" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${customer.customerId }</td>
							<td>${customer.email }</td>
							<td>${customer.fullname }</td>
							<td>${customer.city }</td>
							<td>${customer.country }</td>
							<td>${customer.registerDate }</td>
							<td><a href="edit_customer?id=${customer.customerId}">Edit</a> 
								<a href="javascript:void(0);" class="deleteLink"
								id="${customer.customerId}">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>
	<jsp:directive.include file="admin_footer.jsp" />
	<script>
		$(document).ready(function() {
				$(".deleteLink").each(function()
						{$(this).on("click",function() {
										customerId = $(this).attr("id");
											if (confirm("Are u sure to delete the customer whose ID "+ customerId +" ?")) {
													window.location ='delete_customer?id='+customerId;
												}
									});
						});
			});
	</script>
	
</body>
</html>
