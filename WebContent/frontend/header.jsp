<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="bg-dark text-light text-center">
	<div class="d-inline-flex flex-row justify-content-center text-light">
		<div class="p-2 ">
			<i class="fa fa-book" style="font-size: 40px;"></i>
		</div>
		<div class="p-2">
			<h1 align="center" class="heading"
				style="font-size: 40px; font-weight: 700;">EverGreen BookStore</h1>
		</div>
	</div>
</section>
<div class="container" align="center">
	<div class="row" align="center">
		<div class="col-12 col-sm-12 text-center py-1">
			<p class="text-secondary" id="pp">
				<i>Online Programming Bookstore</i>
			</p>
		</div>
	</div>
	<div class="row" align="center">
		<div class="col-lg-4 col-sm-8 col-xs-8  pr-0 mr-0 mar-left" >
			<form class="form-inline" action="search" method="get">
				 <label for="search"></label>
					<input type="text" class="form-control" name="keyword" placeholder="Keywords" />  &nbsp;
					<button type="submit" class="btn btn-primary ">Submit</button>
		
			</form>
		</div>
		<div class="col-lg-4 col-sm-8 col-xs-8 pl-0 ml-0 py-2" style="font-size: 20px;">
			<a href="#"> Sign in |</a> <a href="#"> Login |</a> <a href="#">
				Cart </a>
		</div>
		
		
	</div>
	<div class="row py-1">
		<div class="col-sm-12 col-xs-12 text-center">
			<c:forEach var="category" items="${listcategory}" varStatus="status">
				<a href="view_category?id=${category.categoryId}"> <font
					size="+1"><b><c:out value="${category.name}" /></b></font>
				</a>
				<c:if test="${not status.last}">
					&nbsp; |&nbsp;
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
