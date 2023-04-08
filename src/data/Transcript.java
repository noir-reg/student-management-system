/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Admin
 */
public class Transcript {

    private Subject sObj;
    private Student stObj;
    private double labMark;
    private double testMark;
    private double finalMark;

    public Transcript() {
    }

    public Transcript(Subject sObj, Student stObj, double labMark, double testMark, double finalMark) {
        this.sObj = sObj;
        this.stObj = stObj;
        this.labMark = labMark;
        this.testMark = testMark;
        this.finalMark = finalMark;
    }


    public Subject getsObj() {
        return sObj;
    }

    public void setsObj(Subject sObj) {
        this.sObj = sObj;
    }

    public Student getStObj() {
        return stObj;
    }

    public void setStObj(Student stObj) {
        this.stObj = stObj;
    }

    public double getLabMark() {
        return labMark;
    }

    public void setLabMark(double labMark) {
        this.labMark = labMark;
    }

    public double getTestMark() {
        return testMark;
    }

    public void setTestMark(double testMark) {
        this.testMark = testMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double average() {
        double aveMark = (labMark * 0.3) + (testMark * 0.3) + (finalMark * 0.4);
        return aveMark;

    }

  

    public Transcript(Subject sObj, Student stObj) {
        this.sObj = sObj;
        this.stObj = stObj;
    }

    @Override
    public boolean equals(Object obj) {
        Transcript t = (Transcript)obj;
        return this.stObj==t.stObj&&this.sObj==t.sObj;
    }


}
