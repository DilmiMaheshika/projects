<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Cart</title>
	
<!--<link href="cart.css" rel="stylesheet"/>-->
	<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<?php include('navigation.php'); ?>

	<!--CSS-->
	<style>
	
	.navbar-collapse .right
{
	float:right;
}
.box
{
	background:#ffffff;
	margin: 0 0 30px;
	border:solid 1px #e6e6e6;
	box-sizing:border-box;
	padding:20px;
	box-shadow:0px 2px 5px rgba(0, 0, 0, .3);
}
.box .btn
{
	float:right;
}

/*tbody*/
#cart .table tbody tr td img
{
	width:100px;
}
	
	</style>
	
	</head>

<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="home.php" style="font-size:36px"><i class="fa fa-shopping-bag" aria-hidden="true"></i>&nbsp; Cart <span class="sr-only">(current)</span></a>
      </li>
      </ul>
	   <a href="shoppingCart.php" class="btn navbar-btn btn-light">
                      <i class="fa fa-shopping-cart"></i>
                      <span class="badge badge-light"><?php items(); ?>  Number of items In your Cart. </span></a>
	
    </nav>
  
	  <br/>
  <br/>
 
<!--cart start-->
<div class="container">
<div class="row">
<div id="cart" class="col-md-8" >
  <div class="box">
     <form action="cart.php" method="post" enctype="multipart/form-data">
         <h2> Cart</h2>
         
         <?php
		 
		   $ip_add = getRealIpUser();
		   
		   $select_cart = "select * from cart where Ip_add='$ip_add'";
		   
		   $run_cart = mysqli_query($conn,$select_cart);
		   
		   $count = mysqli_num_rows($run_cart);
		 
		 ?>
		 
		  <p class="text-method">Currently you have <?php echo $count; ?> number of item(s) in your cart</p>
            <div class="table-responsive">  
                 <table class="table">
                    <thead>
                       <tr>
                          <th colspan="2">Product</th>
                          <th>Quantity</th>
                          <th>Unit Price</th>
                          <th colspan="1">Delete</th>
                          <th colspan="2">Sub-Total</th>
                       </tr>
                    </thead>
					 
					  <tbody>
                     
                     <?php
					 
					  $total = 0;
					  
					  $dis_rate = 0.1;
							 
					  $tax_rate = 0.03;
					  
					  $discount = 0;
						  
					  $tax = 0;
				
					  $final_total = 0;
					
					  
					  while($row_cart = mysqli_fetch_array($run_cart)){
						  
						 $pro_id =  $row_cart['Pro_id'];
						 
						 $pro_qty =  $row_cart['Quantity'];
						 
						 $get_products = "select * from product where Product_id='$pro_id'";
						 
						 $run_products = mysqli_query($conn,$get_products);
						 
						 while ($row_products = mysqli_fetch_array($run_products)){
							 
							 $title = $row_products['Title'];
							 
							 $pro_img = $row_products['Product_image'];
							 
							 $price = $row_products['Price'];
							 
							 $sub_total = $row_products['Price']*$pro_qty;
							 
							 $total = $sub_total;
							 
							 $discount = $total * $dis_rate;
							 
							 $tax = $total * $tax_rate;
							 
							 $final_total = ($total - $discount) + $tax; 
					 
					 ?>
                     
                     
                      <tr>
                        <td>
                           <img class="img-responsive"  src="images/product/<?php echo $pro_img; ?>">
                        </td>
                        
                        <td> 
                           <a href="product_details.php.php?pro_id=<?php echo $pro_id; ?>"><?php echo $title; ?></a>
                        </td>
                        
                        
                        <td>
                           <?php echo $pro_qty; ?>
                        </td>
                        <td>
                          Rs.<?php echo $price; ?>/-
                        </td>
                        <td>
                           <input type="checkbox" name="remove[]" value="<?php echo $pro_id; ?>" >
                        </td>
                        <td>
                          Rs.<?php echo $sub_total; ?>/-
                        </td>
                      </tr>
                      
                      <?php
					        }
						 }
					  ?>
                      
                     </tbody>
                      
                 </table>
            </div>
            <div class="box-footer">
               <div class="pull-left">
                  <a href="home.php" class="btn btn-secondary">
                     <i class="fa fa-chevron-left"></i> Continue Shopping
                  </a>
               </div>
               <div class="pull-right">
                  <input type="submit" name="update" value="Update Cart" class="btn btn-secondary">
                     
                  
                  
               </div>
            </div>
     </form>
  </div>
  </div>
  <div class="col-md-4">
    <div id="order-summary" class="box">
       <div class="box-header">
          <h4> Order Summary</h4>
       </div>
       <p class="text-muted">
         Shipping and Additional Cost calculations are based on number of items you have purchased.
       </p>
       <div class="table-responsive">
          <table class="table">
             <tbody>
                <tr>
                  <td>Order Sub-Total</td>
                  <th>Rs.<?php echo $total; ?>/-</th>
                </tr>
                <tr>
                  <td class="text-muted"> Discount (10%)</td>
                  <th class="text-muted">Rs.<?php echo $discount; ?>/-</th>
                </tr>
                <tr>
                  <td class="text-muted"> Tax</td>
                  <th class="text-muted">Rs.<?php echo $tax; ?>/-</th>
                </tr>
                <tr class="total">
                  <th style="font-size:22px"> Total</th>
                  <th style="font-size:22px">Rs.<?php echo $final_total; ?>/-</th>
                </tr>
                <tr>
                <td colspan="2">
                  <button type="submit" name="ProceedCheckout" value="Checkout" class="btn btn-secondary">
                     
                     
                      <?php
	 
	  if(!isset($_SESSION['Email'])){
		 
		  echo "<a href='login.php'><i class='fa fa-check-circl' aria-hidden='true'></i>Checkout</a>";
		  
		  }else{
			  
			   echo "<a href='payment.php'><i class='fa fa-check-circl' aria-hidden='true'></i>Checkout</a>";
			  
			  }
	 ?>
                     
                  </button>
                  </td>
                </tr>
             </tbody>
          </table>
       </div>
    </div>
  </div> 
 </div> 
 </div>
</div><!--finish-->

<?php
function update(){
	
	global $conn;
	if(isset($_POST['update'])){
		
	$delete_product = "DELETE FROM cart WHERE Pro_id = '$pro_id'";
	$run_delete = mysqli_query($conn,$delete_product);
		if($run_delete){
			echo "<script>window.open('cart.php','_self')</script>";
		}else{
			echo "Error!".mysqli_error($conn);
		}
	}
}

	echo @$up_cart = update();
?>

	<?php include('footer.php'); ?>
</body>
</html>