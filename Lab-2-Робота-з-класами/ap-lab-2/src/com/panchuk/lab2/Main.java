package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;
import com.panchuk.lab2.model.Patient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Author - Oleksandr Panchuk - KN-203 - Variant - 8");

        PatientManagement.addPatient(new Patient(
                1,
                "Oleksandr", "Panchuk", "Viktorovich",
                "Krasilov",
                "+38(012)34-56-789",
                1234,
                "stomach ache"));

        PatientManagement.addPatient(new Patient(
                2,
                "Oleksandr1", "Panchuk1", "Viktorovich1",
                "Krasilov",
                "+38(012)44-56-789",
                124,
                "gg"));

        PatientManagement.addPatient(new Patient(
                3,
                "Oleksandr3", "Panchuk3", "Viktorovich3",
                "Krasilov",
                "+38(012)46-56-789",
                89002,
                "gg"));

        PatientManagement.addPatient(new Patient(
                4,
                "Oleksandr3", "Panchuk3", "Viktorovich3",
                "Krasilov",
                "+38(098)54-65-678",
                89002,
                "gg"));

        while (true) {

            MainController.printer();

            if (MainController.runner() == -1)
                break;
        }
    }
}

