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
<?php include('navadmin.php'); ?>
	<br>
	<br>
<body background="images/pay.jpg">
	
	<div class="container">
	<div id="cart" class="col-md-8 col-lg-12">
	<div class="box">
	<form action="" method="post" enctype="multipart/form-data">
		<h4 class="table-method">Product Details</h4><br/>
		<div class="table-responsive">
		<table class="table">
			<thead>
			<tr>
				<th>Message ID</th>
				<th>Customer Name</th>
	            <th>Customer Email</th>
				<th>Contact No</th>
				<th>Message</th>
				
			</tr>
			</thead>
			<tbody>
			<?php
//				if(isset($_POST['viewall'])){
				$viewall_query = "Select * from customer_message";
				$viewall_query_run = mysqli_query($conn,$viewall_query);
				while($row = mysqli_fetch_array($viewall_query_run)){
			?>
					<tbody>
						<tr>
						<td><?php echo $row['message_id'] ?></td>
						<td><?php echo $row['Name'] ?></td>
						<td><?php echo $row['Email'] ?></td>
						<td><?php echo $row['Contact_no'] ?></td>
						<td><?php echo $row['Message'] ?></td>
						
						</tr>
							<?php
					
//				    }
				}
				?>
						
		
			</tbody>
		</table>
		</div>
		<input type="submit" class="btn btn-outline-dark" name="viewall" value="View all">
	</form>	
	</div>	
	</div>
	
</body>
</html>