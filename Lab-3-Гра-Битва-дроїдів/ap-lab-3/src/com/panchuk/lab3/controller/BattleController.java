package com.panchuk.lab3.controller;

import com.panchuk.lab3.Writer;
import com.panchuk.lab3.model.Droid;

public class BattleController {
    private static final int NUM_ROUNDS = 2;
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final int area;

    /**
     * Battle Controller constructor
     */
    public BattleController(Droid userDroid, Droid enemyDroid, int area) {
        this.userDroid = userDroid;
        this.enemyDroid = enemyDroid;
        this.area = area;
    }

    /**
     * initBattle method gives the characteristics of the droid
     * depending on its type and the battle area
     */
    private void initBattle() {
        userDroid.adaptationToArea(area);
        enemyDroid.adaptationToArea(area);
    }

    /**
     * runBattle - main method of the controller that triggers
     * the execution of battle rounds
     * <p>
     * method invokes roundRunner method that execute each round
     */
    public int runBattle() {
        int[] totalScore = new int[NUM_ROUNDS];
        int kRound = 0;

        for (int i = 0; i < NUM_ROUNDS; i++) {

            initBattle();

            Writer.writerAndPrinter("\n-------------- Round " + (i + 1) + " -------------------------------------------------\n");

            totalScore[kRound++] = roundRunner(userDroid, enemyDroid);

            Writer.writerAndPrinter("\n----------------------------------------------------------------------------\n");
        }

        return getWinner(totalScore);
    }

    /**
     * roundRunner performs each fight of the round
     *
     * @return integer - id of winner 2 - draw, 1 - user won, 2 - enemy won
     */
    private static int roundRunner(Droid user, Droid enemy) {
        int kFight = 0;
        while (user.isAlive() && enemy.isAlive()) {

            Writer.writerAndPrinter("\n\n\t --- Fight " + (++kFight) + "\n");

            printDroid(user, enemy);

            user.giveDamage(user.printMenuDroid(), enemy, false);
            BotController.botGiveDamage(enemy, user);

            if (!user.isAlive() && !enemy.isAlive()) {
                return 2;
            } else if (!user.isAlive()) {
                return 1;
            } else if (!enemy.isAlive()) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * getWinner determines the winner
     *
     * @param total array with result in each round
     * @return integer 0 - draw, 1 - user won, 2 - enemy won
     */
    public int getWinner(int[] total) {
        int userScore = 0;
        int enemyScore = 0;

        Writer.writerAndPrinter("\n\n\t\t\t\t\t~~~ Total result ~~~");

        for (int i = 0; i < NUM_ROUNDS; i++) {

            Writer.writerAndPrinter("\nRound " + (i + 1) + ": \t");

            if (total[i] == 0) {
                userScore++;
                Writer.writerAndPrinter("\tWin - " + userDroid.getName());
            } else if (total[i] == 1) {
                enemyScore++;
                Writer.writerAndPrinter("\tWin - " + enemyDroid.getName());
            } else {
                userScore++;
                enemyScore++;
                Writer.writerAndPrinter("\tDraw");
            }
        }

        if (userScore == enemyScore) {
            Writer.writerAndPrinter("\n\n\t\tDRAW - friendship won\n");
            return 0;
        } else {
            Writer.writerAndPrinter("\n\nABSOLUTE CHAMPION is ");

            if (userScore > enemyScore) {
                Writer.writerAndPrinter(userDroid.getName() + "\n");
                return 1;
            } else {
                Writer.writerAndPrinter(enemyDroid.getName() + "\n");
                return 2;
            }
        }
    }

    /**
     * method prints current data about droids
     *
     * @param user  user droid
     * @param enemy enemy droid
     */
    private static void printDroid(Droid user, Droid enemy) {
        Writer.writerAndPrinter("\t\t\t" + user.getName() + " Droid\t\t\tVS\t\t\t" + enemy.getName() + " Droid" +
                "\nHealth: \t   " + String.format("%3d", user.getHealth()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getHealth()) +
                "\nEnergy: \t   " + String.format("%3d", user.getEnergy()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getEnergy()));
    }

    /**
     * User droid getter
     */
    public Droid getUserDroid() {
        return userDroid;
    }

    /**
     * Enemy droid getter
     */
    public Droid getEnemyDroid() {
        return enemyDroid;
    }
}
