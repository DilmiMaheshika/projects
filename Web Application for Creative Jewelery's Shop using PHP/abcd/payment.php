<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Payment</title>
	
<link href="pymnt.css" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
	
<?php include('navipay.php');?>
	<?php
	  include('include/db.php');
	if(isset($_POST['payment'])){
		
		$fullname = $_POST['fullname'];
		$email = $_POST['email'];
		$namecard = $_POST['name_on_card'];
		$address = $_POST['address'];
		$cardnumber = $_POST['credit_card_number'];
		$city = $_POST['city'];
		$month = $_POST['month'];
		$state = $_POST['state'];
		$zip = $_POST['zip'];
		$year = $_POST['year'];
		$cvv = $_POST['cvv'];
		$cus_ip = getRealIpUser();
		$insert_payment = "INSERT INTO payment (Customer_ip, Full_name, Email, Name_on_card, Address, Credit_card_number, City, Month_of_expiry, State, Zip, Year_of_expiry, Cvv) VALUES ('$cus_ip','$fullname','$email','$namecard','$address','$cardnumber','$city','$month','$state','$zip','$year','$cvv')";
		
		$run_payment = mysqli_query($conn,$insert_payment);
		if($run_payment){
			$_SESSION['Email'] = $cus_ip;
			echo "<script>alert('Payment Completed! You will receive your item shortly.')</script>";
			echo "<script>window.open('cart.php','_self')</script>";
		}
	}
	?>
	
<body background="images/pay1.jpg">
<br>
<br>

<div align="center" class="container">
    <form action="" method="post">
    <table class="table table-borderless">
    <thead bgcolor="grey">
    <tr>
    <th><h5>Billing Address</h5></th>
    <th><h5>Payment</h5></th>
    </tr>
    </thead>
    <tbody>
    <tr>
    <!--full name-->
    <div class="form-row">
    <td>
    <div class="form-group col-lg-8">
    <label for="Full Name"><p><i class="fa fa-user" aria-hidden="true"></i>Full Name</p></label>
    <input type="text" class="form-control-file" name="fullname" placeholder="Rukshan Madushanka" required>
    </div>
    </td>
    <!--cards-->
    <td>
    <div class="form-group col-lg-6">
    <label>Accepted cards</label><br>
    <img src="images/cards.png" alt="" height="50" width="200">
    </div>
    </td>
    </tr>
    </div>
    <!--email-->
    <div class="form-row">
    <tr>
    <td>
    <div class="form-group col-lg-8">
    <label for="email"><p>Email</p></label>
    <input type="email" class="form-control-file" name="email" placeholder="rukshan@gmail.com" required>
    </div>
    </td>
    <!--name on card-->
    <td>
    <div class="form-group col-lg-8">
    <label for="name on card"><p>Name on card</p></label>
    <input type="text" class="form-control-file" name="name_on_card" placeholder="Rukshan Madushanka" required>
    </div>
    </td>
    </tr>
    </div>
    
    <!--address-->
    <div class="form-row">
    <tr>
    <td>
    <div class="form-group col-lg-8">
    <label for="address"><p>Address</p></label>
    <input type="text" class="form-control-file" name="address" placeholder="No 100, Steel street, Colombo" required>
    </div>
    </td>
    <!--card number-->
    <td>
    <div class="form-group col-lg-8">
    <label for="card number"><p>Credit card number</p></label>
    <input type="text" class="form-control-file" name="credit_card_number" placeholder="xxxx-xxxx-xxxx" required>
    </div>
    </td>
    </tr>
    </div>
   
    <!--city-->
    <div class="form-row">
    <tr>
    <td>
    <div class="form-group col-lg-8">
    <label for="city"><p>City</p></label>
    <input type="text" class="form-control-file" name="city" placeholder="Colombo" required>
    </div>
    </td>
    
    <!--month of expiry-->
    <td>
    <div class="form-group col-lg-8">
    <label for="month of expiry"><p>Month of expiry</p></label>
    <select id="inputmonthofexpiry" name="month" class="form-control">
    <option selected>January</option>
    <option>February</option>
    <option>March</option>
    <option>April</option>
    <option>MAy</option>
    <option>June</option>
    <option>July</option>
    <option>August</option>
    <option>September</option>
    <option>October</option>
    <option>November</option>
    <option>December</option>
    </select>
    </div>
    </td>
    </tr>
    </div>
    
    <div class="form-row">
    <tr>
    <!--state-->
    <td>
    <div class="form-group col-lg-8">
    <label for="state"><p>Province/State</p></label>
    <input type="text" class="form-control-file" name="state" placeholder="Western" required>
    </div>
    </td>
    <!--zip-->
    <td>
    <div class="form-group col-lg-8">
    <label for="zip"><p>Zip</p></label>
    <input type="text" class="form-control-file" name="zip" placeholder="xxxxx" required>
    </div>
    </td>
    </tr>
    </div>
    <!--year of expiry-->
    <div class="form-row">
    <tr>
    <td>
    <div class="form-group col-lg-8">
    <label for="year of expiry"><p>Year of expiry</p></label>
    <select id="inputyearofexpiry" name="year" class="form-control">
    <option selected>2020</option>
    <option>2021</option>
    <option>2022</option>
    <option>2023</option>
    <option>2024</option>
    <option>2025</option>
    <option>2026</option>
    <option>2027</option>
    <option>2028</option>
    <option>2029</option>
    <option>2030</option>
    <option>2031</option>
    </select>
    </div>
    </td>
   <!--cvv-->
   <td>
   <div class="form-group col-lg-8">
   <label for="cvv"><p>CVV</p></label>
   <input type="text" class="form-control-file" name="cvv" placeholder="xxx" required>
   </div>
   </td> 
    </tr>
    </div>
   </tbody>
    </table>
    <div align="left" class="custom-control custom-checkbox">
   <input type="checkbox" class="custom-control-input" id="customCheck1">
   <label class="custom-control-label" for="customCheck1">Shipping address same as billing</label>
    </div>
     <div align="center" class="form-group">
  <input type="submit" name="payment" value="Complete Payment" class="btn btn-secondary">
    </div>
    
    </form>
    </div>
   
	
    
	<br>
<br>

	
</body>
	
</html>