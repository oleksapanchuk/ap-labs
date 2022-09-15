package com.panchuk.lab3;

import com.panchuk.lab3.controller.MainController;

public class Main {

    public static void main(String[] args) {

        int checker = MainController.printStartMenu();

        if (checker == 1) {
            System.out.println("\n\t\t\t\t------ Preparation for battle ------");

            MainController.mainMenu();

        } else if (checker == 2) {
            System.out.println("Replay battle!");
        } else {
            System.out.println("The end of program!!!");
        }
    }
}
