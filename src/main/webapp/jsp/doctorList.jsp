
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.DoctorDao" %>
<%@page import="model.Doctor" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Mihigo Justin">
        <title>GrowthPulseTrack</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" />
        <link rel="stylesheet" href="/Pediatric/dashboard/dash.css" type="text/css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="shortcut icon" href="./my web/icon48.png" type="image/x-icon">
        <style>
            *{
                color: white;
            }
            
        </style>
    </head>

    <body>
        <div class="appointments" id="appointments">
            <h2>Doctors</h2>
            <%
             DoctorDao doctorDao=new DoctorDao();
List<Doctor> doctorList= doctorDao.getAllDoctors();

            %>
            <table width="80%" cellspacing="20">
                <thead>
                    <tr>
                        <th>DoctorId</th>
                        <th>First name</th>
                        <th>Last Name</th>
                        <th>Specialization</th>
                        <th>Date of birth</th>
                        <th>gender</th>
                        <th>email</th>
                    </tr>
                </thead>

                <tbody>
             
                    <% for (Doctor doctor : doctorList) { %>
                        <tr>
                            <td><%= doctor.getDoctorId() %></td>
                            <td><%= doctor.getFname() %></td>
                            <td><%= doctor.getLname() %></td>
                            <td><%= doctor.getSpecialization() %></td>
                            <td><%= doctor.getDob() %></td>
                            <td><%= doctor.getGender() %></td>
                            <td><%= doctor.getEmail() %></td>
                        </tr>
                    <% } %>
                </tbody>

            </table>
    </body>
</html>
