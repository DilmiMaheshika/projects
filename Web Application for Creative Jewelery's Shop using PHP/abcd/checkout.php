<?php 
include('include/db.php');

?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
</head>

<body>
	<?php

 if(!isset($_SESSION['Email'])){
	 
	 include("login.php");
	 
	 }else{
		 
		 include("payment.php");
		 
		 }

?>
</body>
</html>