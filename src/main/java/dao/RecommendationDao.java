package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Recommendation;

public class RecommendationDao {

    public boolean addRecommendation(Recommendation recommendation) {
        try (Connection connection = DbConnection.connect()) {
            String query = "INSERT INTO recommendations (parentId, doneat, recommendtext) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, recommendation.getId());
                preparedStatement.setDate(2, (java.sql.Date)(recommendation.getDoneat()));
                preparedStatement.setString(3, recommendation.getRecommendText());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Recommendation> getAllRecommendations() {
        List<Recommendation> recommendations = new ArrayList<>();
        try (Connection connection = DbConnection.connect()) {
            String query = "SELECT * FROM recommendations";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
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

    public boolean updateRecommendation(Recommendation recommendation) {
        try (Connection connection = DbConnection.connect()) {
            String query = "UPDATE recommendations SET parentId=?, doneat=?, recommendtext=? WHERE recommendId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, recommendation.getId());
                preparedStatement.setDate(2, (java.sql.Date)(recommendation.getDoneat()));
                preparedStatement.setString(3, recommendation.getRecommendText());
                preparedStatement.setInt(4, recommendation.getId());

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteRecommendation(int recommendId) {
        try (Connection connection = DbConnection.connect()) {
            String query = "DELETE FROM recommendations WHERE recommendId=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, recommendId);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
