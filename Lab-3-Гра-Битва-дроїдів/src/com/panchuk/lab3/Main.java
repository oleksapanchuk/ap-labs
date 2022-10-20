package com.panchuk.lab3;

import com.panchuk.lab3.controller.FileController;
import com.panchuk.lab3.controller.MainController;

/**
 * DROID BATTLE
 *
 * @author Oleksandr Panchuk
 */
public class Main {

    /**
     * main method of program
     */
    public static void main(String[] args) {

        int checker = MainController.printStartMenu();

        if (checker == 1) {
            System.out.println("\n\t\t\t\t------ Preparation for battle ------");

            MainController.mainMenu();

        } else if (checker == 2) {

            FileController.readFile();

        } else {
            System.out.println("The end of program!!!");
        }
    }
}
