<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="../css/style.css" rel="stylesheet">
<script  type="text/javascript" src="../js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>	

<meta charset="ISO-8859-1">
<title>Edit Order-Online BookStore</title>
</head>
<body>

	<jsp:directive.include file="admin_header.jsp" />
	<div class="container" align="center">
	<form id="orderform" action="update_order" method="post">
		
			<div class="col-12 py-2">
				<h3>Edit Order ID: ${order.orderId} </h3>
				<h4>Order Overview</h4>				
			</div>
		<div class="col-8" style="margin-left:20%;">		
		<table class="table borderless" >
		<tr>
			<td><b>Ordered By:</b></td>
			<td>${order.customer.fullname}</td>
		</tr>
		<tr>
			<td><b>Order Date:</b></td>
			<td>${order.orderDate}</td>
		</tr>
		<tr>
			<td><b>Recipient Name:</b></td>
			<td><input type="text" value="${order.recipientName}" class="form-control" name="recipientName"/></td>
		</tr>
		<tr>
			<td><b>Recipient Phone no:</b></td>
			<td><input type="text" value="${order.recipientPhone}" class="form-control" name="recipientPhone"/></td>
		</tr>
		<tr>
			<td><b>Ship To:</b></td>
			<td><input type="text" value="${order.shippingAddress}" class="form-control" name="shippingAddress"/></td>
		</tr>
		<tr>
			<td><b>Payment Method:</b></td>
			<td><select name="paymentMethod" class="form-control">
				<option value="Cash On Delivery" selected> Cash On Delivery </option>
				</select>
			</td>
		</tr>
		<tr>
			<td><b>Order Status:</b></td>
			<td><select name="orderStatus" class="form-control">
						<option value="Processing" <c:if test="${order.status eq 'Processing' }">selected='selected'</c:if> >Processing</option>
						<option value="Shipping" <c:if test="${order.status eq 'Shipping' }">selected='selected'</c:if>>Shipping</option>
						<option value="Delivered" <c:if test="${order.status eq 'Delivered' }">selected='selected'</c:if>>Delivered</option>
						<option value="Completed" <c:if test="${order.status eq 'Completed' }">selected='selected'</c:if>>Completed</option>
						<option value="Cancelled" <c:if test="${order.status eq 'Cancelled' }">selected='selected'</c:if>>Cancelled</option>
					</select>
			</td>
		</tr>
		</table>
		
		</div>
			
		<div class="col-10 py-2" style="margin-left:10%;">
		<h4>Ordered Books</h4>
		<table class="table">
		<tr>
			<th>Index</th> <th>Book </th> <th>Title</th>  <th>Author</th>
			<th>Price</th><th>Quantity</th><th>SubTotal</th> <th> </th>
		</tr>
		<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
			<tr>
							<td>${status.index +1}</td>
							<td><img src="data:image/jpg;base64,${orderDetail.book.base64Image}"
								width="64" height="78" /></td>
							<td>${orderDetail.book.title}</td>
							<td>${orderDetail.book.author}</td>
							<td>
								<input type="hidden" name="price" value="${orderDetail.book.price}" />
								<fmt:formatNumber value="${orderDetail.book.price}"	type="currency" />
							</td>
							<td>
								<input type="hidden" name="bookId" value="${orderDetail.book.bookId}" />
								<input type="text" name="quantity${status.index + 1}" value="${orderDetail.quantity}" size="4" />
							</td>
							<td>
								<fmt:formatNumber value="${orderDetail.subtotal}" type="currency" />
							</td>
							<td><a href="remove_book_from_order?id=${orderDetail.book.bookId}">Remove</a>
			</tr>
		</c:forEach>
		<tr>
		<td colspan="4" align="right">TOTAL:</td>
		<td> ${order.getBookCopies()}</td>
		<td> <fmt:formatNumber value="${order.total}" type="currency" /></td>
		
		</tr>
		</table>
		<a href="javascript:showAddBookPopup()"><b>Add Books</b></a>&nbsp; &nbsp; &nbsp; &nbsp;
		<button type="submit" class="btn btn-primary">Save</button> &nbsp; &nbsp; &nbsp; &nbsp;
		<input type="button" value="Cancel" class=" btn btn-primary" id="buttonCancel"/>
		
		</div>		
		</form>
	</div>
	<jsp:directive.include file="admin_footer.jsp" />
	<script type="text/javascript">
	function showAddBookPopup(){
		var width =800;
		var height=300;
		var left = (screen.width-width)/2;
		var top = (screen.height-height)/2;
		
	window.open('add_book_form','blank','width='+width+',height='+height+',top='+top+',left='+left);

	}
	
	$(document).ready(function() {
		$("#orderform").validate({
			rules: {	
				recipientName: "required",
				recipientPhone: "required",
				shippingAddress: "required",				
				<c:forEach items="${order.orderDetails}" var="book" varStatus="status">
					quantity${status.index + 1}: {
						required: true, number: true, min: 1
					},
				</c:forEach>					
			},			
			messages: {
				recipientName: "Please enter recipient name",
				recipientPhone: "Please enter recipient phone",
				shippingAddress: "Please enter shipping address",
				
				<c:forEach items="${order.orderDetails}" var="book" varStatus="status">
					quantity${status.index + 1}: { 
						required: "Please enter quantity",
						number: "Quantity must be a number",
						min: "Quantity must be greater than 0"
					},
				</c:forEach>						
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
		$("#buttonCancel").click(function(){
			//window.location.href="${pageContext.request.contextPath}/admin/order_list.jsp";
			history.go(-1);
			});
		
	});		
	</script>
</body>
</html>
