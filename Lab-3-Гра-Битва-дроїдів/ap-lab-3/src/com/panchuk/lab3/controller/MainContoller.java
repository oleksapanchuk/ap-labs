package com.panchuk.lab3.controller;

import java.util.Scanner;

public class MainContoller {
    private static final Scanner scanner;


    static {
        scanner = new Scanner(System.in);
    }

    public static void mainMenu() {
        int checker = printMainMenu();
        if (checker == 1) {
            BattleInfo info = new BattleInfo(1, 2, "Sasha", 2);
            System.out.println("there will 1 VS 1");
            System.out.println(info);
        } else if (checker == 2) {
            System.out.println("there will team VS team");
        } else {
            System.out.println("Wrong value input!");
        }

    }





    public static int printMainMenu() {
        System.out.print("""
                
                Battle preparation menu:
                \t'1' - if you want battle 1 VS 1
                \t'2' - if you want battle Team VS Team
                Your choice:\s""");

        return scanner.nextInt();
    }
    public static int printStartMenu() {
        System.out.print("""
                Start menu:
                \tInput '1' - to start preparing fot battle
                \tInput '2' - to replay battle
                \tOtherwise end of program
                Your choice:\s""");

        return scanner.nextInt();
    }
}
