<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <!-- 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<!-- 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->

<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>
<link href="../css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>

<body>
	<jsp:directive.include file="admin_header.jsp" />
	
	<div class="container py-1" align="center">
		<div class="row">
		<div class="col-12">
		<h3 align="center">Admin Login</h3>
		</div>		
		<c:if test="${message!=null}">
		<div class="col-12">
		<h4 align="center">${message}</h4>
		</div>
		</c:if>		
		
		</div>
			<div class="col-12">
				<form action="admin_login"  method="post" name="adminform">
					<table>
						<tr>
							<td>Email:</td>
							<td><input type="text" id="email" name="email" class="form-control"
								placeholder="enter email" /></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type="password" id="password" name="password"
								placeholder="enter password" class="form-control"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="submit" value="Login" class="btn btn-primary" /></td>
							<td></td>
					</table>
				</form>
			</div>
		</div>
	
	<jsp:directive.include file="admin_footer.jsp" />
	<script>
		$(function() {
			$("form[name='adminform']").validate(
					{
				rules : {
					email : {
						required : true,
						email : true
					},
					password : "required",
				},
				message : {
					email : {
						required : "Please enter email",
						email : "Please enter valid an email address"
					},
					password : "Please enter password"

				},
				submitHandler : function(form) {
					form.submit();
				}

			});

		});
	</script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
 <!-- aman@mail.com 12345 -->
</body>
</html>
