<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
        <script  src="/Pediatric/dashboard/dash.js" defer></script>
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
                <h2>${childName}'s Parent Dashboard (${lname}) </h2>
                <div>
                    <c:if test="${childName}==null">
                        <button><a href="/Pediatric/jsp/profileParent.jsp">Add Child</a></button>
                    </c:if>
                </div>
                <div>
                    <a href="../Pediatric/jsp/doctorList.jsp" class="color">View available doctors</a>
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
                </section>                

                <section class="recommendations" id="recommendations">
                    <h2 class="center">Recommendations</h2>
                    <div class="cards">
                        
                            <% 
                   // Fetch recommendations from the database
                   try {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/growthpulse", "root", "");
                       Statement statement = connection.createStatement();
                       ResultSet resultSet = statement.executeQuery("SELECT * FROM recommendations");

                       while (resultSet.next()) {
                           String recommendId = resultSet.getString("recommendId");
                           String parentId = resultSet.getString("parentId");
                           String doneat = resultSet.getString("doneat");
                           String recommendtext = resultSet.getString("recommendtext");
                            %>
                            <div class="card1">
                                <h4>Recommendation ID: <%= recommendId %></h4>
                                <p>Parent ID: <%= parentId %></p>
                                <p>Done at: <%= doneat %></p>
                                <p><%= recommendtext %></p>
                            </div>
                            <%
                                    }
                                    resultSet.close();
                                    statement.close();
                                    connection.close();
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            %>
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
                <p> <button><a href="/Pediatric/jsp/appointment.jsp">Create</a></button></p>
                <c:forEach var="appointment" items="${appointment}">

                    <tr>
                        <td>${appointment.appointmentId}</td>
                        <td>${appointment.appointDate}</td>
                        <td>${appointment.fname}</td>
                        <td>${appointment.email}</td>
                        <td>${appointment.tel}</td>
                        <td><a href="#">Edit</a>&nbsp;<a href="#">Delete</a></td>
                    </tr>

                </c:forEach>
                <c:if test="${appointment}==null">
                    <p>No scheduled appointments</p>
                </c:if>
                </tbody>

            </table>
            <c:if test="${appointment==null}">
                <div class="centered">
                    <p> No Appointments Scheduled </p>
                    <p> <button><a href="../jsp/appointment.jsp">Create</a></button></p>
                </div>
            </c:if>
        </div>
        <section class="data">
            <a href="/Pediatric/jsp/growthData.jsp" class="color">Update the child's Metrics</a>
        </section>
    </div>
</body>

</html>