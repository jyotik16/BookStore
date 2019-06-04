<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="../css/style.css" rel="stylesheet">
<!-- jquery for stars -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="ISO-8859-1"><title>Page Not Found Error</title>
</head>
<body>
<jsp:directive.include file="error_header.jsp" />
<div align="center">
	
	<div>
		<h3>Sorry, the requested page could not be found.</h3>
	</div>	
	<div>
		<a href="javascript:history.go(-1);">Go Back</a>
	</div>
</div>
</body>
</html>