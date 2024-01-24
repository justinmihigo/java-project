
package dao;
import dao.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ChartData;
public class GrowthDataDao{
    public boolean addGrowthData(int id, String headCircum, String weight, String height, int age) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="Insert into growthdata(headCircum,weight,height,childId, age) values(?,?,?,?,?)";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setString(1, headCircum);
            pstmt.setString(2, weight);
            pstmt.setString(3, height);
            pstmt.setInt(4, id);
            pstmt.setInt(5,age);
            int row =pstmt.executeUpdate();
            return row>0;
        }
    }
    public List<ChartData> getChartData(int childId, String parameter) throws SQLException {
        List<ChartData> chartDataList = new ArrayList<>();
        String query = "SELECT age, " + parameter + " FROM growthdata WHERE childId = ? ORDER BY age";

        try (Connection connection = DbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, childId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                List<Integer> timePoints = new ArrayList<>();
                List<Integer> values = new ArrayList<>();

                while (resultSet.next()) {
                    timePoints.add(resultSet.getInt("age"));
                    values.add(resultSet.getInt(parameter));
                }

                chartDataList.add(new ChartData(timePoints, values));
            }
        }

        return chartDataList;
    }
    public boolean updateGrowthData(float bmi, int childId) throws SQLException{
        try(Connection connection=DbConnection.connect()){
            String query="update growthdata set bmi=? where childId=?";
            PreparedStatement pstmt=connection.prepareStatement(query);
            pstmt.setFloat(1, bmi);
            pstmt.setInt(2, childId);
            
            int row =pstmt.executeUpdate();
            return row>0;
        }
    }
}
