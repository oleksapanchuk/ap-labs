package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;

import java.util.Scanner;

public class MainController {
    private static final Scanner scan;

    static {
        scan =  new Scanner(System.in);
    }

    public static void addingPatients() {
        while (true) {
            PatientManagement.appPatient();

            System.out.println("\nTo continue typing 1, anything else otherwise!\n");
            int checker = scan.nextInt();
            if (checker != 1)
                return;
        }




    }
}
