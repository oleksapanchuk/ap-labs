package com.panchuk.taxes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final Pattern VALID_FULL_NAME =
            Pattern.compile("^(?![ .]+$)[a-zA-Z .]*$");
    public static final Pattern VALID_LOGIN =
            Pattern.compile("^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.\\-]{0,19}$");
    public static final Pattern VALID_EMAIL =
            Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.\\-]+@[a-zA-Z0-9.\\-]+$");
    public static final Pattern VALID_PASSWORD =
            Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;.',?/*~$^+=<>]).{8,20}$");
    public static final Pattern VALID_DATE =
            Pattern.compile("^([0-2]\\d||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$");

    /*
    Password:
        - Password must contain at least one digit [0-9].
        - Password must contain at least one lowercase Latin character [a-z].
        - Password must contain at least one uppercase Latin character [A-Z].
        - Password must contain at least one special character like ! @ # & ( ).
        - Password must contain a length of at least 8 characters and a maximum of 20 characters.

    Date - format XX/YY/ZZZZ
    */

    public static String inputString(String inputAtr, Pattern pattern) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nInput " + inputAtr + ": ");
        while (true) {
            try {
                String inputData = bf.readLine();
                Matcher matcher = pattern.matcher(inputData);

                if (matcher.matches()) return inputData;

                System.err.print("The entered value does not match " + inputAtr + ". Try again: ");
            } catch (IOException e) {
                System.err.print("Input error occurred! Try again: ");
            }
        }
    }

}
