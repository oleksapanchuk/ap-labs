package com.panchuk.lab2;

import com.panchuk.lab2.controller.PatientManagement;
import com.panchuk.lab2.model.Patient;

public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient(1, "Oleksandr", "Panchuk",
                "Viktorovich", "Krasilov", "380123456789",
                1234, "stomach ache");
        PatientManagement.appPatient(patient1);
        PatientManagement.appPatient();
    }
}
