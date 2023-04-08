/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import tools.Utils;

/**
 *
 * @author Admin
 */
public class Student implements Comparable {

    private String stID;
    private String fName;
    private String lName;
    private boolean gender;
    private Date bDate;
    private String email;
    private String phone;

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

    public Student(String stID) {
        this.stID = stID;
    }

    public String getStID() {
        return stID;
    }

    public void setStID(String stID) {
        this.stID = stID;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBDate() {
        return bDate;
    }

    public void setBDate(Date bDate) {
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
        return "ID: " + stID + ", Name: " + lName + " " + fName + ", Gender: " +Utils.strGender(gender)+ ", Birthdate: " + Utils.strDMY(bDate) + ", Email: " + email + ", Phone: " + phone ;
    }

    @Override
    public boolean equals(Object obj) {
        return stID.equals(((Student) obj).stID);
    }

    @Override
    public int compareTo(Object obj) {
        return this.getFName().compareToIgnoreCase(((Student) obj).getFName());
    }
}
