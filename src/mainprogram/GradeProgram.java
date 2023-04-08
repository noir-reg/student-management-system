/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainprogram;

import data.StudentManager;
import tools.Utils;

/**
 *
 * @author Admin
 */
public class GradeProgram {

    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        mainMenu.add("Add new student");
        mainMenu.add("Update student");
        mainMenu.add("Add new subject");
        mainMenu.add("Update subject");
        mainMenu.add("Add grade");
        mainMenu.add("Report student");
        mainMenu.add("Report subject");
        mainMenu.add("Quit");

        Menu stMenu = new Menu();
        stMenu.add("Update student");
        stMenu.add("Delete student");
        stMenu.add("Back to main menu");

        Menu subMenu = new Menu();
        subMenu.add("Update subject");
        subMenu.add("Delete subject");
        subMenu.add("Back to main menu");

        StudentManager mng = new StudentManager();
        int choice1, choice2;
        boolean check = false;
        do {
            choice1 = mainMenu.getUSerChoice();
            switch (choice1) {
                case 1:
                    mng.addStudent();
                    break;
                case 2:
                    do {
                        choice2 = stMenu.getUSerChoice();
                        switch (choice2) {
                            case 1:
                                mng.updateStudent();
                                break;
                            case 2:
                                mng.deleteStudent();
                                break;
                            default:
                                System.out.println("Bye!");

                        }

                    } while (choice2 > 0 && choice2 < stMenu.size());
                    break;
                case 3:
                    mng.addSubject();
                    break;
                case 4:
                    do {
                        choice2 = subMenu.getUSerChoice();
                        switch (choice2) {
                            case 1:
                                mng.updateSubject();
                                break;
                            case 2:
                                mng.deleteSubject();
                                break;
                            default:
                                System.out.println("Bye!");

                        }

                    } while (choice2 > 0 && choice2 < stMenu.size());
                    break;
                case 5:
                    mng.addGrade();
                    break;
                case 6:
                    mng.reportStudent();
                    break;
                case 7:
                    mng.reportSubject();
                    break;
                default:
                    boolean confirm = Utils.confirmYesNo("Do you want to quit ?(Y/N) ");
                    if (confirm) {
                        check = true;
                        System.out.println("Bye!");
                    }

            }

        } while (!check);
    }

}
