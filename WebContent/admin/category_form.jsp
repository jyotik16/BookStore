<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>	
	<script src="https://cdn.jsdelivr.net/jquery/1.12.4/jquery.min.js"></script>
<!-- Bootstrap CSS File -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Libraries CSS Files -->
<link href="../lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../lib/animate/animate.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">


<meta charset="ISO-8859-1">
<title>Create New Category</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />

	<c:choose>
		<c:when test="${category!=null}">
			<h3 align="center">Edit Category</h3>
		</c:when>
		<c:otherwise>
			<h3 align="center">Create New Category</h3>
		</c:otherwise>
	</c:choose>

	<hr width="60%;" />
	<div class="container" align="center">
		<div class="row">
			<div class="col-sm-10">
				<c:if test="${category != null}">
					<form name="categoryform" action="update_category" method="post"
						 id="categoryform">
						<input type="hidden" name="categoryId"
							value="${category.categoryId}">
				</c:if>
				<c:if test="${category == null}">
					<form name="categoryform" action="create_category" method="post"
						 id="categoryform">
				</c:if>
				<table>
					<tr>
						<td>
							<div class="form-group">
								<label for="categoryname">Name:</label> <input type="text"
									class="form-control-sm" id="categoryname" name="categoryname"
									placeholder="Enter category Name" value="${category.name}">
							</div>
						</td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-primary">Submit</button>
							<input type="button" class="btn btn-primary"
							onclick="javascript:history.go(-1);" value="Cancel" /></td>
					</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(function(){
		$("form[name='categoryform']").validate({
			rules: {
				categoryname: "required",
				},
			messages:{
				categoryname: "Please enter category name",
			},
			
			submitHandler: function(form){
				form.submit();
				}		
			});
			
			});
	</script>
	<jsp:directive.include file="admin_footer.jsp" />
	
	<script src="../js/jquery-ui.min.js"></script>
	<script src="../css/jquery-ui.min.css"></script>
	<script src="../js/jquery-3.4.0.min.js"></script>
	<script src="../js/jquery.validate.min.js"></script>


</body>
</html>