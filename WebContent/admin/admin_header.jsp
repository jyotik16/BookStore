<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="bg-dark text-light text-center">
<div class="d-inline-flex flex-row justify-content-center text-light">
	<div class="p-2 ">
		<i class="fa fa-book" style="font-size: 40px;"></i>
	</div>
	<div class="p-2 ">
		<h1 align="center" class="heading"
			style="font-size: 40px; font-weight: 700;">EverGreen BookStore</h1>
	</div>
</div>
</section>
<div class="container" align="center">
	<div class="row" align="center" >
		<div class="col text-center">
				<p class="text-secondary" id="pp"><i>Online Programming Bookstore</i></p>
		</div>
	</div>
	<div class="row" align="center">
		<div class="col py-1">
			Welcome, <c:out value="${sessionScope.useremail}"></c:out> |<a href="admin_logout">Logout</a>
		</div>
	</div>

	<div class="row">
		<div class="col-md-2 col-sm-4 col-6  px-0">
			<a href="list_user"><i class="fa fa-user"
				style="font-size: 30px;"></i><br>Users</a> &nbsp; |
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_category"> <i class="fa fa-align-center"
				style="font-size: 30px;"></i> <br>Categories
			</a> &nbsp; |
		</div>
		<div class="col-md-2 col-sm-4 col-6 px-0">
			<a href="list_books"><i class="fa fa-book" style="font-size: 30px;"></i><br>Books</a>
			&nbsp; |
		</div>
		<div class="col-md-2 col-sm-4 col-6">
			<a href=""> <i class="fa fa-comments" style="font-size: 30px;"></i><br>Reviews
			</a> &nbsp; |
		</div>
		<div class="col-md-2 col-sm-4 col-6">
			<a href=""> <i class="fa fa-first-order" style="font-size: 30px;"></i><br>Orders
			</a> &nbsp; |
		</div>
		<div class="col-md-2 col-sm-4 col-6">
			<a href=""> <i class="fa fa-users" style="font-size: 30px;"></i><br>Customer
			</a>
		</div>
	</div>
</div>
