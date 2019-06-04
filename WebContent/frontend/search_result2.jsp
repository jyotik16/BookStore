<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="..//css/richtext.min.css">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
<link href="css/style.css" rel="stylesheet">
<script src="../js/jquery-ui.min.js"></script>
<script src="../js/jquery.richtext.min.js"></script>
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
				<div class="col-12">
					<h3>Results for ${keyword}</h3>
				</div>
			</div>	
			<c:forEach items="${result}" var="book">
					
					<div class="col-8">
						<table class="table borderless fixed">
						<tr>
						<td rowspan="6">
						<a href="view_book?id=${book.bookId}"> <img
								id="serach_book_img"
								src="data:image/jpg;base64,${book.base64Image }" 
								alt="" 	width="150" height="184"></a> 
						</td>
						</tr>
						<tr>
							<td>
									<h4><a href="view_book?id=${book.bookId}"> 
									<span class="book-title"><b>${book.title}</b></span></a>
								</h4>
							</td>							
						</tr>
						<tr>
							<td>
								<jsp:directive.include file="book_rating.jsp" />
							</td>							
						</tr>
						<tr>
							<td>
								<i>by ${book.author}</i>
							</td>							
						</tr>
						<tr>
							<td>
							${fn:substring(book.description,0,150)}...
							</td>							
						</tr>
						<tr>
							<td>
								<span style="font-size:22px">$ ${book.price}</span> &nbsp; &nbsp; &nbsp;
								<button type="submit" class="btn btn-primary">Add To Cart</button>
							</td>							
						</tr>
						
						</table>
								
					</div>
					
					</c:forEach>
				
			
		</c:if>
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>