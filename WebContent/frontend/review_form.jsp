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
<link rel="stylesheet" href="..//css/richtext.min.css">
<!-- <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<script src="js/jquery-3.4.0.min.js"></script>
<script src="js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<meta charset="ISO-8859-1">
<title>Write Review</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />
	<h3 class="pageheading">Write a review</h3>
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
					<td rowspan="3"><img src="data:image/jpg;base64,${book.base64Image }"
					id="book-detail" /></td>
				<td> <div id="rateYo"> </div>
				<input type="hidden" id="rating" name="rating" />
				<input type="hidden" name="bookId"  class="form-control" value="${book.bookId}" />
				</td>
				</tr>
				<tr>
				<td><input type="text" name="headline" size="70" class="form-control" placeholder="Headline or Summary for your review (required)" /></td>
				</tr>
				<tr>
				<td><textarea name="comment" cols="70" rows="7" class="form-control" 
							placeholder="Write Your Review..."></textarea></td>
				</tr>
				<tr>
				<td> &nbsp; &nbsp;</td>
				<td colspan="3"> <button type="submit" class="btn btn-primary" id="buttonWriteReview"> Submit</button> &nbsp;
				<button class="btn btn-primary" id="buttonCancel">Cancel</button>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		$(function() {
			$("form[name='reviewform']").validate({
				rules : {
					
					headline : "required",
					comment : "required",
				},
				messages : {
					
					headline : "Please enter headline ",
					comment : "Please enter reviw details ",
				},

				submitHandler : function(form) {
					form.submit();
				}
			});
			
			$("#rateYo").rateYo({
			    starWidth: "40px",
				    fullStar:true,
				    onSet: function (rating,rateYoInstance) {
							$("#rating").val(rating);
					    }
			  });
			$("#buttonCancel").click(function(){
				history.go(-1);
				});
		});
	</script>
	<jsp:directive.include file="footer.jsp" />
</body>
</html>