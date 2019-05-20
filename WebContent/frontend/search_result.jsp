<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Books for ${keyword}-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">
		<c:if test="${fn:length(result)==0}">
			<h3>No result found for ${keyword}</h3>
		</c:if>
		<c:if test="${fn:length(result)>0}">


			<div class="row">
				<div class="col-lg-12">
					<h2>Results for ${keyword}</h2>

				</div>
			</div>
			<div class="row">
				<c:forEach items="${result}" var="book">
					<div class="col-lg-12 col-sm-12 col-xs-12 px-0 mx-0 py-3">
					<div class="row">
						<div class=" col-3 px-0  text-center">
							<a href="view_book?id=${book.bookId}"><img
								src="data:image/jpg;base64,${book.base64Image }" width="150" height="184" /></a>
						</div>
						<div class=" col-6 " align="left">
							<h4><a href="view_book?id=${book.bookId}"> <b style="color:black;">${book.title}</b></a></h4>
							<p>Rating *****</p>
							<p><i>by ${book.author}</i></p>
							<p>${fn:substring(book.description,0,120)}...</p>

						</div>
						<div class="col-3 font-weight-bold ">
								<span style="font-size:22px">$ ${book.price}</span>
								<br/><button type="submit" class="btn btn-primary">Add To Cart</button>
						</div>
					</div>
						
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>