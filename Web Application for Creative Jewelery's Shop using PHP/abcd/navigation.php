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
//search

$output = "";
if(isset($_POST['search'])){
	$search = $_POST['search'];
	
	$search_query = "SELECT * FROM product WHERE Product_Category = '$search'";
}
?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<!--<link href="navi.css" type="text/css" rel="stylesheet"/>-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
<style>

		.logo{
	border-radius: 40%;
}
.bg{
	background: #9A7C17;
}
h1{
	font-style: italic;
	color: black;
	font-family: bookman;
	font-size: 6;
}
	
</style>
</head>

<body>




<!-- Navigation -->
<nav class="navbar fixed-top navbar-expand-lg navbar-dark fixed-top" style="background-color: #e08422;">
    <div class="container">
        <a class="navbar-brand" href="#">
           <!-- <img src="images/logo2.png" width="30" height="30" class="d-inline-block align-top" alt="">-->
            CREATIVE JEWELERS
        </a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="home.php" class="nav-link" ><i class="fa fa-home" aria-hidden="true"></i> Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="About.php"><i class="fa fa-info-circle" aria-hidden="true"></i> About</a>
                </li>


                <li class="nav-item">
                    <a class="nav-link" href="Contact us.php"><i class="fa fa-phone" aria-hidden="true"></i> Contact Us</a>

                </li>
                <li class="nav-item">
                    <?php
                    if(!isset($_SESSION['Email'])){
                        echo "<a class='nav-link' href='login.php'><i class='fa fa-key' aria-hidden='true'></i> Login</a>";
                    }else{
                        echo "<a class='nav-link' href='logout.php'><i class='fa fa-sign-out' aria-hidden='true'></i> Logout</a> ";
                    }
                    ?>
                </li>
                <li class="nav-item">
                    <?php
                    if(!isset($_SESSION['Email'])){
                        echo "<a class='nav-link' href='cart.php'><i class='fa fa-shopping-cart' aria-hidden='true'></i> Cart</a>";
                    }
                    ?>
                </li>
               <!-- </li>-->
                <li class="nav-item">
                    <?php
                    if(!isset($_SESSION['Email'])){
                        echo "<a class='nav-link' href='Admin login.php'><i class='fa fa-user-md' aria-hidden='true'></i> Admin</a>";
                    }
                    ?>
                </li>

            </ul>
        </div>
    </div>
</nav>

</body>
</html>