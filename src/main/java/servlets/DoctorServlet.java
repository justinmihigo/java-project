
package servlets;

import dao.DoctorDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Doctor;


public class DoctorServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    
     DoctorDao doctorDao=new DoctorDao();
     List<Doctor> doctor= doctorDao.getAllDoctors();
     request.setAttribute("doctor", doctor);
     RequestDispatcher ds=request.getRequestDispatcher("../Pediatric/jsp/doctorList.jsp");
     ds.forward(request, response);
    }
}


