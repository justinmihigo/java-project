<?php
$host="localhost:3307";
$user="root";
$pass="";
$db="users";
$con=new mysqli($host,$user,$pass,$db) or die("unable to connect");
$em=$_POST['email'];
$email=strval($em);
$select = "select parentId, fname, email from parents where parents.email='$email'";
/*if($stmt=$con->prepare($select)){
    $stmt->bind_param('s',$email);
    $stmt->execute();
}*/
$result=$con->query($select);
$row=$result->fetch_array();
if($row['email']==$email){
    echo "welcome ".$row['fname'];
    $_SESSION['auth']=true;
    $_SESSION['user_id']=$row['parentId'];
    header('location:../dashboard/dash.php');
}
else{
    echo "invalid email or password please check your password";
}
/*  $result=$con->query($select);
    if($result){
while($row=$result->fetch_assoc()){
    echo "<h2>Welcome</h2>". $row['fname']." ".$row['lname']."<br>";
}
}*/


//header('location:dashboard/dash.html');
$con->close();
?>