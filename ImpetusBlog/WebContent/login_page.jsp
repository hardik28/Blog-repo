<%@page import="com.blog.entities.Message"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

	<!------css------->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
			<link href="/css/mystyle.css" rel="stylesheet" type="text/css"/>
        
            
</head>
<body 	style="background:pink!important">
<!-- NAvbar -->
	<%@ include file="normal_navbar1.jsp" %>


      <main class="d-flex align-items-center "  style="padding-bottom: 80px; background:#00796b!important">

            <div class="container">

                <div class="col-md-4 offset-md-4">

                    <div class="card">
                        <div class="card-header text-center " style="background:#b2dfdb!important">
                            <span class="fa fa-3x fa-user-circle"></span>
                            <br>
                            Login here
                        </div>
                       <%
                       		Message m=(Message)session.getAttribute("msg");
                       		if(m!=null)
                       		{
                       	%>
                       	 <div class="alert <%= m.getCssClass() %>" role="alert">
  							<%= m.getContent() %>
						</div>
						<% 
							session.removeAttribute("msg");
						      		}
						      		
						 %>	
                       		
                        <div class="card-body">
                                <form action="LoginServlet" method="post">
                                    <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                        <input name="email" required type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Password</label>
                                        <input name="password" required type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                    </div>

                                
                                <div class="container text-center">
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>
                            </form>

                        </div>


                    </div>




                </div>
            </div>

        </main>
        

        <!--javascripts-->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="   crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script type="text/javascript" src="/javascript/myjs.js"></script>


</body>
</html>