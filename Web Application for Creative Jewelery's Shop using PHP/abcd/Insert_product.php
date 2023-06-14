<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>insert products</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

 <?php
	include('include/db.php');
	//insert
	if(isset($_POST['submit'])){
	
	   $pro_img = $_POST['pro_img'];
	   $pro_title = $_POST['title'];
	   $pro_des = $_POST['des'];
	   $pro_id = $_POST['pro_id'];
	   $pro_cat = $_POST['pro-cat'];
	   $cat = $_POST['cat-id'];
	   $mat =$_POST['material'];
	   $karat = $_POST['karat'];
	   $weight = $_POST['weight'];
	   $price = $_POST['price'];
	   
	   $insert_product = "INSERT INTO product  ( Product_Category, Category, Product_image, Title, Description, Material, Karatage, Weight, Price)
	            VALUES    ('$pro_cat','$cat','$pro_img','$pro_title','$pro_des','$mat','$karat','$weight','$price')";
				
		$run_product = mysqli_query($conn,$insert_product);
		
		if($run_product){
			echo "<script>alert('Successfully inserted!')</script>";
			echo "<script>window.open('Insert_product.php','_self')</script>";
		}
	}
	
	//update
	if(isset($_POST['update'])){
	
	   $pro_img = $_POST['pro_img'];
	   $pro_title = $_POST['title'];
	   $pro_des = $_POST['des'];
	   $pro_cat = $_POST['pro-cat'];
	   $cat = $_POST['cat-id'];
	   $mat =$_POST['material'];
	   $karat = $_POST['karat'];
	   $weight = $_POST['weight'];
	   $price = $_POST['price'];
	   
	   $update_product = "UPDATE product SET Product_Category = '$pro_cat', Category = '$cat', Product_image ='$pro_img', Description ='$pro_des',
	   Material ='$mat', Karatage ='$karat', Weight ='$weight', Price='$price' WHERE Title ='$pro_title'";
	            
				
		$run_product = mysqli_query($conn,$update_product);
		if($run_product){
			echo "<script>alert('Successfully updated')</script>";
			echo "<script>window.open('Insert_product.php','_self')</script>";
		}
	
	}
	
	
	?>
	<?php include('navadmin.php'); ?>
    
    <body background="images/pay.jpg">
		<br>
		<br>
   <div class="container">
   <form action="" method="post">
	 <table class="table table-borderless">
		 
	   <tr>
		   <div class="form-row">
			   <!--product category-->
			  <td>
			   <div class="form-group col-lg-6">
				  <label for="Product_cat_id"><p>Product category</p></label>
				   <select id="inputProduct-category-id" name="pro-cat" class="form-control-file" required>
					  <option>Select a product Category</option>
					   <?php 
					   $get_p_cats ="SELECT * FROM product_category";
					   $run_p_cats = mysqli_query($conn,$get_p_cats);
					   
					   while ($row_p_cats = mysqli_fetch_array($run_p_cats)){
						   $p_cat_id = $row_p_cats['Product_category_id'];
						   $p_cat_title = $row_p_cats['Product_Category_name'];
						   echo "
						   <option value='$p_cat_id'>$p_cat_title</option>
						   ";
					   }
					   ?>
				   </select>
				 </div>
			   </td>
			    <!--Cat-id-->
			 <td>
			 <div class="form-group col-lg-6">
				 <label for="Cat-id"><p>Category</p></label>
			<select id="inputcategory_id" name="cat-id" class="form-control-file" required>
				<option>Select a category</option>
				<?php
				$get_cat = "SELECT * FROM category";
				$run_cat = mysqli_query($conn,$get_cat);
				
				while($row_cat=mysqli_fetch_array($run_cat)){
					$cat_id = $row_cat['Category_id'];
					$cat_name = $row_cat['Category_name'];
					echo"
					
					<option value='$cat_id'>$cat_name</option>
					";
				}
				?>
				 </select>
			</div>
			 </td>
		   </div>
		</tr>
		 
		 <tr>
		 <div class="form-row">
			
			 <!--product image-->
			 <td>
			 <div class="form-group col-lg-6">
				<label for="pro_img"><p>Product image</p></label>
				 <input type="file" name="pro_img" class="form-control-file" required>
				</div>
			 </td>
			 <!--Title-->
		 <td><div class="form-group col-lg-6">
			 <label for="title"><p>Title</p></label>
			 <input type="text" name="title" class="form-control-file" required>
			 </div></td>
		</div>
		 </tr>
		 
		 <tr>
			 <div class="form-row">
			 <!--Description-->
		 <td>
			<div class="form-group col-lg">
				<label for="description"><p>Description</p></label>
			<textarea class="form-control-file" name="des"></textarea>
			 </div> 
	    </td>
			 </div>
		 </tr>
		 
		 <tr>
			 <div class="from-row">
			 <!--Material-->
				<td>
				 <div class="form-group col-lg-6">
					 <lable for="material"><p>Material</p></lable>
					 <select id="inputmaterial" name="material" class="form-control-file" required>
					<option>Yellow gold</option>
					<option>Rose gold</option>
					<option>White gold</option>
					 </select>
					</div>
				 </td>
				 <!--karatage-->
				 <td>
				 <div class="form-group col-lg-6">
					 <lable for="karat"><p>Karatage</p></lable>
					 <select id="inputkarat" name="karat" class="form-control-file" required>
						<option>18k</option>
						 <option>22k</option>
					 </select>
					 </div>
				 </td>
			 </div>
		 </tr>
		 
		 <tr>
		 <div class="form-row">
			<!--weight-->
		<td>
		<div class="form-group col-lg-6">
			<label for="weight"><p>Weight</p></label>
		<input type="text" name="weight" class="form-control-file" required>
		</div>
	    </td>
			 <!--price-->
			 <td>
			 <div class="form-group col-lg-6">
				 <lable for="price"><p>Price</p></lable>
				 <input type="text" name="price" class="form-control-file" required>
			</div>
			 </td>
	     </div>
		 </tr>
	   </table>
	   <div align="center">
	   <input type="submit" name="submit" value="Insert" class="btn btn-outline-dark">
	   <input type="submit" name="update" value="Update" class="btn btn-outline-dark">
	   
		  </div>
	   <br>
		</form>
		</div>
    </body>
    <br>
<br>

   
    </html>
   
	