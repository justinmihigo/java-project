
package servlets;
import dao.ParentDao;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;

public class parents extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String fname=request.getParameter("fname");
            String lname=request.getParameter("lname");
            String dob=request.getParameter("dob");
            String age=request.getParameter("age");
            String gender=request.getParameter("gender");
            HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("userId");
            ParentDao parentDao=new ParentDao();
        try {
            parentDao.insertIntochild(fname, lname,userId, dob, gender,age);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    }

   

