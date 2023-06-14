<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
	<link rel="stylesheet" href="view.css" type="text/css"/>
<!--font-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

</head>

<body background="images/pay.jpg">
	<?php include('navadmin.php'); ?>
	<br>
	
	<div class="container">
	<div id="cart" class="col-md-8 col-lg-12">
		<!--product id-->
	<form class="form" action="" method="post">
			 <td>
				 <div class="form-row">
			 <div class="form-group col-lg-3">
				<label for="pro_id"><h5>Product ID</h5></label>
				 <input type="text" name="pro_id" class="form-control-file" required>
				</div>
			 </td>
				 <div class="button">
					 <br><br>
		<input type="submit" name="view" value="View" class="btn btn-outline-dark">
		<input type="submit" name="delete" value="Delete" class="btn btn-outline-dark">
				 </div>
		</div>
		</form><br>
		<!--delete-->
		<?php 
		if(isset($_POST['delete'])){
			$pro_id = $_POST['pro_id'];
	     $delete_query = "DELETE FROM product WHERE Product_id = '$pro_id'";
			$delete_run = mysqli_query($conn,$delete_query);
			if($delete_run){
				echo "<script>alert('Successfully Deleted!')</script>";
				echo "<script>window.open('dlt&view.php','_self')</script>";
			}
		}
		?>
	<div class="box">
	<form action="" method="post" enctype="multipart/form-data">
		<h4 class="table-method">Product Details</h4><br/>
		<div class="table-responsive">
		<table class="table">
			<thead>
			<tr>
				<th>Product id</th>
	            <th>Product Category</th>
				<th>Category</th>
				<th>Product Image</th>
				<th>Title</th>
				<th>Description</th>
				<th>Material</th>
				<th>Karatage</th>
				<th>Weight</th>
				<th>Price</th>
			</tr>
			</thead>
			<tbody>
			<?php
				if(isset($_POST['viewall'])){
				$viewall_query = "Select * from product";
				$viewall_query_run = mysqli_query($conn,$viewall_query);
				while($row = mysqli_fetch_array($viewall_query_run)){
			?>
					<tbody>
						<tr>
						<td><?php echo $row['Product_id'] ?></td>
						<td><?php echo $row['Product_Category'] ?></td>
						<td><?php echo $row['Category'] ?></td>
						<td><?php echo $row['Product_image'] ?></td>
						<td><?php echo $row['Title'] ?></td>
						<td><?php echo $row['Description'] ?></td>
						<td><?php echo $row['Material'] ?></td>
						<td><?php echo $row['Karatage'] ?></td>
						<td><?php echo $row['Weight'] ?></td>
						<td><?php echo $row['Price'] ?></td>
						</tr>
							<?php
					
				    }
				}
				?>
						<?php
		//view
		if(isset($_POST['view'])){
			$pro_id = $_POST['pro_id'];
				$view_query = "SELECT * FROM product WHERE Product_id = '$pro_id'";
			$view_run = mysqli_query($conn,$view_query);
			while($row = mysqli_fetch_array($view_run)){
				?>
		       <tr>
						<td><?php echo $row['Product_id'] ?></td>
						<td><?php echo $row['Product_Category'] ?></td>
						<td><?php echo $row['Category'] ?></td>
						<td><?php echo $row['Product_image'] ?></td>
						<td><?php echo $row['Title'] ?></td>
						<td><?php echo $row['Description'] ?></td>
						<td><?php echo $row['Material'] ?></td>
						<td><?php echo $row['Karatage'] ?></td>
						<td><?php echo $row['Weight'] ?></td>
						<td><?php echo $row['Price'] ?></td>
		</tr>
		<?php
			
			}
		}
		?>
			</tbody>
		</table>
		</div>
		<input type="submit" class="btn btn-outline-dark" name="viewall" value="View all">
	</form>	
	</div>	
	</div>
	</div>
	</body>
</html>