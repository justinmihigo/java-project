package model;

import java.time.LocalDate;
import java.util.Date;

public class Recommendation {
    int id;
    Date doneat;
    String RecommendText;

    public Recommendation(int aInt, int aInt0, LocalDate toLocalDate,
            String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDoneat() {
        return doneat;
    }

    public void setDoneat(Date doneat) {
        this.doneat = doneat;
    }

    public String getRecommendText() {
        return RecommendText;
    }

    public void setRecommendText(String RecommendText) {
        this.RecommendText = RecommendText;
    }

    public Recommendation(int id, Date doneat, String RecommendText) {
        this.id = id;
        this.doneat = doneat;
        this.RecommendText = RecommendText;
    }

}