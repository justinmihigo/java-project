package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

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
    public List<Appointment>SelectAll(){
        List<Appointment> appointments=new ArrayList<>();
         try (Connection connection = DbConnection.connect()) {
            String query = "SELECT appointment.appointmentId, appointment.appointDate,doctors.doctorId, doctors.fname,              doctors.email, doctors.tel from appointment, doctors where appointment.doctorId=doctors.doctorId";
            try (Statement stmt = connection.createStatement()) {
                ResultSet rs=stmt.executeQuery(query);
               while(rs.next()){
                   int appointmentId=rs.getInt(1);
                   String appointmentDate=rs.getString(2);
                   int id=rs.getInt(3);
                   String dfname=rs.getString(4);
                   String email=rs.getString(5);
                   String tel=rs.getString(6);
                   appointments.add(new Appointment(appointmentId,id,dfname,email,appointmentDate,tel));
               }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
         return appointments;
    }
    public boolean updateAppointment(int id,String appointDate) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="Update appointment set appointDate=? where appointmentid=?";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1, appointDate);
            pstmt.setInt(2,id);
            int row=pstmt.executeUpdate();
            return row>0;
        }
    }
    public boolean DeleteAppointment(int id) throws SQLException{
         try(Connection connection=DbConnection.connect()){
            String query="Delete *from appointment where appointmentId=?";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setInt(1, id);
            int rows=pstmt.executeUpdate();
            return rows>0;
}

}
}

