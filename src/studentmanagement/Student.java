/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Student implements Comparable<Object>{

    private String stID;
    private String fName;
    private String lName;
    private boolean gender;

    public SubjectList getSubjects() {
        return subjects;
    }

    public void setSubjects(SubjectList subjects) {
        this.subjects = subjects;
    }
    private Date bDate;
    private String email;
    private String phone;
    private SubjectList subjects;

    public Student() {
    }

    public Student(String stID, String fName, String lName, boolean gender, Date bDate, String email, String phone) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
    }

    public Student(String stID, String fName, String lName, boolean gender, Date bDate, String email, String phone, SubjectList subjects) {
        this.stID = stID;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.bDate = bDate;
        this.email = email;
        this.phone = phone;
        this.subjects = subjects;
    }

    public Student(String stID) {
        this.stID = stID;
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getbDate() {
        return bDate;
    }

    public void setbDate(Date bDate) {
        this.bDate = bDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" + "stID=" + stID + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", bDate=" + bDate + ", email=" + email + ", phone=" + phone + '}';
    }

    @Override
    public int compareTo(Object o) {
         return this.getfName().compareToIgnoreCase(((Student)o).getfName()); 
    }

}
