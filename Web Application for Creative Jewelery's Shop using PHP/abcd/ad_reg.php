<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<!--CSS-->
<link href="areg.css" type="text/css" rel="stylesheet"/>
<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>
<?php include('navigation.php'); ?>
<?php include('include/db.php') ?>
	
<?php
	if(isset($_POST['submit'])){
		
		$email = $_POST['email'];
		$pass = $_POST['password'];
		
		$insert_data = "INSERT INTO admin ( Ad_Email, Password) VALUES ('$email','$pass')";
		
		$run_data = mysqli_query($conn,$insert_data);
		$select_admin = "select * from admin where Ad_Email='$email'";
	
	    $run_admin = mysqli_query($conn,$select_admin);
	
	    $check_admin = mysqli_num_rows($run_admin);

	     if($check_admin>0){
				
		$_SESSION['Ad_Email']=$email;
		
		echo "<script> alert('You Have Been Successfully Registered!')</script>";
		echo "<script>window.open('Admin login.php','_self')</script>";
	
	}else{
			 echo "<script> alert('Email id you have entered is already taken!')</script>";
			 
		 }
}
	?>
<body background="images/pay.jpg">
	
	<form class="box" action="" method="post" >
<h2>Register</h2>	
<div class="form-row">
<!--email-->
<input type="email" name="email" placeholder="E-mail" required>
<!--password-->
<input type="password" name="password" placeholder="Password" required>
<!--confirm password-->
<input type="password" name="conpass" placeholder="Confirm password" required>
	</div>
<input type="submit" name="submit" value="Register">
<p><small>Already have an account?<a href="Admin login.php">Login</a></small></p>
</form>
</body>
</html>