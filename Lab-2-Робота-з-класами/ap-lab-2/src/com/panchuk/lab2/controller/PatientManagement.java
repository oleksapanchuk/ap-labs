package com.panchuk.lab2.controller;

import com.panchuk.lab2.model.Patient;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class WrongIDException extends Exception {
    public WrongIDException(String message) {
        super(message);
    }
}

class WrongNameInputException extends Exception {
    public WrongNameInputException(String message) {
        super(message);
    }
}

class WrongInputPhoneNumberException extends Exception {
    public WrongInputPhoneNumberException(String message) { super(message); }
}

class WrongInputAddressException extends Exception {
    public WrongInputAddressException(String message) { super(message); }
}

public class PatientManagement {
    private static final int MAX_K_PATIENT = 200;
    private static Scanner scanner;
    private static Logger logger;
    private static final Patient [] arrayAllPatient;
    private static int kPatient;
    private static final Patient[] sortedByDiagnosis;
    private static final Patient[] sortedByMedCardInterval;
    private static final Patient[] sortedByDigitOfPhoneNum;

    static {
        scanner = new Scanner(System.in);
        logger = Logger.getLogger(Validator.class.getName());

        arrayAllPatient = new Patient[MAX_K_PATIENT];
        kPatient = 0;

        sortedByDiagnosis = new Patient[MAX_K_PATIENT];
        sortedByDigitOfPhoneNum = new Patient[MAX_K_PATIENT];
        sortedByMedCardInterval = new Patient[MAX_K_PATIENT];
    }



    public static void appPatient() {
        arrayAllPatient[kPatient++] = inputPatient();
    }
    public static void appPatient(Patient patient) {
        arrayAllPatient[kPatient++] = patient;
    }

    private static Patient inputPatient() {
        return new Patient(
                inputID("ID"),
                inputName("First Name"),
                inputName("Last Name"),
                inputName("Patronymic"),
                inputAddress(),
                inputPhoneNumber(),
                inputID("medical card number"),
                inputName("Diagnosis")
        );
    }

    private static int inputID(String idName) {
        while (true) {
            try {
                System.out.print("\nInput patient " + idName + ": ");
                int idValue = Validator.getInteger(scanner.nextLine());
                int id = Validator.checkId(idValue);
                System.out.println("\nInformation successfully added!!!");
                return id;
            } catch (NumberFormatException | WrongIDException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    private static String inputName(String strName) {
        while (true) {
            try {
                System.out.print("\nInput patient " + strName + ": ");
                String str = Validator.checkName(scanner.nextLine(), strName);
                System.out.println("\nInformation successfully added!!!");
                return str;
            } catch (WrongNameInputException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    private static String inputPhoneNumber() {
        while (true) {
            try {
                System.out.print("\nInput patient phone number: ");
                String str = Validator.checkNPhone(scanner.nextLine());
                System.out.println("\nInformation successfully added!!!");
                return str;
            } catch (WrongInputPhoneNumberException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    private static String inputAddress() {
        while (true) {
            try {
                System.out.print("\nInput patient address: ");
                String str = Validator.checkAddress(scanner.nextLine());
                System.out.println("\nInformation successfully added!!!");
                return str;
            } catch (WrongInputAddressException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }



    /**
     * Getter of an array sorted by diagnosis
     */
    public static Patient[] getArrayAllPatient() {
        int index = 0;
        for (Patient p: arrayAllPatient) {
            if (p == null) return Arrays.copyOf(arrayAllPatient, index);
            index++;
        }
        return arrayAllPatient;
    }
    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByDiagnosis() {
        int index = 0;
        for (Patient p: sortedByDiagnosis) {
            if (p == null) return Arrays.copyOf(sortedByDiagnosis, index);
            index++;
        }
        return sortedByDiagnosis;
    }
    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByMedCardInterval() {
        int index = 0;
        for (Patient p: sortedByMedCardInterval) {
            if (p == null) return Arrays.copyOf(sortedByMedCardInterval, index);
            index++;
        }
        return sortedByMedCardInterval;
    }
    /**
     * Getter of an array sorted by first digit of phone number
     */
    public static Patient[] getSortedByDigitOfPhoneNum() {
        int index = 0;
        for (Patient p: sortedByDigitOfPhoneNum) {
            if (p == null) return Arrays.copyOf(sortedByDigitOfPhoneNum, index);
            index++;
        }
        return sortedByDigitOfPhoneNum;
    }


}
