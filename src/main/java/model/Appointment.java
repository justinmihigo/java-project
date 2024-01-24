package model;

import java.sql.Date;


public class Appointment {
    private int appointmentId;
    private int id;
    private String fname;
    private String email;
    private String appointDate;
    private String tel;
    public Appointment(int appointmentId, int id, String fname, String email,
            String appointDate, String tel) {
        this.appointmentId = appointmentId;
        this.id = id;
        this.fname = fname;
        this.email = email;
        this.appointDate = appointDate;
        this.tel = tel;
    }

    public Appointment(int aInt, int aInt0, int aInt1, Date date, int aInt2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
