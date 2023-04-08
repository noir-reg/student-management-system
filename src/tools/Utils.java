/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

public class Utils {

    public static final int DMY = 0;
    public static final int MDY = 1;
    public static final int YMD = 2;
    public static final String PHONE_10TO12 = "[\\d]{10,12}";
    public static final String EMAIL = ".+@.+[.].+";

    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Can not be blank!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int getInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;

        String confirm = Utils.getString(welcome);

        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;

        }

        return result;

    }

    public static boolean isLeap(int y) {
        boolean result = false;
        if ((y % 400 == 0) || (y % 4 == 0) && (y % 100 != 0)) {
            result = true;
        }
        return result;

    }

    public static boolean valid(int y, int m, int d) {
        if (y <= 0 || m <= 0 || m > 12 || d <= 0 || d > 31) {
            return false;
        }
        int maxD = 31;
        if (m == 4 || m == 6 || m == 9 || m == 11) {
            maxD = 30;
        } else if (m == 2) {
            if (isLeap(y)) {
                maxD = 29;
            } else {
                maxD = 28;
            }
        }
        return d <= maxD;
    }

    public static Date toDate(int y, int m, int d) {

        if (!valid(y, m, d)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, d);
        return cal.getTime();

    }

    public static Date toDate(String dateStr, int dateFormat) {
        int yIndex, mIndex, dIndex;
        switch (dateFormat) {
            case YMD:
                yIndex = 0;
                mIndex = 1;
                dIndex = 2;
                break;
            case MDY:
                yIndex = 2;
                mIndex = 0;
                dIndex = 1;
                break;
            case DMY:
                yIndex = 2;
                mIndex = 1;
                dIndex = 0;
                break;
            default:
                return null;
        }
        String[] parts = dateStr.split("[/-]");
        if (parts.length != 3) {
            return null;
        }
        int y = Integer.parseInt(parts[yIndex]);
        int m = Integer.parseInt(parts[mIndex]);
        int d = Integer.parseInt(parts[dIndex]);
        return toDate(y, m, d);
    }

    public static Date inputDate(String welcome) {
        String inputStr;
        Date d;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(welcome + "[yyyy/mm/dd]");
            inputStr = sc.nextLine().trim();
            d = toDate(inputStr, YMD);
            if (d == null) {
                System.out.println("Invlid date");
            }

        } while (d == null);
        return d;
    }

    public static boolean confirmYesNo(String welcome, boolean oldData) {
        Scanner sc = new Scanner(System.in);
        System.out.println(welcome);
        boolean result;
        String confirm = sc.nextLine();
        if (confirm.isEmpty()) {
            result = oldData;
        } else {
            if ("Y".equalsIgnoreCase(confirm)) {
                result = true;
            } else {
                result = false;
            }

        }
        return result;

    }

    public static Date updateDate(Date oldData) {
        String inputStr;
        Date d = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a birthdate yyyy/mm/dd ");
        inputStr = sc.nextLine().trim();
        if (!inputStr.isEmpty()) {
            do {
                d = toDate(inputStr, YMD);
                if (d == null) {
                    System.out.println("Invalid date");
                    System.out.println("Try again");
                    inputStr = sc.nextLine().trim();
                }

            } while (d == null);

        }
        return d;
    }

    public static String getPhoneOrEmail(String welcome, String regex) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Can not be blank !!!");
            } else if (!result.matches(regex)) {

                System.out.println("Invalid");
                System.out.println("Input again");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getPhoneOrEmail(String welcome, String regex, String oldData) {

        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }

        while (true) {

            if (!result.matches(regex)) {

                System.out.println("Invalid");
                System.out.println("Input again");
                result = sc.nextLine();

            } else {
                break;

            }

        }

        return result;
    }

    public static int getInt(String welcome) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < 0);
        return number;
    }

    public static int getInt(String welcome, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number < 0);
        return number;
    }

    public static double getDouble(String welcome, int min, int max, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDouble(String welcome, int min, int max) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;

            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static String strDMY(Date d) {
        String S = "";
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return S + c.get(Calendar.DATE) + '-' + (c.get(Calendar.MONTH) + 1) + '-' + c.get(Calendar.YEAR);
    }

    public static String strGender(boolean check) {
        String S;
        if (check) {
            S = "Male";
        } else {
            S = "Female";
        }
        return S;
    }

}
