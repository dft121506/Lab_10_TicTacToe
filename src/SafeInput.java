import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }

    public static int getInt(Scanner pipe, String prompt) {
        int retInt = 0;
        String trash = "";
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine();
                valid = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is a invalid input");
            }
        } while (!valid);

        return retInt;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double retdouble = 0;
        String trash = "";
        boolean valid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retdouble = pipe.nextDouble();
                pipe.nextLine();
                valid = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is a invalid input");
            }
        } while (!valid);

        return retdouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int getRangedInt = 0;
        String trash = "";
        boolean valid = false;
        do {
            getRangedInt = getInt(pipe, prompt);
            if (getRangedInt >= low && getRangedInt <= high) {
                valid = true;
                System.out.println(getRangedInt + " is in the range");
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is a invalid input");
            }
        } while (!valid);

        return getRangedInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double getRangedDouble = 0;
        String trash = "";
        boolean valid = false;
        do {
            getRangedDouble = getDouble(pipe, prompt);
            if (getRangedDouble >= low && getRangedDouble <= high) {
                valid = true;
                System.out.println(getRangedDouble + " is in the range");
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is a invalid input");
            }
        } while (!valid);

        return getRangedDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String getYNConfirm = "";
        boolean valid = false;
        do {
            getYNConfirm = getNonZeroLenString(pipe, prompt);
            if (getYNConfirm.equalsIgnoreCase("Y") || getYNConfirm.equalsIgnoreCase("N")) {
                valid = true;
            } else {
                System.out.println(getYNConfirm + " is a invalid input");
            }
        } while (!valid);
        return (getYNConfirm.equalsIgnoreCase("Y"));
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String number;
        boolean trueOrFalse = false;
        do {
            System.out.print("\n" + prompt + ": ");
            number = pipe.nextLine();
            if (number.matches(regEx)) {
                trueOrFalse = true;
            } else {
                System.out.println(number + " is an invalid input");
            }

        } while (!trueOrFalse);
        return number;
    }

    public static void prettyHeader(String msg) {
        int TOTAL_WIDTH = 60;
        int SIDES = 3;
        int msglength = msg.length();
        int totalPadding = TOTAL_WIDTH - (SIDES * 2) - msglength;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        for (int i = 0; i < TOTAL_WIDTH; i++) {
            System.out.print("*");
        }
        System.out.println();

        System.out.print("***");

        for (int i = 0; i < leftPadding; i++)
            System.out.print(" ");

        System.out.print(msg);

        for (int i = 0; i < rightPadding; i++)
            System.out.print(" ");

        System.out.println("***");

        for (int i = 0; i < TOTAL_WIDTH; i++) {
            System.out.print("*");
        }
    }

    public static double getAverage(int[] values){
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        double average = ((double) sum / values.length);

        return average;
    }
}

