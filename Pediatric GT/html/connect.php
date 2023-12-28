<?php
$host="localhost:3307";
$user="root";
$pass="";
$db="users";
$con=new mysqli($host,$user,$pass,$db) or die("unable to connect");
echo "connection success";
$query = "create table parents (parentId int primary key, fname varchar(25),lname varchar(25),sex varchar(1))";
$exec = mysqli_query($con,$query);
mysqli_execute_query($con,$exec);
?>