<?php
$host="localhost:3307";
$user="root";
$pass="";
$db="users";
$con=new mysqli($host,$user,$pass,$db) or die("unable to connect");
echo "connection success"."<br>";
echo "welcome to this site"."<br>";
$fame = $_POST['first'];
$lame = $_POST['second'];
$myquery= "insert into parents (fname,lname,sex) values (?,?,'M')";
if($stmt=$con->prepare($myquery)){
$stmt->bind_param('ss',$fame,$lame);
$stmt->execute();
echo "Data inserted successfully";
}

else{
    echo "unable to insert the data";
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="shortcut icon" href="icon48.png" type="image/x-icon">
    <link rel="stylesheet" href="logcss.css">
</head>
<body>
    <table cellspacing="20" cellpadding="20">
        <thead>
            <th>ID</th>
            <th>First name</th>
            <th>last name</th>
            <th>Gender</th>
        </thead>
        <tbody>
            <?php
            $sel="select * from parents";
            $result=$con->query($sel);
            while($row=$result->fetch_assoc()){
                echo "
                <tr>
                <td>$row[parentId]</td>
                <td>$row[fname]</td>
                <td>$row[lname]</td>
                <td>$row[sex]</td>
                </tr>
                ";
            }
            $con->close();
            ?>
        </tbody>
    </table>
</body>
</html>