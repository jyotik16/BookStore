<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- 
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"> 
-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/style.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>

<meta charset="ISO-8859-1">
<title>Checkout-Online Book shop</title>
</head>
<body>

	<jsp:directive.include file="header.jsp" />
	<div class="container" align="center">					
		<c:set var="cart" value="${sessionScope['cart']}" />
		
		<c:if test="${cart.getTotalItems()==0}">
			<h4>There's no items in your cart</h4>
		</c:if>	
		<c:if test="${cart.getTotalItems()>0}">
		
		<div align="center">
		<h4>Review Your Order Details &nbsp; &nbsp;<a href="view_cart">Edit</a></h4>
		<table class="table">
		<tr>
			<th>No</th> 
			<th colspan="2">Book</th>
			<th>Price</th> 
			<th>Author</th>  
			<th>Subtotal</th> 
			<th> <a href=""><b> &nbsp; &nbsp;</b></a></th>
		</tr>
		<c:forEach items="${cart.items}" var="item" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td><img src="data:image/jpg;base64,${item.key.base64Image }"  class="book-cart" /> </td>
			<td> <span class="book-title">${item.key.title} </span> </td>
			<td> <span>${item.key.author} </span> </td>
			<td><fmt:formatNumber value="${item.key.price}" type="currency" /></td>		
			
			<td>			
			<input type="text" name="quantity${status.index + 1}" value="${item.value}" size="4" readonly="readonly"/>
			</td>
				
			<td><fmt:formatNumber value="${item.value * item.key.price}" type="currency" /></td>
			
		</tr>
		</c:forEach>
		
		<tr>
			<td></td> <td></td> <td></td>
			<td><b>${cart.getTotalQuantity()} Book(s)</b></td>
			<td><b>Total:</b></td>
			<td colspan="2"><b><fmt:formatNumber value="${cart.getAmount()}" type="currency" /></b></td>
		</tr>
		</table>
		<div class="col-8" align="center">
		<h4>Your shipping Information</h4>
		
		<form name="orderform"  id="orderform" action="place_order" method="post">		
		<table class="table borderless">
		<tr>
			<td> <b>Recicpient Name:</b></td>
			<td> <input type="text" name="recipientName" class="form-control form-control-sm" value="${loggedCustomer.fullname}" ></td> 
		</tr>
		<tr>
			<td> <b>Recicpient Phone:</b></td>
			<td> <input type="text" name="recipientPhone"  class="form-control form-control-sm" value="${loggedCustomer.phone}" ></td> 
		</tr>
		<tr>
			<td> <b>Street Address:</b></td>
			<td> <input type="text" name="address" class="form-control form-control-sm" value="${loggedCustomer.address}" ></td> 
		</tr>
		<tr>
			<td> <b>City:</b></td>
			<td> <input type="text" name="city" class="form-control form-control-sm" value="${loggedCustomer.city}" ></td> 
		</tr>
		<tr>
			<td> <b>Zip Code:</b></td>
			<td> <input type="text" name="zipcode" class="form-control form-control-sm" value="${loggedCustomer.zipcode}" ></td> 
		</tr>
		<tr>
			<td> <b>Country:</b></td>
			<td> <input type="text" name="country" class="form-control form-control-sm" value="${loggedCustomer.country}" ></td> 
		</tr>
		</table>
		
		<h4>Payment</h4> Choose Your payment method:
		&nbsp; &nbsp;
			<select name="paymentMethod" class="form-control form-control-sm colorful-select dropdown-primary">
				<option value="Cash On Delivery" selected> Cash On Delivery </option>
				<option value="Cash On Delivery">  PayTM</option>
			</select>
		
		
		</div>
		</div>
		<div class="col-8">
		<table class="table borderless" id="cart">
		<tr>
			<td></td>
			<td colspan="2">
			<button type="submit" class="btn btn-primary" id="PlaceOrderButton">Place Order</button> &nbsp; &nbsp; &nbsp; &nbsp;		
			<a href="${pageContext.request.contextPath}">Continue Shopping</a>
			</td>				
		</tr>
		</table>
		</form>
		</div>
		</c:if>		
	</div>	
	<script type="text/javascript">
		$(document).ready(function() {			
			$("#orderform").validate({
				rules : {
					recipientName :'required',
					recipientPhone :'required',
					Address :'required',
					city :'required',
					zipCode :'required',
					country :'required',
				},
				messages : {
					recipientName :'Please enter recipient Name',
					recipientPhone :'Please enter recipient Phoneno',
					Address :'Please enter street Address',
					city :'Please enter city',
					zipCode :'Please enter zipcode',
					country :'Please enter country'
				},
				submitHandler : function(form) {
					form.submit();
				}
			});
			/* $("#PlaceOrderButton").click(function(){
				window.location ='place_order';
			}); */
			
		});
	</script>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>