package com.panchuk.lab2;

import com.panchuk.lab2.model.Patient;

public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient(1, "Oleksandr", "Panchuk",
                "Viktorovich", "Krasilov", "+3809999999999",
                1234, "stomach ache");
        System.out.println(patient1);
    }
}
