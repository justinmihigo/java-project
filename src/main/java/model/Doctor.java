
package model;
import java.util.Date;

public class Doctor {
    private int doctorId;
    private String fname;
    private String lname;
    private String specialization;
    private int hospitalId;
    private String hospitalName;
    private Date dob;
    private String gender;
    private String email;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Constructors, getters, and setters

    public Doctor(int doctorId, String fname, String lname,
            String specialization, int hospitalId, String hospitalName, Date dob,
            String gender, String email) {
        this.doctorId = doctorId;
        this.fname = fname;
        this.lname = lname;
        this.specialization = specialization;
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
    }
}

