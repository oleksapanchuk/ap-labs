package com.panchuk.lab3;

import com.panchuk.lab3.controller.MainContoller;

public class Main {

    public static void main(String[] args) {

        int checker = MainContoller.printStartMenu();

        if (checker == 1) {
            System.out.println("\n\t\t\t\t------ Preparation for battle ------");
            MainContoller.mainMenu();
        } else if (checker == 2) {
            System.out.println("Replay battle!");
        } else {
            System.out.println("The end of program!!!");
        }
    }
}
