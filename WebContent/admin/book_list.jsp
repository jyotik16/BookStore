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
<link href="../css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<meta charset="ISO-8859-1">
<title>Manage BooksList-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">		
			<div class="col-12">
				<h3>Book Management</h3>
				<a href="new_book">Create New Book </a>
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
						<th>ID</th>
						<th>Image</th>
						<th>Title</th>
						<th>Author</th>
						<th>Category</th>
						<th>Price</th>
						<th>Last Updated</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="book" items="${listBooks}" varStatus="status">
						<tr>
							<td>${status.index + 1 }</td>
							<td>${book.bookId }</td>
							<td><img src="data:image/jpg;base64,${book.base64Image }"
								width="84" height="110"></td>
							<td>${book.title }</td>
							<td>${book.author }</td>
							<td>${book.category.name }</td>
							<td>$ ${book.price }</td>
							<td><fmt:formatDate pattern="MM/dd/yyyy"
									value='${book.lastUpdateTime}' /></td>
							<td><a href="edit_book?id=${book.bookId}">Edit</a> 
								<a href="javascript:void(0);" class="deleteLink"
								id="${book.bookId}">Delete</a>
							</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	
	<jsp:directive.include file="admin_footer.jsp" />
	<script>
		$(document).ready(function() {
				$(".deleteLink").each(function()
						{$(this).on("click",function() {
														bookId = $(this).attr("id");
														if (confirm("Are u sure to delete the book whose ID "+ bookId +" ?")) {
																		window.location ='delete_book?id='+bookId;
																	}
									});
						});
			});
	</script>
	
</body>
</html>
