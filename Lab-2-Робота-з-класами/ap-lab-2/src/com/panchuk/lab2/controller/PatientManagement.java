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
    public WrongInputPhoneNumberException(String message) {
        super(message);
    }
}

class WrongInputAddressException extends Exception {
    public WrongInputAddressException(String message) {
        super(message);
    }
}

public class PatientManagement {
    private static final int MAX_K_PATIENT = 200;
    private static Scanner scanner;
    private static Logger logger;
    private static final Patient[] arrayAllPatient;
    private static int kPatient;

    static {
        scanner = new Scanner(System.in);
        logger = Logger.getLogger(Validator.class.getName());

        arrayAllPatient = new Patient[MAX_K_PATIENT];
        kPatient = 0;
    }

    /**
     * search patient by id and return
     */
    public static Patient getPatientByID(int id) {
        for (Patient p : arrayAllPatient) {
            if (p.getId() == id) return p;
        }
        return null;
    }


    /**
     * method for adding input info about new patient into array
     */
    public static void addPatient() {
        arrayAllPatient[kPatient++] = inputPatient();
    }

    /**
     * method for adding new patient into array
     */
    public static void addPatient(Patient patient) {
        arrayAllPatient[kPatient++] = patient;
    }

    /**
     * input method that return new patient
     */
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

    /**
     * inputID method get ID or medical card number from user and return it
     * else info is incorrect -> output log about some exception
     */
    private static int inputID(String idName) {
        while (true) {
            try {
                System.out.print("\nInput patient " + idName + ": ");
                int idValue = Validator.getInteger(scanner.nextLine());
                int id = Validator.checkId(idValue);
                System.out.println("Information successfully added!!!");
                return id;
            } catch (NumberFormatException | WrongIDException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    /**
     * inputName method get (first, last, patronymic) name or diagnosis name
     * from user and return it
     * else info is incorrect -> output log about some exception
     */
    private static String inputName(String strName) {
        while (true) {
            try {
                System.out.print("\nInput patient " + strName + ": ");
                String str = Validator.checkName(scanner.nextLine(), strName);
                System.out.println("Information successfully added!!!");
                return str;
            } catch (WrongNameInputException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    /**
     * inputPhoneNumber method get phone number from user and return it
     * else info is incorrect -> output log about some exception
     */
    private static String inputPhoneNumber() {
        while (true) {
            try {
                System.out.print("\nInput patient phone number: ");
                String str = Validator.checkNPhone(scanner.nextLine());
                System.out.println("Information successfully added!!!");
                return str;
            } catch (WrongInputPhoneNumberException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    /**
     * inputAddress method get address from user and return it
     * else info is incorrect -> output log about some exception
     */
    private static String inputAddress() {
        while (true) {
            try {
                System.out.print("\nInput patient address: ");
                String str = Validator.checkAddress(scanner.nextLine());
                System.out.println("Information successfully added!!!");
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
        for (Patient p : arrayAllPatient) {
            if (p == null) return Arrays.copyOf(arrayAllPatient, index);
            index++;
        }
        return arrayAllPatient;
    }

    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByDiagnosis(String criteria) {
        Patient[] sortedByDiagnosis = new Patient[MAX_K_PATIENT];
        int index = 0;
        for (Patient p : arrayAllPatient) {
            if (p == null) break;
            if (p.getDiagnosis().toLowerCase().compareTo(criteria.toLowerCase()) == 0)
                sortedByDiagnosis[index++] = p;
        }
        return Arrays.copyOf(sortedByDiagnosis, index);
    }

    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByMedCardInterval(int start, int end) {
        Patient[] sortedByMedCardInterval = new Patient[MAX_K_PATIENT];
        int index = 0;
        for (Patient p : arrayAllPatient) {
            if (p == null) break;
            if (start < p.getNMedCard() && end > p.getNMedCard())
                sortedByMedCardInterval[index++] = p;
        }
        return Arrays.copyOf(sortedByMedCardInterval, index);
    }

    /**
     * Getter of an array sorted by first digit of phone number
     */
    public static Patient[] getSortedByDigitOfPhoneNum(String digits) {
        Patient[] sortedByDigitOfPhoneNum = new Patient[MAX_K_PATIENT];
        int index = 0;
        for (Patient p : arrayAllPatient) {
            if (p == null) break;
            String tempNum = p.getNPhone().substring(8);// +38(098)XX-XX-XXX
            if (tempNum.startsWith(digits))
                sortedByDigitOfPhoneNum[index++] = p;
        }
        return Arrays.copyOf(sortedByDigitOfPhoneNum, index);
    }

    public static void startPatientsInArr() {
        PatientManagement.addPatient(new Patient(
                1,
                "Lopez", "King", "Gutierrez",
                "3255 Holt Street",
                "+38(098)311-55-00",
                100,
                "Ischemic heart disease"));

        PatientManagement.addPatient(new Patient(
                2,
                "Morales", "Martin", "Arnold",
                "3255 Holt Street",
                "+38(098)280-77-29",
                200,
                "Diabetes mellitus"));

        PatientManagement.addPatient(new Patient(
                3,
                "Simpson", "Elliott", "Hernandez",
                "362 Daylene Drive",
                "+38(098)593-21-71",
                500,
                "Stroke"));

        PatientManagement.addPatient(new Patient(
                4,
                "Grant", "Stephens", "Hudson",
                "2180 Blue Spruce Lane",
                "+38(098)058-40-90",
                1000,
                "Stroke"));
        PatientManagement.addPatient(new Patient(
                5,
                "Ward", "Arnold", "Stephens",
                "5 Worley Avenue",
                "+38(098)120-62-09",
                1234,
                "Ischemic heart disease"));
        PatientManagement.addPatient(new Patient(
                6,
                "Spencer", "Fisher", "Gardner",
                "1658 Emerson Road",
                "+38(098)902-72-28",
                3214,
                "gg"));
        PatientManagement.addPatient(new Patient(
                7,
                "Baker", "Berry", "O'Neill",
                "2060 Eden Drive",
                "+38(098)120-20-23",
                60,
                "Stroke"));
        PatientManagement.addPatient(new Patient(
                8,
                "Cole", "Cook", "Cox",
                "3128 Bernardo Street",
                "+38(098)715-81-53",
                9254,
                "Diabetes mellitus"));
        PatientManagement.addPatient(new Patient(
                9,
                "Fox", "Fisher", "Burns",
                "4963 Fairfax Drive",
                "+38(098)739-93-85",
                147528,
                "Diabetes mellitus"));

    }
}
