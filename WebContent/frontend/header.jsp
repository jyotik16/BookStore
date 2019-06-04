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
		<div class="col-lg-6 col-xs-8  ">
			<c:if test="${loggedCustomer == null}" >
			<a href="login"> Sign in |</a> <a href="register"> Register |</a>
			</c:if>
			<c:if test="${loggedCustomer != null}" >
			<a href="${pageContext.request.contextPath}/"><b>Home</b></a> &nbsp; &nbsp; 
						<a href="view_profile"> Welcome, ${loggedCustomer.fullname} |</a> 
			<a href="view_orders"> My Orders|</a>
			<a href="logout"> Logout|</a>
			</c:if>
			 <a href="view_cart">Cart </a>
		</div>
		</div>
	</div>		
	</div>
	<div class="row py-2">
		<div class="col-12 text-center">
			<c:forEach var="category" items="${listCategory}" varStatus="status">
				<a href="view_category?id=${category.categoryId}"> 
				<font size="+1">
				<b>	<c:out value="${category.name}"/></b>
				</font>
				</a>
				<c:if test="${not status.last}">
					&nbsp; |&nbsp;
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>
