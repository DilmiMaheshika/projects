<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Registration</title>

<!--<link href="reg.css" type="text/css" rel="stylesheet"/>-->
<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<!--CSS-->	
<style>
	
.bg{
	background-color: black;
	min-height: 200;
}

h1{
	color: aliceblue;
	text-align: center;
	align-content: center;
	font-style: italic;
	font-family:allura;
	font-size: 2vw;
}
h3{
	color:#000;
	text-align:center;
}
body{
	margin: 0;
	padding: 0;
	font-family: sans-serif;
}
.box{
	width: 800px;
	padding: 40px;
	position:absolute;
	top: 70%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: #6C6464;
	text-align: center;
	border-radius: 10px;
	
}
.box h2{
	color: white;
	text-transform: uppercase;
	font-weight: 500;
}
.box input[type=email]::placeholder,input[type=password]::placeholder,input[type=text]::placeholder,input[type=date]::placeholder{
	color: #d6d6d6;
}
.box input[type=email],input[type=password],input[type=text],input[type=date]{
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #e3ae0d;
	padding: 14px 10px;
	width: 400px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	
}
.box input[type=email]:focus,input[type=password]:focus,input[type=text]:focus,input[type=date]:focus{
	width: 800px;
	border-color: #e3ae0d;
	
}
.box input[type=submit]{
	background: none;
	display: block;
	margin: 20px auto;
	text-align: center;
	border: 2px solid #e3ae0d;
	padding: 14px 40px;
	outline: none;
	color: white;
	border-radius: 24px;
	transition: 0.25s;
	cursor: pointer;
}
.box input[type=submit]:hover{
	background: #e3ae0d;
}	
	
</style>	
	
</head>
<?php 
include('navigation.php'); 	
?>
<?php
	if(isset($_POST['submit'])){
		$sname = $_POST['surname'];
		$fname = $_POST['firstname'];
		$address = $_POST['address'];
		$contact = $_POST['contact'];
		$nic = $_POST['nic'];
		$dob = $_POST['dob'];
		$city = $_POST['city'];
		$zip = $_POST['zip'];
		$coun = $_POST['country'];
		$email = $_POST['email'];
		$pass = $_POST['password'];
		$cus_ip = getRealIpUser();
		
		$insert_data = "INSERT INTO registration (Surname, First_name, Address, Contact_No, NIC_No, DOB, City, Zip_code, Country, Email, Password, Customer_ip) VALUES ('$sname','$fname','$address','$contact','$nic','$dob','$city','$zip','$coun','$email','$pass','$cus_ip')";
		
		$run_data = mysqli_query($conn,$insert_data);
		$sel_cart = "select * from cart where Ip_add='$cus_ip'";
	
	    $run_cart = mysqli_query($conn,$sel_cart);
	
	    $check_cart = mysqli_num_rows($run_cart);

	     if($check_cart>0){
		
		//register with have items in cart//
		
		$_SESSION['Email']=$email;
		
		echo "<script> alert('You Have Been Successfully Registered!')</script>";
		echo "<script>window.open('login.php','_self')</script>";
	
	}else{
			 echo "<script> alert('You Have Been Successfully Registered!')</script>";
			 echo "<script>window.open('login.php','_self')</script>";
		 }
}
	?>
<body background="images/1567838.jpg">
	
<form class="box" action="" method="post" >
<h2>Register</h2>
	
<div class="form-row">
<!--surname-->
<input type="text" name="surname" placeholder="Surname" required> 
</div>
	
<div class="form-row">
<!--firstname-->
<input type="text" name="firstname" placeholder="First name" required>
</div>
	
<div class="form-row">
<!--address-->
<input type="text" name="address" placeholder="Address" required>
</div>	

<div class="form-row">
<!--contact no-->
<input type="text" name="contact" placeholder="Contact No" required>
</div>
	
<div class="form-row">
<!--nic no-->
<input type="text" name="nic" placeholder="NIC No" required>
</div>

<div class="form-row">
<!--dob-->
<input type="text" name="dob" placeholder="DOB" required>
</div>
	
<div class="form-row">
<!--city-->
<input type="text" name="city" placeholder="City" required>
</div>	

<div class="form-row">	
<!--zip-->
<input type="text" name="zip" placeholder="Zip code" required>
</div>

<div class="form-row">
<!--country-->
<input type="text" name="country" placeholder="Country" required>
</div>
	
<div class="form-row">
<!--email-->
<input type="email" name="email" placeholder="E-mail" required>
</div>	

<div class="form-row">	
<!--password-->
<input type="password" name="password" placeholder="Password" required>
</div>

<div class="form-row">	
<!--confirm password-->
<input type="password" name="conpass" placeholder="Confirm password" required>
</div>
	
<input type="submit" name="submit" value="Register">
<p><small>Already have an account?<a href="login.php">Login</a></small></p>
</form>
	<br>
<br>

</body>
	

</html>