<?php 
include('function.php');
session_start();
?>
<!--product details display-->
<?php
if(isset($_GET['pro_id'])){
	
	 $pro_id = $_GET['pro_id'];
	 
	 $get_product = "select * from product where Product_id='$pro_id'";
	 
	 $run_product = mysqli_query($conn,$get_product);
	 
	 $row_product = mysqli_fetch_array($run_product);
	 
	 $pro_cat_id = $row_product['Product_Category'];
	 
	 $title = $row_product['Title'];
	 
	 $price = $row_product['Price'];
	 
	 $pro_img = $row_product['Product_image'];
	 
	 $get_p_cat = "select * from product_category where Product_category_id='$pro_cat_id'";
	 
	 $run_p_cat = mysqli_query($conn,$get_p_cat);
	 
	 $row_p_cat = mysqli_fetch_array($run_p_cat);
	 
	 $pro_cat_name = $row_p_cat['Product_Category_name']	;
	  
	}

?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="navi.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
</head>

<body>
	
	<div class="bg">
	<ul class="nav justify-content-center">
	<li class="nav"><img class="logo" src="images/logo.webp" width="90" height="80" alt=""><h1><b>Creative Jewellers</b></h1></li>
		</div>
		
	<div class="bg-light">

<ul class="nav justify-content-center">
  <li class="nav-item">
	  <a href="home.php" class="btn btn-light" ><i class="fa fa-home" aria-hidden="true"></i> Home</a>
  </li>
	<li class="nav-item">
			<a class="btn btn-light" href="About.php"><i class="fa fa-history" aria-hidden="true"></i> About</a>
	</li>
  <li class="nav-item">
    <a class="btn btn-light" href="Contact us.php"><i class="fa fa-phone" aria-hidden="true"></i> Contact Us</a>
  </li>
	<li class="nav-item">
		<?php
		if(!isset($_SESSION['Email'])){
          echo "<a class='btn btn-light' href='login.php'><i class='fa fa-key' aria-hidden='true'></i> Login</a>";
		}else{
			echo "<a class='btn btn-light' href='logout.php'><i class='fa fa-sign-out' aria-hidden='true'></i> Logout</a> ";
		}
		?>
       <li class="nav-item">
	    <?php
		if(isset($_SESSION['Email'])){
			echo "<a class='btn btn-light' href='cart.php'><i class='fa fa-shopping-cart'></i> Cart</a>";
		}
		?>
</ul>
	</div>
		<nav class="navbar navbar-expand-lg navbar-light bg-secondary">
    <ul class="navbar-nav mr-auto">
    <a href="" class="btn navbar-btn btn-light"><i class="fa fa-user-o" aria-hidden="true"></i>
     <?php
	 
	  if(!isset($_SESSION['Email'])){
		  
		  echo "Welcome: Guest";
		  
		  }else{
			  
			  echo "Welcome: " . $_SESSION['Email'] . "";
			  
			  }
		?>
		</a>
    
    </ul>
			<a href="shoppingCart.php" class="btn navbar-btn btn-light">
                      <i class="fa fa-shopping-cart"></i>
                      <span class="badge badge-light"><?php items(); ?>  Number of items In your Cart </span></a>
	
</nav>

</body>
</html>