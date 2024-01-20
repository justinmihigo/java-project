<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Children info</title>
    <link rel="shortcut icon" href="icon48.png" type="image/x-icon">
    <link rel="stylesheet" href="../css/child.css">
</head>
<body>
    <div class="cont">
    <div class="wrapper">
        <h2>Enter your child's information</h2>
        <form action="../parents" method="post">
            <input type="text" value="${userId}">
            <label for="fname">First name</label><br>
            <input type="text" name="fname" class="input" id="fname" placeholder="Enter the child's First name"><br>
            <label for="lname">Last name</label><br>
            <input type="text" name="lname" class="input" id="lname" placeholder="Enter the child's Last name"><br>
            <label for="dob">Date of Birth</label><br>
            <input type="date" name="dob" class="input" id="dob" ><br>
            <label for="age">Age</label><br>
            <input type="number" name="age" class="input" id="age" placeholder="Enter the child's age"><br>
            <label>Gender</label><br>
            <div class="options">
            <input type="radio" name="gender" value="M" id="m"><label for="m"> Male<label><br>
            <input type="radio" name="gender" value="F" id="f"> <label for="f">Female</label><br>
            <input type="radio" name="gender" value="no" id="no"><label for="no"> Prefer not to say<label><br>
            </div>
            <input type="submit" value="submit" class="input"><br>
            </form>
            </div>
            </div>
            </body>
            </html>
