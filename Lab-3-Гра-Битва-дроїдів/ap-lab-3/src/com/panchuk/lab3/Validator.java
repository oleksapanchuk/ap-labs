package com.panchuk.lab3;

import java.util.Scanner;

public class Validator {
    private static final Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    public static int inputValue(int start, int end) {
        while (true) {
            try {
                int intValue = intValue();
                if (intValue >= start && intValue <= end) {
                    return intValue;
                }
                System.err.print("Inputted value does not match the written" +
                        " value (" + start + ", " + end + "). Try again: ");
            } catch (NumberFormatException e) {
                System.err.print("Number Format Exception. Try again: ");
            }
        }
    }

    private static int intValue() throws NumberFormatException {
        String number = scan.nextLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
