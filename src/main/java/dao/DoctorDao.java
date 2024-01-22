
package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Doctor;

public class DoctorDao {

    public boolean addDoctor(Doctor doctor) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO doctors (fname, lname, specialization, hospitalId, hospitalName, dob, gender, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, doctor.getFname());
                preparedStatement.setString(2, doctor.getLname());
                preparedStatement.setString(3, doctor.getSpecialization());
                preparedStatement.setInt(4, doctor.getHospitalId());
                preparedStatement.setString(5, doctor.getHospitalName());
                preparedStatement.setDate(6, (Date) (doctor.getDob()));
                preparedStatement.setString(7, doctor.getGender());
                preparedStatement.setString(8, doctor.getEmail());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM doctors";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Doctor doctor = new Doctor(
                            rs.getInt("doctorId"),
                            rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getString("specialization"),
                            rs.getInt("hospitalId"),
                            rs.getString("hospitalName"),
                            rs.getDate("dob"),
                            rs.getString("gender"),
                            rs.getString("email")
                    );
                    doctors.add(doctor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    // Add other CRUD operations (update, delete) as needed
}

