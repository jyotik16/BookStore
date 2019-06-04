<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Add Books-Online BookStore</title>
</head>
<body>
	<div class="container" align="center">
		<h3>Add Book to your order ID: ${order.orderId}</h3>
		<form action="add_book_to_order" method="post">
			<table class="table borderless">
				<tr>
					<td>Select a book</td> 
				</tr>
				<tr>	
					<td>
					<select name="bookId" class="form-control">
						<c:forEach items="${listBook}" var="book" varStatus="status" >
							<option value="${book.bookId}"> ${book.title} - ${book.author}</option>
						</c:forEach>
					</select>
					</td>
					
				</tr>
				<tr> <td>Number Of Copies</td> 	</tr>
				<tr> 
					<td>
					<select name="quantity" class="form-control">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
					</td>
				</tr>
				<tr> <td></td> 	</tr>
				<tr>
					<td><button type="submit" class="btn btn-primary">Submit</button> &nbsp; &nbsp; &nbsp; &nbsp;
						<input type="button" Id="buttonCancel" value="Cancel" class="btn btn-primary" />
					</td> 
					
				</tr>
			</table>
		</form>
	</div>
	<script>
	$(function() {
			$("#buttonCancel").click(function(){
			history.go(-1);
			});
	});
	</script>
</body>
</html>