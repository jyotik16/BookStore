<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="css/style.css" rel="stylesheet">

<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<script src="js/jquery-ui.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register as a Customer</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h3 class="pageheading">Edit My profile</h3>
	<hr width="60%;" />
	<div class="container" >
		<div class="row">
		<div class="col-12" align="center">
		<form action="update_profile" method="post" name="customerform">		
		<table>
		<tr>
		<td><b>E-mail:</b><td><b>${loggedCustomer.email}</b> <i>{Cannot be changed}</i></td>
		</tr>
		<tr>
		<td><b>Fullname:</b><td><input type="text"  id="fullname" name="fullname" value="${loggedCustomer.fullname}"
						placeholder="Enter fullname" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>Phone no:</b><td><input type="text"  id="phoneno" name="phoneno" value="${loggedCustomer.phone}"
						placeholder="Enter phoneno" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>Address:</b><td><input type="text"  id="address" name="address" value="${loggedCustomer.address}"
						placeholder="Enter address" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>City:</b><td><input type="text"  id="city" name="city" value="${loggedCustomer.city}"
						placeholder="Enter city" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>Country:</b><td><input type="text"  id="country" name="country" value="${loggedCustomer.country}"
						placeholder="Enter country" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>Zipcode:</b><td><input type="text"  id="zipcode" name="zipcode" value="${loggedCustomer.zipcode}"
						placeholder="Enter zipcode" class="form-control"/></td>
		</tr>
		<tr>
		<td colspan="2"> (leave password fields blank if you don't want to change password) </td>
		</tr>
		<tr>
		<td><b>Password:</b><td><input type="password"  id="password" name="password" "
						placeholder="Enter password" class="form-control"/></td>
		</tr>
		<tr>
		<td><b>Confirm Password:</b><td><input type="password"  id="confirmpassword" name="confirmpassword" 
						placeholder="confirm password" class="form-control"/></td>
		</tr>
		<tr>
			<td> &nbsp; <button type="submit" class="btn btn-primary">Save</button><td>
			<input type="button" class="btn btn-primary" onclick="javascript:history.go(-1);" value="Cancel" /><td> &nbsp; </td>
		</tr>
		</table>
		</form>
		</div>		
	</div>		
</div>
	<script type="text/javascript">
		$(function() {
			$("form[name='customerform']").validate({
				rules : {
					fullname : "required",					
					confirmpassword : {
						
						equalTo : "#password"
					},
					address : "required",
					phoneno : "required",
					city : "required",
					country : "required",
					zipcode : "required",
				},
				messages : {
					
					fullname : "Please enter your full name ",
					
					confirmpassword : {
						
						equalTo : "Confirm password does not match a password"
					},
					address : "Please enter address ",
					phoneno : "Please enter phone no ",
					city : "Please enter city ",
					country : "Please enter country ",
					zipcode : "Please enter zipcode "
				},

				submitHandler : function(form) {
					form.submit();
				}
			});

		});
	</script>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>