import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppointmentDao {

    public boolean addAppointment(String appointDate, int childId, int parentId, int hospitalId, int doctorId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO appointment (appointDate, childId, parentId, hospitalId, doctorId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, appointDate);
                preparedStatement.setInt(2, childId);
                preparedStatement.setInt(3, parentId);
                preparedStatement.setInt(4, hospitalId);
                preparedStatement.setInt(5, doctorId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
