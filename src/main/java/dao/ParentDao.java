
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import model.Child;
import model.Recommendation;

public class ParentDao {
   public boolean insertIntochild(String fname, String lname, int userId, String dob,String gender, String age) throws SQLException{
       try(Connection connection=DbConnection.connect()){
           String query="insert into children (fname,lname,parentId,dob,gender,age) values(?,?,?,?,?,?)";
           PreparedStatement pstmt=connection.prepareStatement(query);
           pstmt.setString(1, fname);
           pstmt.setString(2, lname);
           pstmt.setInt(3, userId);
           pstmt.setString(4,dob);
           pstmt.setString(5,gender);
           pstmt.setString(6,age);
           int rows=pstmt.executeUpdate();
          String triggerSql = "CREATE TRIGGER after_insert_child "
                + "AFTER INSERT ON children "
                + "FOR EACH ROW "
                + "BEGIN "
                + "    UPDATE parents "
                + "    SET childId = NEW.childId "
                + "    WHERE parentId = NEW.parentId; "
                + "END";

             PreparedStatement preparedStatement = connection.prepareStatement(triggerSql);

            // Execute the trigger creation SQL
            preparedStatement.execute();
            return rows>0;
       }
       
       
   }
   public boolean deleteChild(int childId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "DELETE FROM child WHERE childId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, childId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editChild(Child child) {
        try (Connection connection = DbConnection.connect()) {
            String query = "UPDATE child SET fname=?, lname=?, dob=?, age=?, gender=? WHERE childId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, child.getFname());
                preparedStatement.setString(2, child.getLname());
                preparedStatement.setDate(3, (java.sql.Date)(child.getDob()));
                preparedStatement.setInt(4, child.getAge());
                preparedStatement.setString(5, child.getGender());
                preparedStatement.setInt(6, child.getChildId());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Child> viewChildren(int parentId) {
        List<Child> children = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM child WHERE parentId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, parentId);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Child child = new Child(
                            rs.getInt("childId"),
                            rs.getString("fname"),
                            rs.getString("lname"),
                            rs.getDate("dob").toLocalDate(),
                            rs.getInt("age"),
                            rs.getString("gender"),
                            rs.getInt("parentId")
                    );
                    children.add(child);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    public boolean scheduleAppointment(Appointment appointment) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO Appointment (appointDate, childId, parentId, hospitalId, doctorId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setDate(1, java.sql.Date.valueOf(appointment.getAppointDate()));
                preparedStatement.setInt(2, appointment.getAppointmentId());
                preparedStatement.setInt(3, appointment.getId());
                preparedStatement.setInt(4, appointment.getId());
                preparedStatement.setInt(5, appointment.getId());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Appointment> viewAppointments(int parentId) {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM Appointment WHERE parentId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, parentId);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Appointment appointment;
                    appointment =
                            new Appointment(
                                    rs.getInt("appointmentId"),
                                    rs.getInt("parentId"),
//                                    rs.getInt("childId"),
                                    rs.getInt("hospitalId"),
                                    rs.getDate("appointDate"),
                                    rs.getInt("doctorId")
                            );
                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public List<Recommendation> viewRecommendations(int parentId) {
        List<Recommendation> recommendations = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM recommendations WHERE parentId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, parentId);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    Recommendation recommendation = new Recommendation(
                            rs.getInt("recommendId"),
                            rs.getInt("parentId"),
                            rs.getDate("doneat").toLocalDate(),
                            rs.getString("recommendtext")
                    );
                    recommendations.add(recommendation);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recommendations;
    }
}
