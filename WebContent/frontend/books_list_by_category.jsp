<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--  <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Libraries CSS Files -->
<link href="lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Book in ${category.name}-Online Book shop</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">
		<div class="row my-2">
			<div class="col-12 ">
				<h2>${ category.name}</h2>
			</div>
		</div>
		<div class="row">			
			<c:forEach items="${listBooks}" var="book">
				<div class="col-lg-4 col-sm-4 col-xs-12 px-0 mx-0 py-3">
					<div class="p-0">
						<a href="view_book?id=${book.bookId}"><img src="data:image/jpg;base64,${book.base64Image }" width="130" height="164" /></a>
					</div>
					<div class="p-0"><a href="view_book?id=${book.bookId}">
						<span class="book-title"><b>${book.title}</b></span></a>						
					</div>
					<div class="p-0">
					<jsp:directive.include file="book_rating.jsp" />
					</div>
					<div class="p-0"><i>${book.author}</i></div>
					<div class="p-0"><b>$ ${book.price}</b></div>
				</div>
			</c:forEach> 
		</div>
		</div>		
	<jsp:directive.include file="footer.jsp" />

</body>
</html>