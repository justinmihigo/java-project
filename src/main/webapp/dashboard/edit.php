
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reschedule</title>
    <link rel="shortcut icon" href="icon48.png" type="image/x-icon">
    <link rel="stylesheet" href="../html/logcss.css">
</head>
<body>
    <div class="cont">
    <div class="wrapper">
        <form action="edit.php" method="post">
            <input type="hidden" name="first" class="input"><br>
            </label>
            <label> Appointment date<br>
            <input type="date" name="appoint" class="input"><br>
            </label>
            <label> Doctor<br>
            <input type="text" name="fname" class="input"><br>
            </label>
                <input type="submit" value="submit" class="input">
                <br>
            </form>
        </div>
    </div>
</body>
</html>
<?php
$host="localhost:3307";
$user="root";
$pass="";
$db="users";
$con=new mysqli($host,$user,$pass,$db) or die("unable to connect");
$id=$_GET['appointmentId'];
$todate=$_POST['appoint'];
$name=$_POST['fname'];
$query1="update schedule set appointDate='$todate', fname='$name' where schedule.appointmentId=$id";
$con->query($query1);
header('location:./dash.php');
?>
