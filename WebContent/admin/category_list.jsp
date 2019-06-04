<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<link href="../css/style.css" rel="stylesheet">
<title>Manage CategoryList-Bookify-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
		
			<div class="col-12">
				<h3>Category Management</h3>
				<a href="category_form.jsp">Create New Category </a>				
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
						<th>Name</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="CategoryList" items="${listCategory}" varStatus="status">
					<tr>
					<td> ${status.index + 1 } </td>
					<td> ${CategoryList.categoryId } </td>
					<td> ${CategoryList.name } </td>
					<td><a href="edit_category?id=${CategoryList.categoryId}">Edit</a>	
					<a href="javascript:confirmDelete(${CategoryList.categoryId})">Delete</a></td>
					</tr>					
					</c:forEach>

				</table>
			</div>
			</div>
			
<jsp:directive.include file="admin_footer.jsp" />
<script>
function confirmDelete(categoryid){
	if(confirm("Are u sure to delete user with ID "+ categoryid+" ?")){
	window.location = "delete_category?id="+categoryid;
		}
}
</script>
</body>
</html>
