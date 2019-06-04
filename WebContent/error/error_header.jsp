<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="bg-dark text-light text-center">
	<div class="d-inline-flex flex-row justify-content-center text-light">
		<div class="p-2 ">
			<a href="${pageContext.request.contextPath}/admin/"><i class="fa fa-book" id="book-logo" ></i></a>
		</div>
		<div class="p-2">
			<a href="${pageContext.request.contextPath}/" class="evergreen">EverGreen BookStore</a>
		</div>
	</div>
</section>
<div class="container" align="center">
	<div class="row">
		<div class="col-12 col-xs-12 text-center">
			<p class="text-secondary"><i>Online Programming Bookstore</i>
			</p>
		</div>
	</div>
	<div class="row" align="center">
	<div class="col-12">	
	<div class="row" >	
		<div class="col-lg-4 col-xs-4 mar-left" >
			<form class="form-inline" action="search" method="get">
				 <label for="search"></label>
					<input type="text" class="form-control" name="keyword" placeholder="Keywords" />  &nbsp;
					<button type="submit" class="btn btn-primary ">Search</button>
		
			</form>
		</div>
		
		</div>
	</div>		
	</div>
	
	</div>

