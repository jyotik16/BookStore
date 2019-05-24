<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--  <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>${book.title}-Online Book shop</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />
	<div class="container my-2" style="border:2px solid grey;">
		<div class="row m-2">
			<div class="col-12">
				<h3> ${book.title} </h3> By <i> ${book.author} </i>
			</div>
		</div>
		<div class="row m-2">
			<div class="col-3 col-xs-12 pr-0 mr-0" >
			<img src="data:image/jpg;base64,${book.base64Image }" id="book-detail" />
			</div>
			<div class="col-7 col-xs-12" >
				<div class="row">
					<div class="col-xs-12 col-12">
					<b>Rating ***** </b>
					
					</div>
					<div class="col-xs-12 col-12 text-justify" >
					<h4>Description</h4>
					<p class="nosapce">${book.description}</p>
					</div>
				</div>
			</div>
			<div class="col-2">
					$ <b>${book.price}</b> <br/>
					<button type="submit" class="btn btn-primary">Add To Cart</button>
			</div>					
		</div>
		<div class="row m-2">
		<div class="col-4">
			<h4>Customer Reviews</h4>
		</div>
		<div class="col-8">
		<button type="submit" class="btn btn-primary">Write Reviews</button>
		</div>
		</div>
	</div>
<jsp:directive.include file="footer.jsp" />	

</body>
</html>