import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
        boolean isAuthenticated = userDao.loginUser(email, password);

        if (isAuthenticated) {
            out.println("<html><body><p>Login successful!</p></body></html>");
        } else {
            out.println("<html><body><p>Login failed. Please check your credentials and try again.</p></body></html>");
        }

        out.close();
    }
}
