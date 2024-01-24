
package model;
import java.time.LocalDate;
import java.util.Date;

public class Child {
    private int childId;
    private String fname;
    private String lname;
    private Date dob;
    private int age;
    private String gender;
    private int parentId;
    public Child(String fname, String lname, Date dob, int age,
            String gender) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.age = age;
        this.gender = gender;
    }

    public Child() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Child(int aInt, String string, String string0, LocalDate toLocalDate,
            int aInt0, String string1, int aInt1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    // Constructors, getters, and setters
}

