/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

/**
 *
 * @author Admin
 */
public class Subject implements Comparable {

    private String subID;
    private String subName;
    private int credit;
     StudentList students;
     Transcript transObj;

    public Subject() {
    }

    public Subject(String subID, String subName, int credit) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
    }

    public Subject(String subID, String subName, int credit, StudentList students) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
        this.students = students;
    }

    public Subject(String subID, String subName, int credit, StudentList students, Transcript transObj) {
        this.subID = subID;
        this.subName = subName;
        this.credit = credit;
        this.students = students;
        this.transObj = transObj;
    }

    public Subject(String subID) {
        this.subID = subID;
    }

    public String getSubID() {
        return subID;
    }

    public void setSubID(String subID) {
        this.subID = subID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }


    @Override
    public int compareTo(Object o) {
         return this.getSubName().compareToIgnoreCase(((Subject)o).getSubName());
    }

}
