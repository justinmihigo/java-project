import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public boolean registerUser(String fname, String lname, String dob, String tel, String email, String password, String gender) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO users (fname, lname, dob, tel, email, password, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, fname);
                preparedStatement.setString(2, lname);
                preparedStatement.setString(3, dob);
                preparedStatement.setString(4, tel);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, gender);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Function to validate user login
    public boolean loginUser(String email, String password) {
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // If there is a matching user, return true
                }
            }
        } catch (SQLException e) {
        }
        return false;
    }
}
