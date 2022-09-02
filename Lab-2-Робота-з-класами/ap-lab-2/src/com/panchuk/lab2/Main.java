package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Author - Oleksandr Panchuk - KN-203 - Variant - 8");

        PatientManagement.startPatientsInArr();

        while (true) {

            MainController.printer();

            if (MainController.runner() == -1)
                break;
        }
    }
}

