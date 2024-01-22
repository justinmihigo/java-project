
package model;
public class Vaccination {
    private int vaccineId;
    private int childId;
    private String vaccineName;

    public Vaccination(int vaccineId, int childId, String vaccineName) {
        this.vaccineId = vaccineId;
        this.childId = childId;
        this.vaccineName = vaccineName;
    }

    // Constructors, getters, and setters

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
}

