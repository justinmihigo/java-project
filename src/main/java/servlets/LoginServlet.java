package servlets;

import dao.AppointmentDao;
import model.Appointment;
import java.io.IOException;
import java.io.PrintWriter;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email.trim().equals("") || password.trim().equals("")) {
            out.println("<html><body><p>Empty fields!</p></body></html>");
            return;
        }

        UserDao userDao = new UserDao();
        ChildDao childDao = new ChildDao();
        boolean isAuthenticated = userDao.loginUser(email, password);
        int userId;
        int childId;
        String childName;
        int age;
        if (isAuthenticated) {
            out.println("Login successful!");
            try {
                userId = userDao.returnId(email, password);
                childId = childDao.getChildId(userId);
                childName = childDao.childName(childId);
                age = childDao.getChildAge(userId);
                List<String> type = userDao.getUsertype(email, password);
                HttpSession session = request.getSession();
                session.setAttribute("age", age);
                session.setAttribute("childName", childName);
                session.setAttribute("lname", type.get(1));
                session.setAttribute("userId", userId);
                session.setAttribute("childId", childId);
                userDao.updateParentId(userId);
                userDao.updateDoctorId(userId);
                

                String userType = type.get(0);
                switch (userType) {
                    case "parent":
                        RequestDispatcher rs = request.getRequestDispatcher(
                                "./dashboard/dash.jsp");
                        rs.forward(request, response);
                        break;
                    case "doctor":
                        rs = request.getRequestDispatcher(
                                "./dashboard/dashDoc.jsp");
                        rs.forward(request, response);
                        break;
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            AppointmentDao appointDao = new AppointmentDao();
                List<Appointment> appointment = appointDao.SelectAll();
                request.setAttribute("appointment", appointment);
        
                RequestDispatcher rs = request.getRequestDispatcher(
                        "./dashboard/dash.jsp");
                rs.forward(request, response);
        ////            response.sendRedirect("./dashboard/dash.jsp");
        }
        else {
            out.println(
                    "<html><body><p>Login failed. Please check your credentials and try again.</p></body></html>");
        }

        out.close();
    }
}
