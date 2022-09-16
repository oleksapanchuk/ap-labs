package com.panchuk.lab3;

import java.util.Scanner;

public class Validator {
    private static final Scanner scan;

    static {
        scan = new Scanner(System.in);
    }

    /**
     * inputValue method get from user some text, parse it to number and
     * check whether the given number is subject to a gap
     *
     * @param start start gap inclusive
     * @param end   end gap inclusive
     * @return int value
     */
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

    /**
     * inputName method check Is input data a number
     *
     * @return int number
     */
    private static int intValue() throws NumberFormatException {
        String number = scan.nextLine();
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    /**
     * inputName method get from user some name
     *
     * @param str specify what exactly need to input
     * @return String name
     */
    public static String inputName(String str) {
        System.out.print("\nInput name " + str);
        return scan.nextLine();
    }
}
