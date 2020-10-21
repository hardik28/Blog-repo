<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page isErrorPage="true"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error....</title>

<!--css-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<link href="/css/mystyle.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	
	<div class="container text-center">
			<img src="images/fail.png" class="img-fluid">	
			<h3 class="display-4">Oopsie...</h3>
			<%= exception %>
			<a href="index.jsp"  text-white mt-3>Home</a>
	</div>


</body>
</html>