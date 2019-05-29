<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab"	rel="stylesheet">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Review Posted-Online BookStore</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	
	<div class="container" style="border: 1px grey solid;">
		<form name="reviewform" action="submit_review" method="post">
			<table class="table borderless">
				<tr>
					<td align="left"><h4>Your Reviews</h4>
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
				<input type="hidden" name="bookId" value=" ${bookbookId}" />
				</td>
				</tr>
				<tr>
				<td> <b>Your Review has been posted successfully.Thank you!</b>
				</tr>		
			</table>
		</form>
	</div>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>