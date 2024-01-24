package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String dob = request.getParameter("dob");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String passwordRepeat = request.getParameter("passwordRepeat");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String accType = request.getParameter("person");
        String specialization=request.getParameter("specialization");
        if (fname.trim().equals("")) {
            out.println("<html><body><p>Empty fields!</p></body></html>");
            return;
        }
        if (!password.equals(passwordRepeat)) {
            out.println(
                    "<html><body><p>Passwords do not matches!</p></body></html>");
            return;
        }

        UserDao userDao = new UserDao();
        boolean isUserRegistered = userDao.registerUser(fname, lname, dob, tel,
                email, password, gender, accType);

        if (isUserRegistered) {
            switch (accType) {
                case "doctor":
                    try {
                        userDao.insertIntoDoctors(fname, lname, dob, tel, email,
                                gender,specialization);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }   break;
                case "parent":
                    try {
                        userDao.insertIntoParents(fname, lname, dob, tel, email,
                                gender);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }   break;
                default:
                    try {
                        userDao.insertIntoLocal(fname, lname, dob, tel, email,
                                gender);
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }   break;
            }

            String rPath = "/Pediatric/jsp/login.jsp";
            response.sendRedirect(rPath);
            out.println(
                    "<html><body><p>User registered successfully!</p></body></html>");
        } else {
            out.println(
                    "<html><body><p>Registration failed. Please try again.</p></body></html>");
        }

        out.close();
    }
}
