package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {

    public boolean registerUser(String fname, String lname, String dob, String tel, String email, String password, String gender, String accType) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO users (fname, lname, dob, tel, email, password, gender,type) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, fname);
                preparedStatement.setString(2, lname);
                preparedStatement.setString(3, dob);
                preparedStatement.setString(4, tel);
                preparedStatement.setString(5, email);
                preparedStatement.setString(6, password);
                preparedStatement.setString(7, gender);
                preparedStatement.setString(8, accType);

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
    public int returnId(String email, String password) throws SQLException {
        
        try (Connection connection = DbConnection.connect()) {
            int userId;
            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while(resultSet.next()){
                    userId=resultSet.getInt("userId"); 
                    return userId;
                }
                    
            }
        } catch (SQLException e) {
        }
        return 0;
        
    }
    }
    public void insertIntoParents(String fname, String lname, String dob, String tel, String email, String gender) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="insert into parents (fname,lname,dob,tel,email,gender) values(?,?,?,?,?,?)";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,fname );
            pstmt.setString(2,lname );
            pstmt.setString(3,dob );
            pstmt.setString(4, tel);
            pstmt.setString(5,email );
            pstmt.setString(6,gender );
            pstmt.executeUpdate();  
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void insertIntoDoctors(String fname, String lname, String dob, String tel, String email, String gender) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="insert into doctors (fname,lname,dob,tel,email,gender) values(?,?,?,?,?,?)";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,fname );
            pstmt.setString(2,lname );
            pstmt.setString(3,dob );
            pstmt.setString(4, tel);
            pstmt.setString(5,email );
            pstmt.setString(6,gender );
            pstmt.executeUpdate();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
public void insertIntoLocal(String fname, String lname, String dob, String tel, String email, String gender) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="insert into localconsultant (fname,lname,dob,tel,email,gender) values(?,?,?,?,?,?)";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1,fname );
            pstmt.setString(2,lname );
            pstmt.setString(3,dob );
            pstmt.setString(4, tel);
            pstmt.setString(5,email );
            pstmt.setString(6,gender );
            pstmt.executeUpdate();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
public boolean checkChild() throws SQLException{
    String query="Select * from children";
    try(Connection connection= DbConnection.connect()){
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        if(rs.next()){
            int count=rs.getInt("childId");
            return count>0;
        }
            return false;
        }
    }
}



    
