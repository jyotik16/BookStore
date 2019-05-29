<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link rel="stylesheet" 	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS File -->
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<meta charset="ISO-8859-1">
<title>Shopping Cart-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">
		<h4>Your Cart Details</h4	>				
		<c:set var="cart" value="${sessionScope['cart']}" />
		
		<c:if test="${cart.getTotalItems()==0}">
			<h4>There's no items in your cart</h4>
		</c:if>	
		<c:if test="${cart.getTotalItems()>0}">
	
		<form action="update_cart" method="post" id="cartform" name="cartform">
		<div align="center">
		<table class="table" >
		<tr>
			<th>No</th> <th colspan="2">Book</th> <th>Quantity</th> <th>Price</th> <th>Subtotal</th> 
			<th> <a href=""><b> &nbsp; &nbsp;</b></a></th>
		</tr>
		<tr>
		<c:forEach items="${cart.items}" var="item" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td><img src="data:image/jpg;base64,${item.key.base64Image }"  class="book-cart" /> </td>
			<td> <span class="book-title">${item.key.title} </span> </td>
			
			<td>
			<input type="hidden" name="bookId" value="${item.key.bookId}" />
			<input type="text" name="quantity${status.index + 1}" value="${item.value}" size="4"/>
			</td>
			<td><fmt:formatNumber value="${item.key.price}" type="currency" /></td>			
			<td><fmt:formatNumber value="${item.value * item.key.price}" type="currency" /></td>
			<td><a href="remove_from_cart?bookId=${item.key.bookId}">Remove</a>
		</tr>
		</c:forEach>
		</tr>
		<tr>
		<td></td> <td></td> <td></td>
		<td><b>${cart.getTotalQuantity()} Book(s)</b></td>
		<td><b>Total:</b></td>
		<td colspan="2"><b><fmt:formatNumber value="${cart.getAmount()}" type="currency" /></b></td>
		</tr>
		</table>
		</div>
		<div>
		<table class="table borderless" id="cart">
		<tr>
			<td></td>
			<td colspan="2">
			<span><button type="submit" class="btn btn-primary">Update</button></span>
			<span><input type="button" id="Clearcartbutton" class="btn btn-primary" value="ClearCart"></span>
			<span><a href="${pageContext.request.contextPath}">Continue Shopping</a></span>
			<span><a href="">CheckOut</a></td></span>
				
		</tr>
		</table>
		</div>
		</form>
		
		</c:if>		
	</div>	
	<script type="text/javascript">
		$(function() {
			
			$("#Clearcartbutton").click(function(){
				window.location ='clear_cart';
			});
			$("form[name='cartform']").validate({
				rules : {
					<c:forEach items="${cart.items}" var="item" varStatus="status">
					quantity${status.index + 1}: {
						required: true,
						number: true,
						min: 1
						},					
					</c:forEach>
				},
				messages : {
					<c:forEach items="${cart.items}" var="item" varStatus="status">
					quantity${status.index + 1}: {
						required: "Please enter quantity",
						number: "Quantity mest be number",
						min: "Quantity meat be greater than 0"
							},				
					</c:forEach>
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
			
		});
	</script>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>