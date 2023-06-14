<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Creative Jewellers</title>
<!--<link href="home.css" rel="stylesheet"/>-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
	<style>
	
	
#maindiv2 #content
{
	padding-left:25px;
}
.single
{
	width:290px;
}
@media(max-width:768px)
{
	.single
	{
		width:60%;
		margin: 0 auto;
	}
}
#maindiv2 #content .product
{
	background:#ffffff;
	border: solid 1px #e6e6e6;
	margin-bottom:30px;
	box-sizing:border-box;
	
}
#maindiv2 #content .product .text p.price
{
	font-size:18px;
	text-align:center;
	font-weight:400;
}
#maindiv2 #content .product .text
{
	padding: 10px 10px 0px;
}
#maindiv2 #content .product .text .button
{
	text-align:center;
	clear:both;
}
#maindiv2 #content .product .text .button .btn
{
	margin-bottom:10px;
}
#maindiv2 #content .product .text h3
{
	text-align:center;
	font-size:20px;
}
#maindiv2 #content .product .text h3 a
{
	color: rgb(233 192 8);
}
	
	</style>
	
	
</head>
	<?php include('navigation.php'); ?>


<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="images/3.jpg" alt="First slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="images/2.jpg" alt="Second slide">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="images/1.jpg" alt="Third slide">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
	
  
<body>
	
	<div class='container'>
	<h1 align='center' style="color: #ffad00;font-size: 3.0rem;margin: .7rem;font-family: system-ui;"> Our Trending Collections </h1>
  </div><br/>


	<ul class="nav justify-content-center" >
  
  <?php
  
    get_pro_cats();
	getcategory();
	
  ?>

</ul>
	<br/>
<br/>

<div id="maindiv2">
  <div id="content" class="container">
        <div class="row text-center text-lg-left ">
           <?php
		      
			  if(!isset($_GET['product_cat'])){
	 
	          if(!isset($_GET['cat'])){
				  
				  $per_page=10;
				  
				  if(isset($_GET['page'])){
					  
					  $page = $_GET['page'];
					  
				  }else{
						  
						 $page=1;
						  
						  }
						  
						  $start_from = ($page=1) * $per_page;
 
                          $get_products = "select * from product LIMIT $start_from,$per_page";
						  
						  $run_products = mysqli_query($conn,$get_products);
						  
						  while($row_products=mysqli_fetch_array($run_products)){
						      $pro_id = $row_products['Product_id'];
						   
						   $title = $row_products['Title'];
						   
						   $price = $row_products['Price'];
					   
						   $pro_img = $row_products['Product_image'];
						   
						   echo "
			   
			   <div class='col-md-4 col-sm-6 col-lg-4 single'>
			     <div class='product'>
				    <img class='img-responsive img-fluid' src='images/product/$pro_img' style='padding: 0 23px;'>
				     
					 <div class='text'>
					    <h3> 
						   <a href='product_details.php?pro_id=$pro_id'> $title </a>
						</h3>
						
						<p class='price'>
				            Rs.$price/-
						</p>
						
						<p class='button'>
						   <a class='btn btn-outline-warning' href='product_details.php?pro_id=$pro_id'>
						   View Details
					   
					 </a>
					<a class='btn btn-outline-danger' href='product_details.php?pro_id=$pro_id'>
						 <i class='fa fa-shopping-cart'></i>  Add To Cart
					   
					 </a> 
						</p>
						
					 </div>
				 </div>
			   </div>
			   
			   
			       "; 
							  
							  }

					  
					  }
				  
			    }
			  
			
			  
		   ?>
        </div>
     </div>     
</div>

<div id="maindiv2">
  <div id="content" class="container">
        <div class="row text-center text-lg-left ">
<?php
 
	get_pro_cat_pro();
	getcatpro();
	
  ?>
 </div>
 </div>
 </div>
 <?php include('footer.php'); ?>
</body>
</html>