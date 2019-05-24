<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
 
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet"></link>
<link href="../css/style.css" rel="stylesheet"></link>
<link href="../css/jquery-ui.min.css" rel="stylesheet"></link>
<script src="../js/jquery-ui.min.js"></script>
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<meta charset="ISO-8859-1">
<title>Manage UserList-Bookify-Online Book shop</title>
</head>

<body>
	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
		<div class="row">
			<div class="col-sm-12">
				<h3>User Management</h3>
				<a href="user_form.jsp">Create New User </a>
				
			</div>
			<c:choose>
			<c:when test="${message!=null}">
			<div class="col-sm-12 py-2">
			<h4 align="center"> ${message} </h4>
			</div>
			</c:when>
			<c:otherwise>
			<br><br>
			</c:otherwise>
			</c:choose>
			
			<div class="col-sm-12">
				<table border=1 cellpadding="10">
					<tr>
						<th >Index</th>
						<th>ID</th>
						<th>Email</th>
						<th>Fullname</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="user" items="${usersList}" varStatus="status">
					<tr>
					<td> ${status.index + 1 } </td>
					<td> ${user.userid } </td>
					<td> ${user.email } </td>
					<td> ${user.fullname } </td>
					<td><a href="edit_user?id=${user.userid}">Edit</a>	
					<a href="javascript:void(0);" class="deleteLink" id="${user.userid}">Delete</a></td>
					
 					<%-- <a href="javascript:confirmDelete(${user.userid})">Delete</a></td> --%>
					
					</tr>					
					</c:forEach>

				</table>
			</div>
			</div>
			</div>
<jsp:directive.include file="admin_footer.jsp" />
<script>
 $(document).ready(function(){
	$(".deleteLink").each(function(){
		$(this).on("click",function(){
			userid = $(this).attr("id");
			if(confirm("Are u sure to delete user with ID "+ userid+" ?")){
				window.location = "delete_user?id="+userid;
			}
			});
		});
});  

/*  function confirmDelete(userid){
	if(confirm("Are u sure to delete user with ID "+ userid+" ?")){
	window.location = "delete_user?id="+userid;
		}} */
 
</script>

</body>
</html>