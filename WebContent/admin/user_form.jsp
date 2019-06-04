<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<meta charset="ISO-8859-1">
<c:choose>
		<c:when test="${user!=null}">
			<title>Edit User</title>
		</c:when>
		<c:otherwise>
			<title>Create New User</title>
		</c:otherwise>
</c:choose>

</head>
<body>
	<jsp:directive.include file="admin_header.jsp" />

	<c:choose>
		<c:when test="${user!=null}">
			<h3 class="pageheading">Edit User</h3>
		</c:when>
		<c:otherwise>
			<h3 class="pageheading">Create New User</h3>
		</c:otherwise>
	</c:choose>

	<hr width="60%;" />
	<div class="container" align="center">
			<div class="col-8">
			
				<c:if test="${user != null}">
					<form name="userform" id="userform" action="update_user" method="post" >
						<input type="hidden" name="userId" value="${user.userid}">
				</c:if>
				<c:if test="${user == null}">
					<form name="userform" id="userform" action="create_user" method="post">
				</c:if>
				<table class="table borderless">
				<tr>
				<td> <b>Email:</b></td>
				 <td><input	type="text" class="form-control" id="email" name="email"
						aria-describedby="emailHelp" placeholder="Enter email" value="${user.email}"/> 
						<small id="emailHelp" class="form-text text-muted">
						We'll never share your email with anyone else.</small>
				</td>
				</tr>
				<tr>
				<td> <b>Fullname :</b></td> 
				<td><input	type="text" class="form-control" id="fullname" name="fullname"
						 placeholder="Enter fullname" value="${user.fullname}"/>
				</td>
				</tr>
				<tr>
				<td> <b>Password :</b></td>  
				<td>	<input	type="text" class="form-control" id="password" name="password"
						 placeholder="Enter password" value="${user.password}"/>
				</td>
				</tr>
				<tr>
				<td> &nbsp; &nbsp; </td>
				<td><button type="submit" class="btn btn-primary">Submit</button> &nbsp; &nbsp;
				 <input type="button" class="btn btn-primary" onclick="javascript:history.go(-1);" value="Cancel"/>
				</td>
				</tr>
				</table>
				</form>
				</div>
			</div>
	<script type="text/javascript">

	$(function(){
	$("form[name='userform']").validate({
		rules: {
			fullname: "required",
			email:{
				required: true,
				email: true
				},
			password: {
				required: true,
		        minlength: 5
				}
			},
		messages:{
			fullname: "Please enter your full name",
			password:{
				required: "Please provide a password",
		        minlength: "Your password must be at least 5 characters long"
				},
			email: "Please enter a valid email address"
				},

		submitHandler: function(form){
			form.submit();
			}		
		});
		
		});
	
		
	</script>
	<jsp:directive.include file="admin_footer.jsp" />
</body>
</html>