<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
    <head>
     <title>Login</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,700,700i|Poppins:300,400,500,700"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="../css/style.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">

        <!-- Libraries CSS Files -->
        <link href="../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <link href="../lib/animate/animate.min.css" rel="stylesheet">

        <link href="../lib/main.css" rel="stylesheet">

    </head>
    <jsp:directive.include file="header.jsp"/>
   <div class="container" id="inputform">
        <h2 class="design">Login Form</h2>
        <div class="row">
            <div class="col-lg-12">
                <form action="LoginServlet" class="inputform" method="post">
                    <div class="form-group row">
                        <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="inputPassword3" class="col-sm-2 col-form-label">Password &nbsp; &nbsp;</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="password" placeholder="password">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" name="submit" class="btn btn-primary">Submit</button>

                        </div>
                    </div>
                </form>

            </div>

        </div>

    </div>
<jsp:directive.include file="footer.jsp"/>