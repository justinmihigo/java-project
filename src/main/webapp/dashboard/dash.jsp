<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.UserDao" %>
<%@page import="java.sql.*"%>
<%@page import="dao.AppointmentDao" %>
<%@page import="dao.DbConnection" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Mihigo Justin">
    <title>GrowthPulseTrack</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
    <link rel="stylesheet" href="/Pediatric/dashboard/dash.css" type="text/css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="shortcut icon" href="./my web/icon48.png" type="image/x-icon">
</head>

<body>
    <script type="module" src="./dash.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <div class="nav">
        <div class="left">
            <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" viewBox="0 0 16 16">
                <path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round"
                    stroke-width="1.5" d="M2.75 12.25h10.5m-10.5-4h10.5m-10.5-4h10.5" />
            </svg>
            <div class="logo">
                <div id="logo"></div>
                <h3>GrowthPulseTrack</h3>
            </div>
        </div>
        <ul class="right">
            <li><a href="#home">Back to Home</a></li>
        </ul>
    </div>
    <aside>
        <div class="dashboard">
            <ul>
                <li><i class="fa-solid fa-house"></i>
                    <a href="">Dashboard</a>
                </li>
                <li>
                    <i class="fa-solid fa-chart-simple"></i>
                    <a href="#reports">Report</a>
                </li>
                <li>
                    <i class="fa-solid fa-user-doctor"></i>
                    <a href="#recommendations">Recommendations</a>
                </li>
                <li>
                    <i class="fa-solid fa-clock-rotate-left"></i>
                    <a href="#appointments">History</a>
                </li>
                <li>
                    <i class="fa-solid fa-circle-info"></i>
                    <a href="">Help</a>
                </li>
            </ul>
        </div>
    </aside>
    <div class="main">
        
        <div class="start">
            <h2>Welcome to the Parent's Dashboard</h2>
            <div>
                <button><a href="../jsp/profileParent.jsp">Add Child</a></button>
            </div>
            <div>
                <a href="#">View available doctors</a>
            </div>

        </div>
         <%
               UserDao userdao=new UserDao();
               try{
               if(!userdao.checkChild()){
               out.print("You don't have any registered children");
                   }
                   }
                   catch(Exception e){
                   out.print(e);
                   }
            %>
        <div>
        <section id="reports">
            <h2 class="center">Reports</h2>
            <div class="cards" id="reports">
                <div class="card1">
                    <canvas id="myLineChart"></canvas>
                </div>
                <div class="cards" id="reports">
                    <div class="card1">
                        <canvas id="myLineChart"></canvas>
                    </div>
                    <div class="cards" id="reports">
                        <div class="card1">
                            <canvas id="myLineChart"></canvas>
                        </div>
            </section>
        <section class="recommendations" id="recommendations">
            <h2 class="center">Recommendations</h2>
            <div class="cards">
                <div class="card1">

                    <h4>Recommendations</h4>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                        Repellat magnam nesciunt molestiae similique inventore voluptate
                        fugit possimus reiciendis temporibus perspiciatis.</p>
                </div>
                <div id="card2">
                    <h4>Recommendations</h4>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                        Repellat magnam nesciunt molestiae similique inventore voluptate
                        fugit possimus reiciendis temporibus perspiciatis.</p>
                </div>
                <div id="card3">
                    <h4>Recommendations</h4>
                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                        Repellat magnam nesciunt molestiae similique inventore voluptate
                        fugit possimus reiciendis temporibus perspiciatis.</p>
                </div>
            </div>
        </section>
        
        <div class="appointments" id="appointments">
            <h2>Appointments</h2>
            <table width="80%" cellspacing="20">
                <thead>
                    <tr>
                        <th>AppointNo</th>
                        <th>Assigned</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Date</th>
                        <th>Telephone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="appointment" items="${appointment}">
                        <tr>
                            <td>${appointment.appointmentId}</td>
                            <td>${appointment.appointDate}</td>
                            <td>${appointment.fname}</td>
                            <td>${appointment.email}</td>
                            <td>${appointment.tel}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                
            </table>
            <c:if test="${appointment==null}">
            <div class="centered">
                <p> No Appointments Scheduled </p>
                <p> <button><a href="../jsp/appointment.jsp">Create</a></button></p>
            </div>
            </c:if>>
        </div>
        <section class="data">
            <h3>Enter the new data for your child here</h3>
            <form action="" method="post">
                <label for="headCircum">Head Circumference</label>
                <input type="text" id="headCircum" name="headCircum" placeholder="enter head circumference">
                <label for="weight">Weight</label>
                <input type="text" id="weight" name="weight" placeholder="enter weight">
                <label for="height">Height</label>
                <input type="text" id="height" name="height" placeholder="enter height">
                <input type="submit" value="Submit" id="Submit">
            </form>
        </section>
    </div>
</body>

</html>