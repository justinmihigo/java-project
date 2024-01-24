
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Child data</title>
        <link rel="stylesheet" href="../css/child.css">
    </head>
    <body>
        <div class="wrapper">
       <section class="data">
            <h3>Enter the new data for your child here </h3>
            <form action="../GrowthDataServlet" method="post">
                <input type="hidden" value="${childId}" name="childId">
                <input type="hidden" value="${age}" name="age">
                <label for="headCircum" class="padding">Head Circumference</label>
                <input type="text" id="headCircum" name="headCircum" class="input" placeholder="enter head circumference in (cm)">
                <label for="weight">Weight</label>
                <input type="text" id="weight" name="weight" class="input" placeholder="enter weight in kilogram (kgs)">
                <label for="height">Height</label>
                <input type="text" id="height" name="height" class="input" placeholder="enter height in centimeter (cm)">
                <input type="submit" value="Submit" class="input" id="Submit">
            </form>
        </section>
            </div>
    </body>
</html>
