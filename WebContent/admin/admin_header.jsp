<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="bg-dark text-light text-center">
<div class="d-inline-flex flex-row justify-content-center text-light">
	<div class="p-2">
		<a href="${pageContext.request.contextPath}/admin/"><i class="fa fa-book" id="book-logo" ></i></a>
	</div>
	<div class="p-2">
		<a href="${pageContext.request.contextPath}/admin/"><h1 class="heading" id="evergreen">EverGreen BookStore</h1></a>
	</div>
</div>
</section>
<div class="container" align="center">
	<div class="row">
		<div class="col-12  text-center">
				<p class="text-secondary"><i>Online Programming Bookstore</i></p>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			Welcome, <c:out value="${sessionScope.useremail}"></c:out> |<a href="admin_logout">Logout</a>
		</div>
	</div>

	<div class="row py-2">
		<div class="col-md-2 col-sm-4 col-6  px-0">
			<a href="list_user"><i class="fa fa-user"
				style="font-size: 30px;"></i><br>Users</a> &nbsp; 
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_category"> <i class="fa fa-align-center"
				style="font-size: 30px;"></i> <br>Categories
			</a> &nbsp; 
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_books"><i class="fa fa-book" style="font-size: 30px;"></i><br>Books</a>
			&nbsp; 
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_customer"> <i class="fa fa-user" style="font-size: 30px;"></i><br>Customers
			</a> &nbsp; 
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href=""> <i class="fa fa-first-order" style="font-size: 30px;"></i><br>Orders
			</a> &nbsp; 
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_review"> <i class="fa fa-comments" style="font-size: 30px;"></i><br>Reviews
			</a>
		</div>
	</div>
</div>
