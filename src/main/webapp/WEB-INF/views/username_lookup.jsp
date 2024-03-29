<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
	     rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" 
	     crossorigin="anonymous">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" 
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" 
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="resources/css/kube-6.5.2.min.css">
    <link rel="stylesheet" href="resources/css/main.css">

<title>User Name Lookup</title>
</head>
<body>
<div class="container">
<div style="padding-top: 1em;"></div>
    <div class="row">
		<div class="col-md-12">
	 		<h2 align="center">User Name Lookup</h2>
		</div>
	</div> <!-- row -->
	<div style="padding-top: 1em;"></div>
	 <!-- Post to the login form -->
		<form action="/username_lookup_form" method="post">
		    <!-- User Name -->
			<c:if test="${email_error != null && email_error.length() > 0}">
				<div class="form-group row">
					<div class="col-sm-4"></div>
					<div class="col-sm-8">
						<span class="inputError">${email_error}</span>
					</div>
				</div>
			</c:if>
			<div class="form-group row">
				<label for="title" class="col-sm-4 col-form-label">Email address:</label>
				<div class="col-sm-8">
						<input type="email" id="email_address" name="email_address" placeholder="Your Email Address">
				</div> <!-- col-md-8 -->
			</div> <!--  row -->

			<div class="form-group row">
				<label for="title" class="col-sm-4 col-form-label">Tenant</label>
				<div class="col-sm-8">
					<input type="email" id="tenant" name="tenant" placeholder="Domain">
				</div> <!-- col-md-8 -->
			</div> <!--  row -->

			<div class="form-group row">
				<div class="col-sm-4"></div>
				<div class="col-sm-8">
				    <span>
					    <button type="submit" class="btn btn-primary">Lookup User Name</button>
					</span>
					<span>
						<a href="<c:url value="/" />" id="cancel" name="cancel" class="btn btn-primary">Cancel</a>
					</span>
				</div>
			</div>
	   </form>
</div> <!-- container -->
</body>
</html>
