package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;
import com.panchuk.lab2.model.Patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainController {
    private static final Scanner scan;
    private static BufferedReader reader;

    static {
        scan = new Scanner(System.in);
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static int runner() throws IOException {
        int checkPoint = scan.nextInt();

        if (checkPoint == -1) {
            System.out.println("End of program!");
            return -1;
        }

        switch (checkPoint) {
            case 1: {
                System.out.print("Adding patients:");
                MainController.addingPatients();
                break;
            }
            case 2: {
                printArr(PatientManagement.getArrayAllPatient());
                break;
            }
            case 3: {
                System.out.print("\nInput diagnosis: ");
                String diagnosis = reader.readLine();
                printArr(PatientManagement.getSortedByDiagnosis(diagnosis));
                break;
            }
            case 4: {
                int start, end;
                System.out.print("Input start of interval: ");
                start = scan.nextInt();
                System.out.print("Input end of interval: ");
                end = scan.nextInt();
                printArr(PatientManagement.getSortedByMedCardInterval(start, end));
                break;
            }
            case 5: {
                System.out.print("Input digit(s): ");
                String digits = reader.readLine();
                printArr(PatientManagement.getSortedByDigitOfPhoneNum(digits));
                break;
            }
            default: {
                break;
            }
        }
        return 0;
    }

    private static void printArr(Patient[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void addingPatients() {
        while (true) {
            PatientManagement.addPatient();

            System.out.println("\nTo continue typing 1, anything else otherwise!\n");
            int checker = scan.nextInt();
            if (checker != 1)
                return;
        }


    }


    public static void printer() {
        System.out.println(new StringBuilder().append("\n\t\t\t~~~~~\n")
                .append("Input:\n\t")
                .append("1 - to add new patient\n\t")
                .append("2 - to show a list of all patients\n\t")
                .append("3 - to show a list of patients that sorted by diagnosis\n\t")
                .append("4 - to show a list of patients that sorted by medical card number interval\n\t")
                .append("5 - to show a list of patients that sorted by first digit phone number\n\t")
                .append("-1 - to end working")
                .append("\n\t\t\t~~~~~\n"));
    }
}
