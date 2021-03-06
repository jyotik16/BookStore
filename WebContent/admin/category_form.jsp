<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->

<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>

<meta charset="ISO-8859-1">
<c:choose>
		<c:when test="${category!=null}">
			<title>Edit Category</title>
		</c:when>
		<c:otherwise>
			<title>Create New Category</title>
		</c:otherwise>
	</c:choose>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />

	<c:choose>
		<c:when test="${category!=null}">
			<h3 class="pageheading">Edit Category</h3>
		</c:when>
		<c:otherwise>
			<h3 class="pageheading">Create New Category</h3>
		</c:otherwise>
	</c:choose>

	<hr width="60%;" />
	<div class="container" align="center">
				<div class="col-8">						
				<c:if test="${category != null}">
					<form name="categoryform" action="update_category" method="post" id="categoryform">
						<input type="hidden" name="categoryId" value="${category.categoryId}">
				</c:if>
				<c:if test="${category == null}">
					<form name="categoryform" action="create_category" method="post" id="categoryform">
				</c:if>
				<table>
					<tr><td><label for="categoryname">Name:</label></td>
						<td> <input type="text"	class="form-control" id="categoryname" name="categoryname"
									placeholder="Enter category Name" value="${category.name}">
									
						</td>				
					</tr>
					<tr>	<td> &nbsp; </td>
						<td><button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;
							<input type="button" class="btn btn-primary" onclick="javascript:history.go(-1);" value="Cancel" />
						</td>
					</tr>
				</table>
				</form>
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
</body>
</html>