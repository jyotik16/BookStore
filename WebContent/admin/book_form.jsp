<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 -->
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/jquery-ui.min.css" rel="stylesheet"></link>
<link href="../css/style.css" rel="stylesheet">
<script src="../js/jquery-1.12.4.js"></script>
<script src="../js/jquery-3.4.0.min.js"></script>
<script src="../js/jquery.validate.min.js"></script>
<script src="../js/jquery-ui.min.js"></script>

<meta charset="ISO-8859-1">

<c:choose>
		<c:when test="${book!=null}">
			<title>Create New Book</title>
		</c:when>
		<c:otherwise>
			<title>Edit Book</title>
		</c:otherwise>
</c:choose>
</head>
<body>
	<jsp:directive.include file="admin_header.jsp" />

	<c:choose>
		<c:when test="${book!=null}">
			<h3 align="center">Edit Book</h3>
		</c:when>
		<c:otherwise>
			<h3 align="center" class="tt">Create New Book</h3>
		</c:otherwise>
	</c:choose>

	<hr width="60%;" />
	<div class="container" align="center" style="margin-left: 15%">
		<div class="row">
			<div class="col-md-10 mb-md-0 mb-5">
				<c:if test="${book != null}">
					<form name="bookform" id="bookform" action="update_book" method="post" enctype="multipart/form-data" >
						<input type="hidden" name="bookId" value="${book.bookId}">
				</c:if>
				<c:if test="${book == null}">
					<form name="bookform" id="bookform" action="create_book" method="post" enctype="multipart/form-data">
				</c:if>

				<!--Grid row 1-->
				<div class="row">
					<!--Grid column-->
					<div class="col-md-12">
						<div class="md-form py-2">
							<label for="category">Category </label> 
							<select class="form-control" name="category" id="category">
							<c:forEach items="${listcategory}" var="category" >
									<c:if test="${category.categoryId eq book.category.categoryId }">
										<option value="${category.categoryId}" selected>${category.name}</option>
									</c:if>
									<c:if test="${category.categoryId ne book.category.categoryId }">
										<option value="${category.categoryId}">${category.name}</option>
									</c:if>

								</c:forEach>
							</select>
						</div>
					</div>

				</div>
				<div class="row">
					<!-- 2 -->
					<div class="col-md-6">
						<div class="md-form py-2">
							<input type="text" class="form-control" id="title" name="title"  placeholder="Enter Title" value="${book.title}">

						</div>
					</div>
					<!--Grid column-->
					<div class="col-md-6">
						<div class="md-form py-2">
							<input type="text" class="form-control" id="author" name="author" placeholder="Enter Author" value="${book.author }">

						</div>
					</div>
					<!--Grid column-->

				</div>

				<div class="row">
					<!-- 3 -->
					<!--Grid column-->
					<div class="col-md-6">
						<div class="md-form py-2">
							<input type="text" class="form-control " id="isbn" name="isbn" 	placeholder="Enter ISBN" value="${book.isbn}">

						</div>
					</div>
					<!--Grid column-->

					<div class="col-md-6">
						<div class="md-form py-2">
							<input type="text" class="form-control" id="price" name="price" placeholder="Enter price" value="${book.price}">

						</div>
					</div>
					<!--Grid column-->
				</div>


				<div class="row">
					<!-- 4 -->
					<!--Grid column-->
					<div class="col-md-12">
						<div class="md-form py-2">
							<input type="text" class="form-control" id="publishdate" name="publishdate" placeholder="Enter PublishDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value='${book.publishDate}'/>"/>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="md-form py-2">
							<i class="fa fa-pencil prefix fa-2x"></i> 
							<label for="description">Description </label>
							<textarea id="description" name="description" class="md-textarea form-control" rows="3" cols="30">${book.description}</textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<!--Grid column-->
					<div class="col-md-6">
						<div class="md-form py-2">
							<div class="custom-file">
								<input type="file" class="custom-file-input" id="bookImage"
									name="bookImage"> <label class="custom-file-label"
									for="bookImage">Choose file</label>
									
								
							</div>
						</div>
					</div>
					<div class="col-md-6">
					<img id="thumbnail" alt="Image preview" style="width:30%;border:2px groove dimgray;" src="data:image/jpg;base64,${book.base64Image}"/>
					</div>
					<!--Grid column-->
				</div>
				
				<div class="row">
					<div class="col-md-12 py-2">
						<button type="submit" class="btn btn-primary">Submit</button>
						<input type="button" class="btn btn-primary"
							onclick="javascript:history.go(-1);" value="Cancel" />
					</div>
				</div>

				</form>

			</div>
		</div>
		
	</div>
	<script type="text/javascript">
		$(function() {
			$("#publishdate").datepicker();
			$("#bookImage").change(function(){
				showImageThumbnail(this);
				});
			$("form[name='bookform']").validate(
							{
								rules : {
									category: "required",
									title : "required",
									author : "required",
									isbn : "required",
									price : "required",
									publishdate: "required",
									<c:if test="${book==null}">
										bookImage : "required",
									</c:if>		
									description : "required",							
										
								},
								messages : {
										category: "Please select category for book",
										title : "Please enter title of the book",
										author : "Please enter author name of the book",
										isbn : "Please enter isbn of the book",
										price : "Please enter price of the book",
										publishdate: "Please enter publishdate of the book",
										bookImage : "Please choose an Image for the book",
										description : "Please enter description of the book"
								},

								submitHandler : function(form) {
									form.submit();
								}
							});

		});

		function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		var reader = new FileReader();

		reader.onload = function(e){
			$('#thumbnail').attr('src',e.target.result);
			};
			reader.readAsDataURL(file);
			
		} 
	</script>
	<jsp:directive.include file="admin_footer.jsp" />
<!-- 
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script> -->
</body>
</html>