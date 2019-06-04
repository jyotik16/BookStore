<%@page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto Slab" rel="stylesheet">
<title>Add Book to Order</title>
</head>
<body>
	<div align="center">
		<h4>
			The book <i>${book.title}</i> has been added to the order ID <b>${order.orderId}</b>
		</h4>
		<input type="button" value="Close" class="btn btn-primary" onclick="javascript: self.close();" />
	</div>
	<script>
		window.onunload = function() {
			window.opener.location.reload();
		}
	</script>
</body>
</html>