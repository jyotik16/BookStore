<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
	<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="../lib/animate/animate.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
	<script src="../js/jquery-ui.min.js"></script>
	<script src="../css/jquery-ui.min.css"></script>
	<script src="../js/jquery-3.4.0.min.js"></script>
	<script src="../js/jquery.validate.min.js"></script>

<meta charset="ISO-8859-1">
<title>Edit Review</title>
</head>
<body>
	<jsp:directive.include file="admin_header.jsp" />
				<h3 class="pageheading">Edit Review</h3>
	<hr width="60%;" />
	<div class="container" id="review-div">
		<div class="row">
			<div class="col-8">				
				<form name="reviewform" action="update_review" method="post" id="reviewform">
					<input type="hidden" name="reviewId" value="${review.reviewId}">
				<table>
				<tr>
				<td><b>Book:</b></td><td> ${review.book.title}</td>
				</tr>
				<tr>
				<td><b>Rating:</b></td><td> ${review.rating}</td>
				</tr>
				<tr>
				<td><b>Customer:</b></td><td> ${review.customer.fullname}</td>
				</tr>
				<tr>
				<td><b>Headline:</b></td><td> <input type="text" class="form-control" name="headline" id="headline" value="${review.headline}" /></td>
				</tr>
				<tr>
				<td><b>Comment:</b></td><td> <textarea rows="5" cols="70" name="comment"> ${review.comment} </textarea></td>
				</tr>
				<tr>
				<td><button type="submit" class="btn btn-primary">Save &nbsp;</button> </td>
				<td><input type="button" class="btn btn-primary" onclick="javascript:history.go(-1);" value="Cancel" /></td> 
				</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("form[name='reviewform']").validate({
			rules: {
				headline: "required",
				comment: "required",
				},
			messages:{
				headline: "Please enter headline",
				comment: "Please enter comment"
			},
			
			submitHandler: function(form){
				form.submit();
				}		
			});
			
			});
	</script>
	<jsp:directive.include file="admin_footer.jsp" />
</body>
</html>