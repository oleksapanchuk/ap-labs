package com.panchuk.lab3.controller;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;
import com.panchuk.lab3.Writer;
import com.panchuk.lab3.model.*;

public class MainController {

    /**
     * main method menu <br/><br/>
     * user can input 1 - for battle 1 vs 1 -> invoke method battleOneVSOne()<br/><br/>
     * user can input 2 - for battle team vs team -> invoke method battleTeamVSTeam()<br/><br/>
     */
    public static void mainMenu() {

        if (printMainMenu() == 1) {

            battleOneVSOne();

        } else {

            battleTeamVSTeam();

        }
    }

    /**
     * battleOneVSOne method executes a battle and creates and writes battle information to a file
     */
    private static void battleOneVSOne() {
        System.out.println("\n\t\t\t\t\t\t\t~~~ START ~~~");

        BattleController battle = new BattleController(
                chooseYourDroid(),
                selectDroidByID(Randomizer.getRadomInt(1, 5)),
                Randomizer.getRadomInt(0, 3));
        System.out.println("\t\t\t\t~~~ Droids are ready for battle!!! ~~~");
        battle.runBattle();

        FileController.createFile(battle.getUserDroid().getName().toLowerCase()
                + "_vs_"
                + battle.getEnemyDroid().getName().toLowerCase());
        FileController.writeToFile(Writer.info.toString());
    }

    /**
     * battleTeamVSTeam method collects team-by-team battle information. <br/><br/>
     * Calls additional methods: inputName, selectDroidByID, createFile, writeToFile. <br/><br/>
     * Calls defineWinner(resultOfBattles) method that determines the winning team.
     */
    private static void battleTeamVSTeam() {
        System.out.println("\n\n\t\t\t\t\tTEAM VS TEAM MODE");
        int kMem = 3;

        Droid[] userTeamDroid = new Droid[kMem];
        Droid[] enemyTeamDroid = generateEnemyTeam(kMem);

        String userTeamName = Validator.inputName("of your team: ");

        printListOfDroids();

        System.out.print("\nChoose Droid for yourself: ");
        userTeamDroid[0] = selectDroidByID(Validator.inputValue(1, 5));

        for (int i = 1; i < kMem; i++) {
            System.out.print("\nChoose Droid ¹" + (i + 1) + " for you team: ");
            userTeamDroid[i] = selectDroidByID(Validator.inputValue(1, 5));
        }

        FileController.createFile(userTeamName + "_vs_" + enemyTeamDroid[0].getName() + "TvsT");

        int[] resultOfBattles = new int[kMem];

        BattleController battle = new BattleController(
                userTeamDroid[0],
                enemyTeamDroid[0],
                Randomizer.getRadomInt(0, 3));

        resultOfBattles[0] = battle.runBattle();

        FileController.writeToFile(Writer.info.toString());

        for (int i = 1; i < kMem; i++) {
            Writer.numBotBattle(i);

            resultOfBattles[i] = BotController.botVSBot(
                    userTeamDroid[i],
                    enemyTeamDroid[i],
                    Randomizer.getRadomInt(0, 3));

            FileController.writeToFile(Writer.infoBot.toString());
        }

        defineWinner(resultOfBattles);
    }

    /**
     * method counts the number of points of each of the teams and determines the winning team
     *
     * @param battleResults array integer contains 0 - (draw in battle),
     *                      1 - (win member of team 1) and 2 - (win member of team 2)
     */
    private static void defineWinner(int[] battleResults) {
        int userTeam = 0;
        int enemyTeam = 0;
        int nRound = 0;
        for (int battleResult : battleResults) {
            System.out.println("\nBATTLE ¹" + (++nRound) + " ");
            if (battleResult == 0) {
                userTeam++;
                enemyTeam++;
                System.out.println("DRAW");
            } else if (battleResult == 1) {
                userTeam++;
                System.out.println("WINNER -> USER TEAM Droid");
            } else {
                enemyTeam++;
                System.out.println("WINNER -> ENEMY TEAM Droid");
            }
        }

        System.out.println("\n\n\t\t\tTOTAL SCORE: User Team -> " + userTeam + "   --- Enemy Team -> " + enemyTeam);

        if (userTeam == enemyTeam) System.out.println("\t\t\t\t\t\tDRAW");
        else if (userTeam > enemyTeam) System.out.println("\t\t\tWINNER -> USER TEAM");
        else System.out.println("\t\t\tWINNER -> ENEMY TEAM");
    }

    /**
     * chooseYourDroid method invokes printListOfDroids and get id of droid from user
     *
     * @return invoke selectDroidByID and return new Droid items
     */
    private static Droid chooseYourDroid() {

        System.out.println("\t\t\tAll droids");
        printListOfDroids();
        System.out.print("\nChoose your droid for battle: ");
        int idDroid = Validator.inputValue(1, 5);

        return selectDroidByID(idDroid);
    }

    /**
     * selectDroidByID method create new instance of droid by id number
     *
     * @param idDroid ID of list droids
     * @return Droid items
     */
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

    /**
     * printListOfDroids method displays all droids
     */
    private static void printListOfDroids() {
        System.out.println("\n ~~~ Droid 1 ~~~ \n" + new LionDroid());
        System.out.println("\n ~~~ Droid 2 ~~~ \n" + new ScorpionDroid());
        System.out.println("\n ~~~ Droid 3 ~~~ \n" + new SnakeDroid());
        System.out.println("\n ~~~ Droid 4 ~~~ \n" + new CrocodileDroid());
        System.out.println("\n ~~~ Droid 5 ~~~ \n" + new SharkDroid());
    }

    /**
     * method get size of team and return Droids array for enemy team
     */
    private static Droid[] generateEnemyTeam(int kMem) {
        Droid[] result = new Droid[kMem];

        for (int i = 0; i < kMem; i++) {
            result[i] = selectDroidByID(Randomizer.getRadomInt(1, 5));
        }

        return result;
    }

    /**
     * printMainMenu method print mein menu items
     *
     * @return intValue input number - items of menu
     */
    public static int printMainMenu() {
        System.out.print("""
                                
                Battle preparation menu:
                \t'1' - if you want battle 1 VS 1
                \t'2' - if you want battle Team VS Team
                Your choice:\s""");

        return Validator.inputValue(1, 2);
    }

    /**
     * printMainMenu method print start menu items
     *
     * @return intValue input number - items of menu
     */
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
