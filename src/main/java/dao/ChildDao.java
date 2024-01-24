package dao;
import model.Child;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
public class ChildDao{
    // Create
    public boolean addChild(Child child) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO hospital (fname, lname, dob,age,gender) VALUES (?, ?, ?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, child.getFname());
                preparedStatement.setString(2, child.getLname());
                preparedStatement.setDate(3, (Date)child.getDob());
                preparedStatement.setInt(4, child.getAge());
                preparedStatement.setString(5, child.getGender());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Read
    public Child getChildById(int childId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM children WHERE childId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, childId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return mapResultSetToChild(resultSet);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public int getChildId(int Id) throws SQLException{
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT childId FROM children WHERE parentId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int childId=rs.getInt("childId");
                    return childId;
            }
        } 
       
    }
        return 0;
    }
    public String childName(int Id) throws SQLException{
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT fname FROM children WHERE childId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    String childName=rs.getString("fname");
                    return childName;
            }
        } 
    }
        return "";
    }
    public int getChildAge(int Id) throws SQLException{
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT age FROM children WHERE parentId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id);
                ResultSet rs=preparedStatement.executeQuery();
                while(rs.next()){
                    int age=rs.getInt("age");
                    return age;
            }
        } 
       
    }
        return 0;
    }
    public List<Child> getAllChildren() {
        List<Child> children = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM children";
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        children.add(mapResultSetToChild(rs));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return children;
    }
   

    // Update
    public boolean updateHospital(Child child) {
        try (Connection connection = DbConnection.connect()) {
            String query = "UPDATE children SET fname=?, lname=?,gender=?, age=? WHERE childId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, child.getFname());
                preparedStatement.setString(2, child.getLname());
                preparedStatement.setInt(3, child.getAge());
                preparedStatement.setString(4, child.getGender());
                preparedStatement.setInt(5, child.getChildId());
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete
    public boolean deleteChild(int childId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "DELETE FROM children WHERE childId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, childId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Child mapResultSetToChild(ResultSet resultSet) throws SQLException {
        return new Child(
            resultSet.getString("fname"),
            resultSet.getString("lname"),
            resultSet.getDate("dob"),
            resultSet.getInt("age"),
            resultSet.getString("gender")
            
        );
    }
}