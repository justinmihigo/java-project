package servlets;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddAppointment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve data from the form
        String appointDate = request.getParameter("appointDate");
        int childId = Integer.parseInt(request.getParameter("childId"));
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        // You should perform validation and error handling here before interacting with the database

        AppointmentDao appointmentDao = new AppointmentDao(); // Assuming AppointmentDao is your Data Access Object class
        boolean isAppointmentAdded = appointmentDao.addAppointment(appointDate, childId, parentId, hospitalId, doctorId);
        if (isAppointmentAdded) {
            out.println("<html><body><p>Appointment added successfully!</p></body></html>");
        } else {
            out.println("<html><body><p>Failed to add appointment. Please try again.</p></body></html>");
        }

        out.close();
    }
}