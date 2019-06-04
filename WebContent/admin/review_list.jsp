<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../lib/animate/animate.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<link href="../css/style.css" rel="stylesheet">
<title>Manage ReviewList-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
		
			<div class="col-12">
				<h3>Review Management</h3>
			</div>
			<c:choose>
			<c:when test="${message!=null}">
			<div class="col-12">
			<h4 class="message"> ${message} </h4>
			</div>
			</c:when>
			<c:otherwise>
			<br><br>
			</c:otherwise>
			</c:choose>
			
			<div class="col -12">
				<table border=1 class="table table-striped table-bordered">
					<tr>
						<th>Index</th>
						<th>ID</th>
						<th>Book</th>
						<th>Rating</th>
						<th>Headline</th>
						<th>Customer</th>
						<th>Review On</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="reviewList" items="${listreviews}" varStatus="status">
					<tr>
					<td> ${status.index + 1 } </td>
					<td> ${reviewList.reviewId } </td>
					<td> ${reviewList.book.title } </td>
					<td> ${reviewList.rating } </td>
					<td> ${reviewList.headline } </td>
					<td> ${reviewList.customer.fullname } </td>
					<td> ${reviewList.reviewTime } </td>
					<td><a href="edit_review?id=${reviewList.reviewId}">Edit</a>	
					<a href="javascript:confirmDelete(${reviewList.reviewId})">Delete</a></td>
					</tr>					
					</c:forEach>

				</table>
			</div>
			</div>
			
<jsp:directive.include file="admin_footer.jsp" />
<script>
function confirmDelete(reviewId){
	if(confirm("Are u sure to delete review with ID "+ reviewId+" ?")){
	window.location = "delete_review?id="+reviewId;
		}
}
</script>
</body>
</html>
