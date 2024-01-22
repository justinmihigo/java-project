
package dao;
import model.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class HospitalDao{
    // Create
    public boolean addHospital(Hospital hospital) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO hospital (hospitalName, address, email) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, hospital.getHospitalName());
                preparedStatement.setString(2, hospital.getAddress());
                preparedStatement.setString(3, hospital.getEmail());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read
    public Hospital getHospitalById(int hospitalId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM hospital WHERE hospitalId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, hospitalId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToHospital(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public List<Hospital> getAllHospitals() {
        List<Hospital> hospitals = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM hospital";
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        hospitals.add(mapResultSetToHospital(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospitals;
    }

    // Update
    public boolean updateHospital(Hospital hospital) {
        try (Connection connection = DbConnection.connect()) {
            String query = "UPDATE hospital SET hospitalName=?, address=?, email=? WHERE hospitalId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, hospital.getHospitalName());
                preparedStatement.setString(2, hospital.getAddress());
                preparedStatement.setString(3, hospital.getEmail());
                preparedStatement.setInt(4, hospital.getHospitalId());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteHospital(int hospitalId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "DELETE FROM hospital WHERE hospitalId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, hospitalId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Hospital mapResultSetToHospital(ResultSet resultSet) throws SQLException {
        return new Hospital(
            resultSet.getInt("hospitalId"),
            resultSet.getString("hospitalName"),
            resultSet.getString("address"),
            resultSet.getString("email")
        );
    }
}


