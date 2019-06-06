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
<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> -->
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<meta charset="ISO-8859-1">
<title>${book.title}-OnlineBook shop</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<div class="container my-2" style="border: 2px solid grey;">
		<table class="table borderless">
			<tr>
				<td colspan="2">
					<h3>${book.title}</h3>
				</td>
				<td></td>
			</tr>
			<tr>
				<td>By <i> ${book.author} </i>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td><img src="data:image/jpg;base64,${book.base64Image }"id="book-detail" /></td>
				<td><jsp:directive.include file="book_rating.jsp" />
					<a href="#reviews">${fn:length(book.reviews)} Reviews</a>
					<h4>Description</h4> ${book.description}</td>
				<td>$ <b>${book.price}</b> <br />
					<input type="hidden" name="id" value="${book.bookId}"> 
					<button class="btn btn-primary btn-block" id="ButtonAddToCart" style="width:150px;">
					Add	To Cart</button>
				</td>
			</tr>
			<tr>
				<td colspan="2"><h4>Customer Reviews</h4></td>
				<td>
				<a href="write_review?id=${book.bookId}">Write Reviews</a>
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="3">
					<table class="table borderless">
						<c:forEach items="${book.reviews}" var="review">
							<tr>
								<td>	<c:forTokens items="${review.getStars()}" delims="," var="star">
										<c:if test="${star eq 'on'}">
											<img src="images/rating-on.png" />
										</c:if>
										<c:if test="${star eq 'off'}">
											<img src="images/rating-off.png" />
										</c:if>
										</c:forTokens>
										-<b> ${review.headline}</b>
								</td>
							</tr>
							<tr>
								<td>
								by ${review.customer.fullname} on ${review.reviewTime}
								</td>
							</tr>
							<tr>
								<td><i> ${review.comment}</i></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
							</tr>
						</c:forEach>
					</table> 
				</td>
			</tr>
		</table>
	</div>
	<jsp:directive.include file="footer.jsp" />
	<script type="text/javascript">
	$(document).ready(function() {
    $("#buttonWriteReview").click(function(){
			window.location ='write_review?id='+${book.bookId};
		});
    $("#ButtonAddToCart").click(function(){
		window.location ='add_to_cart?bookId='+${book.bookId};
	});
	});
</script> 
</body>
</html>