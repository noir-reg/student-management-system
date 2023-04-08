/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentList extends HashMap<String, Student> {

    public boolean search(String id) {
        boolean check = false;
        if (this.containsKey(id) == true) {
            check = true;
        }
        return check;
    }

    public void add() {
        try {

            String id = Utils.getString("Enter student id to check existence: ");
            if (search(id)) {
                System.out.println("ID has exist!");

            } else {
                String stID = Utils.getString("Enter student id: ");
                String fName = Utils.getString("Enter first name: ");
                String lName = Utils.getString("Enter last name: ");
                boolean gender = Utils.confirmYesNo("Male ? (Y/N): ");
                Date bDate = Utils.inputDate("Enter date of birth: ");
                String email = Utils.getPhoneOrEmail("Enter email: ", ".+@.+[.].+");
                String phone = Utils.getPhoneOrEmail("Enter phone number: ", "[\\d]{10,12}");
                this.put(id, new Student(stID, fName, lName, gender, bDate, email, phone));

            }
            boolean check = Utils.confirmYesNo("Do you want to add more ?(Y/N)");
            if (check) {
                add();
            }

        } catch (Exception e) {

        }

    }

    public void update() {
        String id = Utils.getString("Enter student id to check existence: ");
        if (!search(id)) {
            System.out.println("Student does not exist!");

        } else {

            boolean check = false;
            do {
                System.out.println("1. Update a student");
                System.out.println("2. Delete a student");
                System.out.println("3. Back to main menu");
                int choice = Utils.getInt("Choose (1-3) ", 1, 3);
                switch (choice) {
                    case 1:
                        updateStudent(id);
                        break;
                    case 2:
                        deleteStudent(id);
                        break;
                    case 3:
                        check = Utils.confirmYesNo("(Y/N)");
                        break;

                }

            } while (!check);

        }
    }

    public void updateStudent(String id) {

        String fName = Utils.getString("Update first name: ", get(id).getfName());
        String lName = Utils.getString("Update last name: ", get(id).getlName());
        boolean gender = Utils.confirmYesNo("Male ? (Y/N): ", get(id).isGender());
        Date bDate = Utils.updateDate(get(id).getbDate());
        String email = Utils.getPhoneOrEmail("Update email: ", ".+@.+[.].+", get(id).getEmail());
        String phone = Utils.getPhoneOrEmail("Update phone number: ", "[\\d]{10,12}", get(id).getPhone());
        put(id, new Student(id, fName, lName, gender, bDate, email, phone));
        System.out.println("Update successfully");
        boolean check = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N) ");
        if (!check) {
            String checkId = Utils.getString("Enter student id to check existence: ");
            if (!search(checkId)) {
                System.out.println("Student does not exist!");

            } else {
                updateStudent(checkId);
            }

        }

    }

    public void deleteStudent(String id) {
        boolean check = Utils.confirmYesNo("Do you want to delete (Y/N) ");
        if (check) {
            this.remove(id);
            System.out.println("Delete successfully");
        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu (Y/N) ");
        if (!confirm) {
            String checkId = Utils.getString("Enter student id to check existence: ");
            if (!search(checkId)) {
                System.out.println("Student does not exist!");

            } else {
                deleteStudent(checkId);
            }

        }

    }

    public void showInfor() {
        for (String element : this.keySet()) {
            System.out.println(get(element).toString());
        }
    }

    public void sort() {
        List<Student> list = new ArrayList<>(this.values());
        Collections.sort(list);

    }

    public void enterGrade() {
        String id = Utils.getString("Enter student id to check existence: ");
        if (!search(id)) {
            System.out.println("Student does not exist!");

        } else {
            String suId = Utils.getString("Enter subject id to check existence: ");
            if (!get(id).getSubjects().search(suId)) {
                System.out.println("Subject does not exist!");
            } else {
                System.out.println("Subject exists!");
                
            }
        }
    }   
    
}
