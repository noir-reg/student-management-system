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
public class StudentManager {

    SubjectList subList;
    StudentList stList;
    TranscriptList trList;

    public StudentManager() {
        subList = new SubjectList();
        stList = new StudentList();
        trList = new TranscriptList();
    }

    public void addSubject() {
        String subID;
        int pos;
        do {
            subID = Utils.getString("Subject ID: ").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos >= 0) {
                System.out.println("ID is duplicated!");
            }

        } while (pos >= 0);
        String name = Utils.getString("Subject name: ");
        int credit = Utils.getInt("Credit: ", 1, 10);
        subList.add(new Subject(subID, name, credit));
        System.out.println("A subject was added");
        System.out.println(subList.toString());
        boolean confirm = Utils.confirmYesNo("Do you want to add more ?(Y/N) ");
        if (confirm) {
            addSubject();
        }

    }

    public void updateSubject() {
        String subID = Utils.getString("Subject ID: ").toUpperCase();
        int pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Subject doesn't exist");
        } else {
            String name = Utils.getString("Subject name: ", subList.get(pos).getSubName());
            int credit = Utils.getInt("Credit: ", 1, 10, subList.get(pos).getCredit());
            subList.set(pos, new Subject(subID, name, credit));
            System.out.println("Update successfully");
            System.out.println(subList.toString());
        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N) ");
        if (!confirm) {
            updateSubject();
        }
    }

    public void deleteSubject() {
        String subID;
        subID = Utils.getString("Subject ID will be removed: ").toUpperCase();
        if (trList.containsSubject(subID)) {
            System.out.println("Deployed, can not be removed");
        } else {
            int pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Subject doesn't exist");
            } else {
                boolean confirm = Utils.confirmYesNo("Do you want to delete ?(Y/N) ");
                if (confirm) {
                    subList.remove(pos);
                    System.out.println("A subject was deleted");
                    System.out.println(subList.toString());
                }
            }

        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N) ");
        if (!confirm) {
            deleteSubject();
        }

    }

    public void addStudent() {
        String stID;
        int pos;
        do {
            stID = Utils.getString("Student ID: ").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos >= 0) {
                System.out.println("ID is duplicated!");
            }

        } while (pos >= 0);
        String fName = Utils.getString("Firt name: ");
        String lName = Utils.getString("Last name: ");
        boolean gender = Utils.confirmYesNo("Male ?(Y/N) ");
        Date bDate = Utils.inputDate("Date of birth: ");
        String email = Utils.getPhoneOrEmail("Email: ", ".+@.+[.].+");
        String phone = Utils.getPhoneOrEmail("Phone number: ", "[\\d]{10,12}");
        stList.add(new Student(stID, fName, lName, gender, bDate, email, phone));
        System.out.println("A student was added");
        System.out.println(stList.toString());
        boolean confirm = Utils.confirmYesNo("Do you want to add more ?(Y/N) ");
        if (confirm) {
            addStudent();
        }

    }

    public void updateStudent() {
        String stID = Utils.getString("Student ID: ").toUpperCase();
        int pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Student doesn't exist");
        } else {
            String fName = Utils.getString("Firt name: ", stList.get(pos).getFName());
            String lName = Utils.getString("Last name: ", stList.get(pos).getLName());
            boolean gender = Utils.confirmYesNo("Male ?(Y/N) ", stList.get(pos).isGender());
            Date bDate = Utils.updateDate(stList.get(pos).getBDate());
            String email = Utils.getPhoneOrEmail("Email: ", ".+@.+[.].+", stList.get(pos).getEmail());
            String phone = Utils.getPhoneOrEmail("Phone number: ", "[\\d]{10,12}", stList.get(pos).getPhone());
            stList.set(pos, new Student(stID, fName, lName, gender, bDate, email, phone));
            System.out.println("Update successfully");
            System.out.println(stList.toString());
        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N) ");
        if (!confirm) {
            updateStudent();
        }
    }

    public void deleteStudent() {
        String stID;
        stID = Utils.getString("Student ID will be removed: ").toUpperCase();
        if (trList.containsSubject(stID)) {
            System.out.println("Deployed, can not be removed");
        } else {
            int pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Student doesn't exist");
            } else {
                boolean confirm = Utils.confirmYesNo("Do you want to delete ?(Y/N)");
                if (confirm) {
                    stList.remove(pos);
                    System.out.println("A student was deleted");
                    System.out.println(stList.toString());
                }
            }

        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N) ");
        if (!confirm) {
            deleteStudent();
        }

    }

    public void addGrade() {
        String stID, subID;
        Student st = null;
        Subject sub = null;
        int pos;
        do {
            stID = Utils.getString("Student ID: ").toUpperCase();
            pos = stList.indexOf(new Student(stID));
            if (pos < 0) {
                System.out.println("Student doesn't exist");
            } else {
                st = stList.get(pos);
            }
        } while (pos < 0);
        do {
            subID = Utils.getString("Subject ID: ").toUpperCase();
            pos = subList.indexOf(new Subject(subID));
            if (pos < 0) {
                System.out.println("Subject doesn't exist");
            } else {
                sub = subList.get(pos);
            }
        } while (pos < 0);
        pos = trList.indexOf(new Transcript(sub, st));
        if (pos < 0) {
            double labMark = Utils.getDouble("Lab mark: ", 0, 10);
            double testMark = Utils.getDouble("Test mark: ", 0, 10);
            double finalMark = Utils.getDouble("Final mark: ", 0, 10);
            trList.add(new Transcript(sub, st, labMark, testMark, finalMark));
            System.out.println("Subject was graded successfully");
        } else {
            boolean check = Utils.confirmYesNo("Student has been graded this subject already. Do you want to overwrite it ?(Y/N) ");
            if (check) {
                double labMark = Utils.getDouble("Lab mark: ", 0, 10, trList.get(pos).getLabMark());
                double testMark = Utils.getDouble("Test mark: ", 0, 10, trList.get(pos).getTestMark());
                double finalMark = Utils.getDouble("Final mark: ", 0, 10, trList.get(pos).getFinalMark());
                trList.set(pos, new Transcript(sub, st, labMark, testMark, finalMark));
                System.out.println("Mark was overwriten successfully");
            }

        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the main menu ?(Y/N) ");
        if (!confirm) {
            addGrade();
        }
    }

    public void reportSubject() {
        String subID;
        int pos;

        subID = Utils.getString("Subject ID: ").toUpperCase();
        pos = subList.indexOf(new Subject(subID));
        if (pos < 0) {
            System.out.println("Subject doesn't exist");
        } else {
            boolean check = trList.containsSubject(subID);
            if (check == false) {
                System.out.println("It is not deployed yet");
            } else {

                System.out.println("- Subject ID: " + subID);
                System.out.println("- Subject name: " + subList.get(pos).getSubName());
                System.out.println("| Student ID |  Student name  | Average mark |  Status  |");
                for (Transcript t : trList) {
                    if (t.getsObj().getSubID().equals(subID)) {
                        double ave = t.average();
                        String status;
                        if (ave >= 4) {
                            status = "Pass";
                        } else {
                            status = "Not Pass";
                        }
                        System.out.printf("   %S     %S %S      %.1f             %S\n", t.getStObj().getStID(), t.getStObj().getLName(), t.getStObj().getFName(), ave, status);
                    }

                }
            }

        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the main menu ?(Y/N) ");
        if (!confirm) {
            reportSubject();
        }

    }

    public void reportStudent() {
        String stID;
        int pos;
        int i=0;
        stID = Utils.getString("Student ID: ").toUpperCase();
        pos = stList.indexOf(new Student(stID));
        if (pos < 0) {
            System.out.println("Student doesn't exist");
        } else {
            boolean check = trList.containsStudent(stID);
            if (check == false) {
                System.out.println("Student is not graded yet");
            } else {

                System.out.println("- Student ID: " + stID);
                System.out.println("- Student name: " + stList.get(pos).getLName() + " " + stList.get(pos).getFName());
                System.out.println("| No |  Subject name  | Average mark |  Status  |");

                for (Transcript t : trList) {
                    
                    if (t.getStObj().getStID().equals(stID)) {
                        i++;
                        double ave = t.average();
                        String status;
                        if (ave >= 4) {
                            status = "Pass";
                        } else {
                            status = "Not Pass";
                        }
                        System.out.printf("  %d         %S              %.1f     %S\n", i, t.getsObj().getSubName(), ave, status);
                    }

                }
            }

        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the main menu ?(Y/N) ");
        if (!confirm) {
            reportStudent();
        }

    }
}
