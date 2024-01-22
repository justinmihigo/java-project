
package model;
public class User {
    private int userId;
    private String fname;
    private String lname;
    private String dob;
    private String tel;
    private String email;
    private String password;
    private String gender;

    public User(int userId, String fname, String lname, String dob, String tel,
            String email, String password, String gender) {
        this.userId = userId;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.gender = gender;
    }

    // Constructors, getters, and setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

