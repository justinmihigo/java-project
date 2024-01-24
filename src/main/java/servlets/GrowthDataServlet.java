
package servlets;

import dao.GrowthDataDao;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GrowthDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve data from the form
            
            int childId = Integer.parseInt(request.getParameter("childId"));
            int age=Integer.parseInt(request.getParameter("age"));
            String headCircum = request.getParameter("headCircum");
            String weight = request.getParameter("weight");
            String height = request.getParameter("height");
            
            
            GrowthDataDao growthDataDao = new GrowthDataDao();
            boolean success = growthDataDao.addGrowthData(childId, headCircum, weight, height,age);
            
            if (success) {
                double bmi = calculateBMI(weight, height);
                growthDataDao.updateGrowthData((float) bmi, childId);
                // Pass the calculated BMI to the JavaScript
                request.setAttribute("bmi", bmi);
                request.setAttribute("weight",weight);
                request.setAttribute("height", height);
                request.setAttribute("headCircum",headCircum);
                // Forward to the growthData.jsp
                RequestDispatcher dispatcher = request.getRequestDispatcher("../Pediatric/dashboard/dash.jsp");
                dispatcher.forward(request, response);
            } else {
                // Handle the case where the data couldn't be added to the database
                response.getWriter().println("Failed to add growth data.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrowthDataServlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    // You need to implement a method to calculate BMI based on weight and height
    private float calculateBMI(String weight, String height) {
        float w=Integer.parseInt(weight);
        float h=Integer.parseInt(height);
        float g=h/100;
        float bmi;
        bmi=(w/(g*g));
        return bmi;
    }
    
}
