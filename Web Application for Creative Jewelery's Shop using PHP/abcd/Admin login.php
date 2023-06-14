<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Admin login</title>

<!--<link href="adlog.css" type="text/css" rel="stylesheet"/>-->
<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<!--CSS-->	
<style>
	
.logo{
border-radius: 50%;
}
.bg{
	background: #877C1B;
}
h1{
	color: #000000;
	text-align: center;
	align-content: center;
	font-style: italic;
	font-family:allura;
	font-size: 2vw;
}
h3{
	color:#000;
	text-align:center;
	background: #1E9FC7;
}
body{
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}
.box{
	width: 900px;
	height:500px;
	padding: 70px;
	position: absolute;
	top: 55%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #6C6464;
	text-align: center;
	border-radius: 180px;
	
}
.box h2{
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}
.box input[type=email]::placeholder,input[type=password]::placeholder{
	color: #d6d6d6;
}
.box input[type=email],input[type=password]{
	background: none;
	display: block;
	margin: 30px auto;
	text-align: center;
	border: 2px solid #043F1F;;
	padding: 14px 40px;
	width: 400px;
	outline: none;
	color: white;
	border-radius: 2px;
	transition: 0.25s;
	
	

}
.box input[type=email]:focus,input[type=password]:focus{
	width: 500px;
	border-color: black;
	
}
.box input[type=submit]{
	background: none;
	display: block;
	margin: 40px auto;
	text-align: center;
	border: 10px solid #043F1F;
	padding: 14px 40px;
	outline: none;
	color: white;
	width: 200px;
	border-radius: 100px;
	transition: 0.25s;
	cursor: pointer;
}
.box input[type=submit]:hover{
	background: #0C7043;
}

	</style>
	
	
</head>
<div class="bg">
	<?php include('navigation.php'); ?>
		</div>
<body background="images/baground.jpg">
	
<form class="box" action="" method="post">
<h2>ADMINISTRATOR LOGIN</h2>	
<input type="email" name="email" placeholder="E-mail" required>
<input type="password" name="password" placeholder="Password" required>
<input type="submit" name="login" value="Login">
<p style="color: yellow; font-size: 15px">Don't you have an account?<a href="ad_reg.php">Register here</a></p>
</form>
	
	<?php
	include('include/db.php');
	
  if(isset($_POST['login'])){
	  $email = $_POST['email'];
	  $pass = $_POST['password'];
	  
	  $select_admin = "SELECT * FROM admin WHERE Ad_Email='$email' AND Password='$pass'";
	  $run_admin = mysqli_query($conn,$select_admin);
	  $check_admin =mysqli_num_rows($run_admin);
	  if($check_admin==0){
		  echo "<script>alert('Inavlid email or password credentials')";
		  exit();
	  }if($check_admin==1){
		  $_SESSION['Ad_Email']=$email;
		  echo "<script>alert('Successfully logged in!')</script>";
		  echo "<script>window.open('Insert_product.php','_self')</script>";
	  }
  }
?>


	
</html>