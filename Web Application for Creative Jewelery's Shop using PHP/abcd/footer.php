<?php include('include/db.php'); ?>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Untitled Document</title>
<link href="icon.css" type="text/css" rel="stylesheet"/>
<link href="ftr.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="http://maxcdn.bootsrapcdn.com/font-awesome/4.7.0/font-awesome.min.css">
	<!--font awsome-->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	
</head>

<body>
	<footer>
		
	<div class="footer-top">
		<div class="container">
		<div class="row">
             <div class="col-md-4 col-sm-6 col-xs-12 segment-two md-mb-30 sm-mb-30">
             <h2>QUICK LINKS</h2>
             <ul>
             <li><a href="home.php"><i class="fa fa-home" aria-hidden="true"></i>&nbsp;Home</a></li>
             <li><a href="About.php"><i class="fa fa-info-circle" aria-hidden="true"></i>&nbsp;About Us</a> </li>		     
             <li><a href="Contact us.php"><i class="fa fa-phone" aria-hidden="true"></i> Contact Us</a></li>
	         <li ><a href="login.php"><i class="fa fa-key" aria-hidden="true"></i> Login</a></li>
	         <li><a href="cart.php"><i class="fa fa-shopping-cart"></i> Cart</a></li>
             </ul>
             </div>
             <div class="col-md-4 col-sm-6 col-xs-12 segment-three md-mb-30 sm-mb-30">

             <h2>CONTACT US</h2>
                 <br>
                 <br>
             <p><i class="fa fa-phone" aria-hidden="true"></i>&nbsp;Phone :+94 77 893 5367<br/>
             <p>NO 100/2, Kings Road, Colombo 2<p>
            </div>
             <div  class="col-md-4 col-sm-6 col-xs-12 segment-three md-mb-30 sm-mb-30">
                 <h2>FOLLOW US</h2>
                 <br>
                 <br>
                 <a href="https://www.facebook.com"><i class="fa fa-facebook" ></i></a>
                 <a href="https://www.instagram.com"><i class="fa fa-instagram" ></i></a>
                 <a href="https://www.twitter.com"><i class="fa fa-twitter" ></i></a>
                 <a href="https://www.linkedin.com"><i class="fa fa-linkedin" ></i></a>
                 <br/>
                 <br/>
                 <br/>
              </div>
			<!--PHP-->
			<?php
			if(isset($_POST['sub'])){
				$email = $_POST['email'];
				
				$sub_query ="INSERT INTO subscribe (Email) VALUES ('$email')";
				$run_sub = mysqli_query($conn,$sub_query);
				if($run_sub){
					echo "<script>alert('Subscription Successful!')</script>";
				}
			}
			?>
		</div>
		</div>
	</div>
		<p class="footer-bottom-text"><i class="fa fa-copyright" aria-hidden="true"></i> Copyright 2021 Creative Jewellers.</p>
	</footer>
</body>
</html>