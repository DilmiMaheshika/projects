<?php
include('function.php');

session_start();

session_destroy();

       $ip_add = getRealIpUser();
       $delete_cart = "Delete from cart where Ip_add = '$ip_add'";
       $run_delete = mysqli_query($conn,$delete_cart);

echo "<script>window.open('home.php','_self')</script>"


?>