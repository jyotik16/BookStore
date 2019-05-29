<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<meta charset="ISO-8859-1">
<title>Review info-Online BookStore</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div class="container" style="border: 1px grey solid;">
		<form name="reviewform">
			<table class="table borderless">
				<tr>
					<td align="left"><h4>you already wrote a review for this book.</h4>
					<td>&nbsp;</td>
					<td><b>${loggedCustomer.fullname}</b></td>
				</tr>
				<tr>
					<td colspan="3">
						<hr />
				</tr>
				<tr>
					<td colspan="3"><span class="book-title"> ${book.title}</span>
				</tr>
				<tr>	
					<td rowspan="3"><img src="data:image/jpg;base64,${book.base64Image }" id="book-detail" /></td>
				<td> <div id="rateYo"> </div>
				<input type="hidden" id="rating" name="rating" />
				<input type="hidden" name="bookId" value="${book.bookId}" />
				</td>
				</tr>
				<tr>
				<td><input type="text" name="headline" size="70" value="${review.headline}" readonly="readonly" /></td>
				</tr>
				<tr>
				<td><textarea name="comment" cols="70" rows="7" readonly="readonly"> ${review.comment}</textarea></td>
				</tr>
				</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
					
			$("#rateYo").rateYo({
			    starWidth: "40px",
				    fullStar:true,
				    rating:${review.rating},
				    readOnly:true
			  });
			$("#buttonCancel").click(function(){
				history.go(-1);
				});
		});
	</script>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>