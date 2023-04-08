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
public class Main {

    public static void main(String[] args) {
        StudentList list = new StudentList();
        SubjectList slist=new SubjectList ();
        Student st = new Student();
        TranscriptList tra =new TranscriptList();
        list.add();
        slist.add();
        list.enterGrade();
        
        
       //list.showInfor();
      
//        list.update();
//        list.showInfor();
    }

}
