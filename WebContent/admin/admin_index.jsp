<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->

<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<!-- Libraries CSS Files -->
<link href="../lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../lib/animate/animate.min.css" rel="stylesheet">



<meta charset="ISO-8859-1">
<title>BookStore Administration</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<h3 align="center" class="py-2">Administrative Dashboard</h3>
	<hr width="60%;"/>
	<div class="container" align="center">
		<div class="row">
			
			<div class="col-sm-12">
			<h4 align="center">QuickActions</h4>
				<a href="/user_list">NewUser</a> &nbsp; <a href="createcategory">NewCategory</a>
				&nbsp; <a href="createbook">NewBook</a> &nbsp; <a
					href="createcustomer">NewCustomer</a> &nbsp;
			</div>
			<div class="col-sm-12 ml-2">
				<div class="col-sm-12 text-center">
					<h4>Recent Sales</h4>
					<table class="table table-striped table-bordered text-center">
						<thead>
							<tr>
								<th>Firstname</th>
								<th>Lastname</th>
								<th>Email</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>John</td>
								<td>Doe</td>
								<td>john@example.com</td>
							</tr>
							<tr>
								<td>Mary</td>
								<td>Moe</td>
								<td>mary@example.com</td>
							</tr>
							<tr>
								<td>July</td>
								<td>Dooley</td>
								<td>july@example.com</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
	<jsp:directive.include file="admin_footer.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>