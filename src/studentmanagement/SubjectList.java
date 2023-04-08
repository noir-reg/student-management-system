/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SubjectList extends HashMap<String, Subject> {

    public boolean search(String id) {
        boolean check = false;
        if (this.containsKey(id) == true) {
            check = true;
        }
        return check;
    }

    public void add() {
        try {

            String id = Utils.getString("Enter subject id to check existence: ");
            if (search(id)) {
                System.out.println("ID has exist!");

            } else {
                String subID = Utils.getString("Enter subject id ");
                String subName = Utils.getString("Enter subject name ");
                int subCredit = Utils.getInt("Enter number of credit ");

                this.put(id, new Subject(subID, subName, subCredit));

            }
            boolean check = Utils.confirmYesNo("Do you want to add more ?(Y/N)");
            if (check) {
                add();
            }

        } catch (Exception e) {

        }

    }

    public void update() {
        String id = Utils.getString("Enter subject id to check existence: ");
        if (!search(id)) {
            System.out.println("Subject does not exist!");

        } else {

            boolean check = false;
            do {
                System.out.println("1. Update a subject");
                System.out.println("2. Delete a subject");
                System.out.println("3. Back to main menu");
                int choice = Utils.getInt("Choose (1-3)", 1, 3);
                switch (choice) {
                    case 1:
                        updateSubject(id);
                        break;
                    case 2:
                        deleteSubject(id);
                        break;
                    case 3:
                        check = Utils.confirmYesNo("(Y/N)");
                        break;

                }

            } while (!check);

        }
    }

    public void updateSubject(String id) {

        String subName = Utils.getString("Update subject name ", get(id).getSubName());
        int subCredit = Utils.getInt("Update number of credit ", get(id).getCredit());

        put(id, new Subject(id, subName, subCredit));
        System.out.println("Update successfully");
        boolean check = Utils.confirmYesNo("Do you want to go back to the update menu ?(Y/N)");
        if (!check) {
            updateSubject(id);
        }

    }

    public void deleteSubject(String id) {
        boolean check = Utils.confirmYesNo("Do you want to delete (Y/N) ");
        if (check) {
            this.remove(id);
            System.out.println("Delete successfully");
        }
        boolean confirm = Utils.confirmYesNo("Do you want to go back to the update menu (Y/N) ");
        if (!confirm) {
            deleteSubject(id);

        }

    }

    public void sort() {
        List<Subject> list = new ArrayList<>(this.values());
        Collections.sort(list);

    }
}
