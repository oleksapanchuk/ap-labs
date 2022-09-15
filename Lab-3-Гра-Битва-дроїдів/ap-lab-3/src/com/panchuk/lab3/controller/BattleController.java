package com.panchuk.lab3.controller;

import com.panchuk.lab3.model.*;

public class BattleController {
    private static final int NUM_ROUNDS = 2;
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final int area;

    public BattleController(Droid userDroid, Droid enemyDroid, int area) {
        this.userDroid = userDroid;
        this.enemyDroid = enemyDroid;
        this.area = area;
    }

    public void initBattle() {
        userDroid.adaptationToArea(area);
        enemyDroid.adaptationToArea(area);
    }

    public void runBattle() {
        int [] totalScore = new int[NUM_ROUNDS];
        int kRound = 0;

        for (int i = 0; i < NUM_ROUNDS; i++) {

            initBattle();

            System.out.println("\n-------------- Round " + (i + 1) + " -------------------------------------------------");
            totalScore[kRound++] = roundRunner(userDroid, enemyDroid);
            System.out.println("----------------------------------------------------------------------------");
        }

        getWinner(totalScore);
    }

    private static int roundRunner(Droid user, Droid enemy) {
        int kFight = 0;
        while (user.isAlive() && enemy.isAlive()) {
            System.out.println("\n~~~~~~~~ Fight " + (++kFight) + " ~~~~~~~~~~~~~~~~~~~~~~~");
            printDroid(user, enemy);

            user.giveDamage(user.printMenuDroid(), enemy);
            BotController.botGiveDamage(enemy, user);

            System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (!user.isAlive() && !enemy.isAlive()) {
                return 2;
            } else if (!user.isAlive() ) {
                return 1;
            } else if (!enemy.isAlive()) {
                return 0;
            }
        }
        return -1;
    }

    public void getWinner(int [] total) {
        int userScore = 0;
        int enemyScore = 0;

        System.out.print("\n\n\t\t\t\t\t~~~ Total result ~~~");
        for (int i = 0; i < NUM_ROUNDS; i++) {
            System.out.print("\nRound " + (i + 1) + ": \t");

            if (total[i] == 0) {
                userScore++;
                System.out.print("\tWin - " + userDroid.getName());
            } else if (total[i] == 1) {
                enemyScore++;
                System.out.print("\tWin - " + enemyDroid.getName());
            } else {
                userScore++;
                enemyScore++;
                System.out.print("\tDraw");
            }
        }

        if (userScore == enemyScore) {
            System.out.println("\n\n\t\tDRAW - friendship won");
        } else {
            System.out.print("\n\nABSOLUTE CHAMPION is ");
            if (userScore > enemyScore) {
                System.out.println(userDroid.getName());
            } else {
                System.out.println(enemyDroid.getName());
            }
        }

    }

    /** printDroid - method print current data about droids
     * @param user user droid
     * @param enemy enemy droid
     * */
    public static void printDroid(Droid user, Droid enemy) {
        System.out.println("\t\t\t" + user.getName() + " Droid\t\t\tVS\t\t\t" + enemy.getName() + " Droid" +
                "\nHealth: \t   "  + String.format("%3d", user.getHealth()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getHealth()) +
                "\nEnergy: \t   "  + String.format("%3d", user.getEnergy()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getEnergy()));
    }

    public static void main(String[] args) {
        Droid ud = new LionDroid();
        Droid ed = new SnakeDroid();

        BattleController newBattle = new BattleController(ud, ed, 2);


        System.out.println("\t\t\t\t~~~ Droids are ready for battle!!! ~~~");
        newBattle.initBattle();
        newBattle.runBattle();
    }

}
