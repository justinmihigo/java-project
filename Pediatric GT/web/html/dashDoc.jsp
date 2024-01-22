<%-- 
    Document   : dashDoc
    Created on : Jan 22, 2024, 11:51:44 AM
    Author     : Programer DATCH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Mihigo Justin">
    <title>GrowthPulseTrack</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
    <link rel="stylesheet" href="./dashDoc.css" type="text/css">
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
                    <a href="#dashboard">Dashboard</a>
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
            <h2>Welcome to the Doctors's Dashboard</h2>
            <div>
                <a href="#">Complete profile</a>
            </div>

        </div>
        <div>
            <section id="reports">
                <h2 class="center">Reports</h2>
                <div class="cards" >
                    <div class="card1">
                        <canvas id="myLineChart"></canvas>
                    </div>
                    <div class="card1">
                        <h3>Appointments</h3>
                    </div>
                    <div class="card1">
                        <h3>Vaccines Issued</h3>
                    </div>
                </div>
            </section>
            <section class="recommendations" id="recommendations">
                <h2 class="center">Recommendations</h2>
                <div class="cards">
                    No recommendations given <button>Give</button>
                    <!-- Add new recommendation form -->
                    <form action="../AddRecommendationServlet" method="post">
                        
                        <label for="parentId">Parent ID:</label>
                        <input type="number" id="parentId" name="parentId" required><br>
            
                        <label for="recommendText">Recommendation Text:</label>
                        <textarea id="recommendText" name="recommendText" rows="4" cols="50" required></textarea><br>
                        <input type="submit" value="Give Recommendation">
                    </form>
                </div>
            </section>
        
            <div class="appointments" id="appointments">
    <h2>Appointments</h2>
    
    <div class="centered">
        <p>No Appointments Scheduled</p>
        <button>Create</button>
        <!-- Add new appointment form -->
        <form action="../AddAppointmentServlet" method="post">
            <label for="appointDate">Appointment Date:</label>
            <input type="date" id="appointDate" name="appointDate" required><br>

            <label for="childId">Child ID:</label>
            <input type="number" id="childId" name="childId" required><br>

            <label for="parentId">Parent ID:</label>
            <input type="number" id="parentId" name="parentId" required><br>

            <label for="hospitalId">Hospital ID:</label>
            <input type="number" id="hospitalId" name="hospitalId" required><br>

            <label for="doctorId">Doctor ID:</label>
            <input type="number" id="doctorId" name="doctorId" required><br>

            <!-- Add additional fields as needed -->

            <input type="submit" value="Create Appointment">
        </form>
    </div>
</div>
        
        </div>
    </div>
</body>

</html>