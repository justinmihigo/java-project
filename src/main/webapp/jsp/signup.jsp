
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="shortcut icon" href="icon48.png" type="image/x-icon">
        <link rel="stylesheet" href="../html/logcss.css">
    </head>
    <body>
        <script src="index.js" defer></script>

        <div class="cont">
            <div class="wrapper">
                <form action="../RegisterServlet" method="post">
                    <label> First Name<br>
                        <input type="text" name="fname" class="input" placeholder="Enter your first name"><br>
                    </label>
                    <label> Second Name<br>
                        <input type="text" name="lname" class="input" placeholder="Enter your second name"><br>
                    </label>
                    <label> Date of birth<br>
                        <input type="date" name="dob" class="input"><br>
                    </label>
                    <label> Telephone number<br>
                        <input type="number" name="tel" class="input" placeholder="078282833"><br>
                    </label>
                    <label> Email<br>
                        <input type="email" name="email" class="input" placeholder="example@mail.com"><br>
                    </label>
                    <label for="account-type">Register as</label>
                    <select id="account-type" name="person" class="input">
                        <option value="">Choose an item...</option>
                        <option value="parent">Parent</option>
                        <option value="doctor">Doctor</option>
                        <option value="local">Local health consultant</option>
                    </select>
                    <div id="toshow">
                        <script>
                            let toshow = document.getElementById("toshow");
                            let type = document.getElementById("account-type");
                                toshow.style.display="none";
                            
                            type.addEventListener('click',()=>{
                                if (type.value === "doctor") {
                                toshow.style.display = "block";
                            } else {
                                toshow.style.display = "none";
                            }
                            });
                            
                        </script>
                        <label for="specialization">Specialization</label>
                        <input type="text" id="specialization" class="input" name="specialization" placeholder="Enter your specializaiton">
                    </div>
                    <label for="passwd1">New password<br>
                        <input type="password" class="input" name="password" id="passwd1" placeholder="Enter your password"><br>
                    </label>
                    <div id="error" style="display:none">
                        <ul style="list-style-type: none; font-size: 14px;">
                            <li class="item">The password  should be at least 8 characters</li>
                            <li class="item">The password must contain a number 0-9</li>
                            <li class="item">The password must contain a special character eg. !@#$%</li>
                            <li class="item">The password must contain uppercase</li>
                        </ul>
                    </div>
                    <label>Confirm password<br>
                        <input type="password" class="input" id="passwd2" name="passwordRepeat" placeholder="Repeat your password"><br>
                    </label>
                    <div id="error1" style="display:none">
                        <ul style="list-style-type: none; font-size: 14px;">
                            <li class="item">The password doesn't match</li>
                        </ul>
                    </div>
                    Gender<br>
                    <input type="radio" name="gender" value="M"> Male<br>
                    <input type="radio" name="gender" value="F"> Female<br>
                    <input type="radio" name="gender" value="B"> Non-binary<br>
                    <input type="radio" name="gender" value="LBTQ"> LBTQ+<br>
                    <input type="radio" name="gender" value="no"> Prefer not to say<br>
                    <input type="submit" value="submit" class="input"><br>
                </form>
            </div>
        </div>
    </body>
</html>