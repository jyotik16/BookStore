<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab"
	rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="..//css/richtext.min.css">
<!-- <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="css/style.css" rel="stylesheet">

<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<meta charset="ISO-8859-1">
<title>Register as a Customer</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h3 class="pageheading">Register as a Customer</h3>
	<hr width="60%;" />
	<div class="container customer-form" style="margin-left: 29%;">
		<div class="row">	
		<div class="col-6 mb-5">
				<form name="customerform" id="customerform"	action="register_customer" method="post">
					<input type="hidden" name="customerID" id="customerID" />
				<div class="col-12">
					<div class="md-form py-2">
						<label for="email">E-mail:</label> 
						<input type="text"	class="form-control" id="email" name="email"
							placeholder="Enter Email" />
					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="fullname">Fullname:</label> <input type="text"
							class="form-control" id="fullname" name="fullname"
							placeholder="Enter fullname" />
					</div>
				</div>

				<div class="col-12">
					<div class="md-form py-2">
						<label for="password">Password:</label> <input type="password"
							class="form-control " id="password" name="password"
							placeholder="Enter password" />

					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="confirmpassword">Confirm Password:</label> 
						<input	type="password" class="form-control" id="confirmpassword"
							name="confirmpassword" placeholder="Enter password"	/>
					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="Phone no">Phone no:</label> <input type="text"
							class="form-control" id="phoneno" name="phoneno"
							placeholder="Enter Phone no"  />

					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="address">Address:</label> <input type="text"
							class="form-control" id="address" name="address"
							placeholder="Enter address"  />

					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="city">City:</label> <input type="text"
							class="form-control" id="city" name="city"
							placeholder="Enter city" />

					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="country">Country:</label> <input type="text"
							class="form-control" id="country" name="country"
							placeholder="Enter country"  />

					</div>
				</div>
				<div class="col-12">
					<div class="md-form py-2">
						<label for="zipcode">Zipcode:</label> <input type="text"
							class="form-control" id="zipcode" name="zipcode"
							placeholder="Enter zipcode"  />

					</div>
				</div>
			<div class="col-12 py-2">
				<button type="submit" class="btn btn-primary">Submit</button>
				<input type="button" class="btn btn-primary"
					onclick="javascript:history.go(-1);" value="Cancel" />
			</div>
			</form>
			</div>
		</div>
		
	</div>
	<script type="text/javascript">
		$(function() {
			$("form[name='customerform']").validate({
				rules : {
					email : {
						required : true,
						email : true
					},
					fullname : "required",
					password : "required",
					confirmpassword : {
						required : true,
						equalTo : "#password"
					},
					address : "required",
					phoneno : "required",
					city : "required",
					country : "required",
					zipcode : "required",
				},
				messages : {
					email : {
						required : "Please enter your email ",
						email : "Please enter valid email"
					},
					fullname : "Please enter your full name ",
					password : "Please enter password ",
					confirmpassword : {
						required : "Please confirm password",
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