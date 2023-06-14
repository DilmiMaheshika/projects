<?php

 $active='cart';

 $pro_cat_name="";
 $title="";
$price ="";

?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Product details</title>

<!--<link href="pro_det.css" type="text/css" rel="stylesheet"/>-->
<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

	<!--CSS-->
	<style>
	
	.navbar h1{
	font-family: Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", "serif";
	text-align: center;
	font-size: 7vw;
}
#content .product{
	margin: 0 0 30px;
	/*border: solid 1px #0E0E0D;*/
	box-sizing: border-box;
	padding: 20px;
	/*box-shadow: 0px 2px 5px rgba(0, 0, 0, .3);*/
	/*background: #ECEAEA;*/
}
.breadcrumb{
	padding: 0 0 30px;
	margin-bottom: 20px;
	background: #FFE6E7;
	border-radius: 5px;
	box-shadow: 0px 1px 5px rgba(0, 0, 0, .5);
}
.breadcrumb> li + li:before{
	content: ">\00a0";
	color: #cccccc;
}
@media(max-width:991px){
	.breadcrumb{
		padding: 8px 0px;
		text-align: center;
	}
}
	
	</style>
	
	
	</head>
<?php include('navigation.php'); ?>
<body>
	
<div id="content">
      <div class="col-md-12">
         <ul class="breadcrumb" style="font-size:16px">
           <li>
              <a href="home.php"> Our Collections </a>
           </li>
           <li>
           <a href="home.php?p_cat=<?php echo $pro_cat_id; ?>"><?php echo $pro_cat_name; ?></a>
           </li>
           
           <li>
           <?php echo $title; ?>
           </li>
           
         </ul>
      </div>
   </div>
<br/>
<!--pro 1-->
<div id="content">
     <div class="container">
         <div class="row text-center text-lg-left ">
             <hr style="width: 100%">
             <div class="col-md-12 text-center">
                 <h1 style="color: #ffad00;font-size: 3.0rem;margin: .7rem;font-family: system-ui;"><?php echo $title; ?></h1>
             </div>
             <hr style="width: 100%">
              <div class="col-sm-12 col-md-6 col-lg-5 single">
                   <div class="product">
                         <img class="img-fluid" src="images/product/<?php echo $pro_img; ?>" width="100%" alt="">
                   </div>
              </div>
              
              <div class="col-sm-12 col-md-6 col-lg-7 single">
                   <div class="product">

                       
                                <?php add_cart(); ?>     
                       
                                 <form action="product_details.php?add_cart=<?php echo $pro_id; ?>" class="form-horizontal" method="POST">
                                 <div class="form-group">
                                 <label for="" class="col-md-4 control-label">Products Quantity</label>
                                 
                                 <div class="col-md-4">
                                   <select name="product_qty" id="" class="form-control">
                                   <option>1</option>
                                   <option>2</option>
                                   <option>3</option>
                                   <option>4</option>
                                   <option>5</option>
                                   <option>6</option>
                                   <option>7</option>
                                   <option>8</option>
                                   <option>9</option>
                                   <option>10</option>
                                   </select>
                                   
                                 </div>
                                 
                                 </div>
                                 
                       
                     <p class="price" style="font-size:30px">Rs.<?php echo $price; ?>/-</p>
                     <br/>
                       <p class="buttons"><button class="btn btn-outline-danger i fa fa-shopping-cart"> Add To Cart</button></p>
                       </form>
                   </div>
              </div>
              
        </div>
    </div>
</div>

<br/>

<br/>
<br/>
</body>
	<?php include('footer.php'); ?>
</html>