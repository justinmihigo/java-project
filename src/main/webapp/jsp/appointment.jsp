
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Appointment</title>
    <link rel="shortcut icon" href="icon48.png" type="image/x-icon">
    <link rel="stylesheet" href="../html/logcss.css">
</head>
<body>
    <div class="cont">
        <div class="wrapper">
            <form action="../AddAppointment" method="post">
                <label> Appointment Date<br>
                    <input type="date" name="appointDate" class="input" required><br>
                </label>
                <label> Child ID<br>
                    <input type="number" name="childId" class="input" required><br>
                </label>
                <label> Parent ID<br>
                    <input type="number" name="parentId" class="input" required><br>
                </label>
                <label> Hospital ID<br>
                    <input type="number" name="hospitalId" class="input" required><br>
                </label>
                <label> Doctor ID<br>
                    <input type="number" name="doctorId" class="input" required><br>
                </label>
                <input type="submit" value="Add Appointment" class="input"><br>
            </form>
        </div>
    </div>
</body>
</html>
