
package model;

import java.util.Date;

public class GrowthData {
    private int growthdataId;
    private int childId;
    private Date doneat;
    private double height;
    private double weight;
    private double headCircum;

    public GrowthData(int growthdataId, int childId, Date doneat, double height,
            double weight, double headCircum) {
        this.growthdataId = growthdataId;
        this.childId = childId;
        this.doneat = doneat;
        this.height = height;
        this.weight = weight;
        this.headCircum = headCircum;
    }

    // Constructors, getters, and setters

    public int getGrowthdataId() {
        return growthdataId;
    }

    public void setGrowthdataId(int growthdataId) {
        this.growthdataId = growthdataId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public Date getDoneat() {
        return doneat;
    }

    public void setDoneat(Date doneat) {
        this.doneat = doneat;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeadCircum() {
        return headCircum;
    }

    public void setHeadCircum(double headCircum) {
        this.headCircum = headCircum;
    }
}

