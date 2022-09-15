package com.panchuk.lab3.controller;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;
import com.panchuk.lab3.Writer;
import com.panchuk.lab3.model.*;

public class MainController {

    public static void mainMenu() {

        if (printMainMenu() == 1) {

            battleOneVSOne();

        } else {

            System.out.println(" Team VS Team");

        }
    }

    private static void battleOneVSOne() {
        System.out.println("\n\t\t\t\t\t\t\t~~~ START ~~~");

        BattleController battle = new BattleController(
                chooseYourDroid(),
                randomDroidForBattle(),
                Randomizer.getRadomInt(0, 3));
        System.out.println("\t\t\t\t~~~ Droids are ready for battle!!! ~~~");
        battle.initBattle();
        battle.runBattle();

        FileController.createFile(battle.getUserDroid().getName().toLowerCase()
                + "_vs_"
                + battle.getEnemyDroid().getName().toLowerCase());
        FileController.writeToFile(Writer.info.toString());
    }

    private static Droid chooseYourDroid() {

        System.out.println("\t\t\tAll droids");
        printListOfDroids();
        System.out.print("\nChoose your droid for battle: ");
        int idDroid = Validator.inputValue(1, 5);

        return selectDroidByID(idDroid);
    }

    private static Droid randomDroidForBattle() {
        return selectDroidByID(Randomizer.getRadomInt(1, 5));
    }

    private static Droid selectDroidByID(int idDroid) {
        return switch (idDroid) {
            case 1 -> new LionDroid();
            case 2 -> new ScorpionDroid();
            case 3 -> new SnakeDroid();
            case 4 -> new CrocodileDroid();
            case 5 -> new SharkDroid();
            default -> throw new IllegalArgumentException("Something went wrong!");
        };
    }

    private static void printListOfDroids() {
        System.out.println("\n ~~~ Droid 1 ~~~ \n" + new LionDroid());
        System.out.println("\n ~~~ Droid 2 ~~~ \n" + new ScorpionDroid());
        System.out.println("\n ~~~ Droid 3 ~~~ \n" + new SnakeDroid());
        System.out.println("\n ~~~ Droid 4 ~~~ \n" + new CrocodileDroid());
        System.out.println("\n ~~~ Droid 5 ~~~ \n" + new SharkDroid());
    }

    public static int printMainMenu() {
        System.out.print("""
                                
                Battle preparation menu:
                \t'1' - if you want battle 1 VS 1
                \t'2' - if you want battle Team VS Team
                Your choice:\s""");

        return Validator.inputValue(1, 2);
    }

    public static int printStartMenu() {
        System.out.print("""
                Start menu:
                \tInput '1' - to start preparing fot battle
                \tInput '2' - to replay battle
                \tInput '3' - end of program
                Your choice:\s""");

        return Validator.inputValue(1, 3);
    }
}
