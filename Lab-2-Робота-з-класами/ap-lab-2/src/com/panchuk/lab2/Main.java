package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;
import com.panchuk.lab2.model.Patient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PatientManagement.appPatient(new Patient(
                1,
                "Oleksandr", "Panchuk","Viktorovich",
                "Krasilov",
                "380123456789",
                1234,
                "stomach ache"));
        System.out.print("Author - Oleksandr Panchuk - KN-203 - Variant - 8");

        int checkPoint;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(new StringBuilder().append("\n\t\t\t~~~~~\n")
                    .append("Input:\n\t")
                    .append("1 - to add new patient\n\t")
                    .append("2 - to show all patients\n\t")
                    .append("3 - to show ...\n\t")
                    .append("4 - to show ...\n\t5 - to show\n\t")
                    .append("-1 - to end working").toString());

            checkPoint = scanner.nextInt();

            if (checkPoint == -1) {
                System.out.println("End of program!");
                break;
            }
            switch (checkPoint) {
                case 1: {
                    System.out.print("Adding patients:");
                    MainController.addingPatients();
                    break;
                }
                case 2: {
                    Patient [] allPatients = PatientManagement.getArrayAllPatient();
                    for (int i = 0; i < allPatients.length; i++) {
                        System.out.println(allPatients[i]);
                    }
                    break;
                }
                case 3: { break; }
                case 4: { break; }
                default: { break; }
            }
        }
    }
}
