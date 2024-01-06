<?php
$host="localhost:3307";
$user="root";
$pass="";
$db="users";
$con=new mysqli($host,$user,$pass,$db) or die("unable to connect");
$id=$_GET['appointmentId'];
$del="grant delete on schedule to 'root'";
$con->query($del);
$query1="delete from  schedule where schedule.appointmentId=$id";
$con->query($query1);
header('location:./dash.php');
?>