<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>

<!-- Bootstrap link -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	
<link rel="stylesheet" href="css/login.css">

<script>

	var i='${un}';
	if(i=="fail"){
		
		alert('Wrong Username or Password!');
	}

</script>
</head>
<body>

	<div class="container">
	  <div class="row">
	    <div class="col-lg-3 col-md-2"></div>
	    <div class="col-lg-6 col-md-8 login-box">
	      <div class="col-lg-12 login-key">
	        <i class="fa fa-user" aria-hidden="true"></i>
	      </div>
	      <div class="col-lg-12 login-title">
	        ADMIN LOGIN
	      </div>
	
	      <div class="col-lg-12 login-form">
	        <div class="col-lg-12 login-form">
	          <form action="./Login" method="post">
	          
	            <div class="form-group">
	              <label class="form-control-label">USERNAME</label>
	              <input type="text" class="form-control" id="username" name="username" required>
	            </div>
	            
	            <div class="form-group">
	              <label class="form-control-label">PASSWORD</label>
	              <input type="password" class="form-control" id="pwd"  name="pwd" required>
	            </div>
	
	            <div class="col-lg-12 loginbttm">
	              <div class="col-lg-6 login-btm login-text">
	                <!-- Error Message -->
	              </div>
	              
	              <br>
	              <div class="col-lg-12 login-btm login-button">
	                <button type="submit" class="btn btn-outline-primary">LOGIN</button>
	              </div>
	            </div>
	          </form>
	          
	        </div>
	      </div>
	      <div class="col-lg-3 col-md-2"></div>
	    </div>
  	</div>
  	</div>
	
</body>
</html>