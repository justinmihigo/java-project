import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

        if(fname.trim().equals(""))
        {
            out.println("<html><body><p>Empty fields!</p></body></html>");
            return;
        }
        if(!password.equals(passwordRepeat))
        {
            out.println("<html><body><p>Passwords do not matches!</p></body></html>");
            return;
        }
        
        UserDao userDao = new UserDao();
        boolean isUserRegistered = userDao.registerUser(fname, lname, dob, tel, email, password, gender);

        if (isUserRegistered) {
            out.println("<html><body><p>User registered successfully!</p></body></html>");
        } else {
            out.println("<html><body><p>Registration failed. Please try again.</p></body></html>");
        }

        out.close();
    }
}