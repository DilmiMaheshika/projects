<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Contact Us</title>
<!--<link href="Contact.css" rel="stylesheet"/>-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"> 
<link href="css/bootstrap-4.3.1.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
 <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script> 
<script src="js/bootstrap-4.3.1.js"></script>
	
	<!--CSS-->
    <style>
        .form-control {
            margin: 10px;
        }
		h4{
	align-content: center;
	text-align: center;
	color: hsla(213,80%,48%,1.00);
}
    </style>
</head>
	
<?php include("navigation.php"); ?>
	

<body>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="container">
    <div class="row" style="border:1px solid #ffad00 ">
        <div class="col-lg-8 col-md-12" style="padding: 0">
            <div class="embed-responsive embed-responsive-16by9">
                <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d4047218.2103831316!2d78.46159819420433!3d7.857179632785716!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ae2593cf65a1e9d%3A0xe13da4b400e2d38c!2sSri%20Lanka!5e0!3m2!1sen!2slk!4v1581756593867!5m2!1sen!2slk" ></iframe>
            </div>
        </div>
        <div class="col-lg-4 col-md-12">

<!--            <div class="card border-dark mb-3">-->
<!--                <div class="card-body">-->
                    <h2 align="center"><b>Leave your message.</b></h2>
                    <p align="center">We will reach you as soon as possible.</p>
                    <form action="" method="post" >
                        <div class="form-group">
                            <div class="col-md-12">
                                <input type="text" name="name" class="form-control" placeholder="Your Name" required>
                            </div>
                            <div class="col-md-12">
                                <input type="text" name="email" class="form-control" placeholder="Email" required>
                            </div>
                            <div class="col-md-12">
                                <input type="text" name="contact" class="form-control" placeholder="Contact No" required>
                            </div>

                        </div>
                        <br>
                        <div class="col">
                            <textarea class="form-control" name="msg" rows="5" placeholder="Your Message" required></textarea>
                        </div>
                        <br>
                        <div align="center">
                            <input type="submit" name="send_msg" value="Send Message" class="btn btn-outline-dark">
                        </div>
                    </form>
                </div>
            </div>
        </div>
<!--    </div>-->
<!--</div>-->


<div class="container mt-3">

</div>
	<br>
	<div class="card-group">
	
  <div class="card bg-light mb-3"> 
    <div align="center" class="card-body">
     <h5><i class="fa fa-phone" aria-hidden="true"></i></h5>
		<h5>Phone</h5>
	<a type="button" class="btn btn-link" href="#"><u>+94 77 893 5367</u></a>
	<a type="button" class="btn btn-link" href="#"><u>+94 76 248 5000 </u></a> / <a type="button" class="btn btn-link" href="#"><u>+94 78 560 0892</u></a>
		
    </div>
  </div>
  <div class="card bg-light mb-3">
    <div align="center" class="card-body">
	<h5><i class="fa fa-map-marker" aria-hidden="true"></i></h5>
		<h5>Address</h5>
	<p>NO 100/2, Kings Road, Colombo 2</p>
    
    </div>
  </div>
  <div class="card bg-light mb-3">
    <div align="center" class="card-body">
   <h5><i class="fa fa-clock-o" aria-hidden="true"></i></h5>
		<h5>Working hours</h5>
		<p>9:00 am to 7:00 pm</p>
		
    </div>
  </div>
	<div class="card bg-light mb-3">
    <div align="center" class="card-body">
	<h5><i class="fa fa-envelope-o" aria-hidden="true"></i></h5>
	<h5>Email</h5>
 <a type="button" class="btn btn-link" href="#"><u>info@creativejewellers.lk</u></a>

		
    </div>
  </div>
	
</div>
	


<?php
	if(isset($_POST['send_msg'])){
		$name = $_POST['name'];
		$email = $_POST['email'];
		$contact = $_POST['contact'];
		$msg = $_POST['msg'];
		
		$insert_msg = "INSERT INTO customer_message (Name, Email, Contact_no, Message) VALUES ('$name','$email','$contact','$msg')";
		$run_msg = mysqli_query($conn,$insert_msg);
		
		if($run_msg){
			echo "<script>alert('Message sent Successfully!')</script>";
			echo "<script>window.open('Contact us.php','_self')</script>";
		}
	}
	?>
	
</body>
<?php include("footer.php"); ?>
</html>