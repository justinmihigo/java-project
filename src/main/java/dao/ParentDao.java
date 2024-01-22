
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
           return rows>0;
       }
       catch(Exception e){
           System.out.println(e);
       }
       return false;
   }
}
