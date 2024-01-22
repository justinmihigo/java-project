import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddRecommendationServlet")
public class AddRecommendationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve data from the form
        String recommendText = request.getParameter("recommendText");
        int parentId = Integer.parseInt(request.getParameter("parentId"));

        // You should perform validation and error handling here before interacting with the database

        // Replace the following lines with your actual database interaction code
        boolean isRecommendationAdded = addRecommendationToDatabase(recommendText, parentId);

        if (isRecommendationAdded) {
            out.println("<html><body><p>Recommendation given successfully!</p></body></html>");
        } else {
            out.println("<html><body><p>Failed to give recommendation. Please try again.</p></body></html>");
        }

        out.close();
    }

    // Replace this method with your actual database interaction logic
    private boolean addRecommendationToDatabase(String recommendText, int parentId) {
        try{
            Connection connection = DbConnection.connect();
            String query = "INSERT INTO recommendations (parentId, doneat, recommendtext) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, parentId);
                preparedStatement.setString(2, getCurrentDate());
                preparedStatement.setString(3, recommendText);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Utility method to get the current date
    private String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }
}