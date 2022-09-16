package com.panchuk.lab3.controller;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Writer;
import com.panchuk.lab3.model.Droid;

public class BotController {
    private static final int NUM_ROUNDS = 5;

    /**
     * botGiveDamage give random damage to enemy
     */
    public static void botGiveDamage(Droid enemy, Droid user) {
        if (Randomizer.getRadomInt(1, 2) == 1) enemy.giveDamage(1, user, true);
        else enemy.giveDamage(2, user, true);
    }

    /**
     * initBattle method gives the characteristics of the droid
     * depending on its type and the battle area
     */
    private static void initBattle(Droid bot1, Droid bot2, int area) {
        bot1.adaptationToArea(area);
        bot2.adaptationToArea(area);
    }

    /**
     * botVSBot - main method of the controller that triggers
     * the execution of battle rounds
     * <p>
     * method invokes roundRunner method that execute each round
     */
    public static int botVSBot(Droid bot1, Droid bot2, int area) {
        int[] totalScore = new int[NUM_ROUNDS];
        int kRound = 0;

        for (int i = 0; i < NUM_ROUNDS; i++) {
            initBattle(bot1, bot2, area);

            Writer.writerBotBattle("\n-------- Round " + (i + 1) + " ------------------------------------------\n");

            totalScore[kRound++] = roundRunner(bot1, bot2);

            Writer.writerBotBattle("\n----------------------------------------------------------\n");
        }

        return getWinner(totalScore, bot1, bot2);
    }

    /**
     * roundRunner performs each fight of the round
     *
     * @return integer - id of winner 2 - draw, 1 - user won, 2 - enemy won
     */
    private static int roundRunner(Droid bot1, Droid bot2) {
        int kFight = 0;
        while (bot1.isAlive() && bot2.isAlive()) {

            Writer.writerBotBattle("\n\n\t --- Fight " + (++kFight) + "\n");

            botGiveDamage(bot1, bot2);
            botGiveDamage(bot2, bot1);

            printDroid(bot1, bot2);

            if (!bot1.isAlive() && !bot2.isAlive()) {
                return 2;
            } else if (!bot1.isAlive()) {
                return 1;
            } else if (!bot2.isAlive()) {
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
    private static int getWinner(int[] total, Droid bot1, Droid bot2) {
        int userScore = 0;
        int enemyScore = 0;

        Writer.writerBotBattle("\n\n\t\t\t\t\t~~~ Total result ~~~");

        for (int i = 0; i < NUM_ROUNDS; i++) {

            Writer.writerBotBattle("\nRound " + (i + 1) + ": \t");

            if (total[i] == 0) {
                userScore++;
                Writer.writerBotBattle("\tWin - " + bot1.getName());
            } else if (total[i] == 1) {
                enemyScore++;
                Writer.writerBotBattle("\tWin - " + bot2.getName());
            } else {
                userScore++;
                enemyScore++;
                Writer.writerBotBattle("\tDraw");
            }
        }

        if (userScore == enemyScore) {
            Writer.writerBotBattle("\n\n\t\tDRAW - friendship won\n");
            return 0;

        } else {
            Writer.writerBotBattle("\n\nABSOLUTE CHAMPION is ");

            if (userScore > enemyScore) {
                Writer.writerBotBattle(bot1.getName() + "\n");
                return 1;
            } else {
                Writer.writerBotBattle(bot2.getName() + "\n");
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
        Writer.writerBotBattle("\t\t\t" + user.getName() + " Droid\t\t\tVS\t\t\t" + enemy.getName() + " Droid" +
                "\nHealth: \t   " + String.format("%3d", user.getHealth()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getHealth()) +
                "\nEnergy: \t   " + String.format("%3d", user.getEnergy()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getEnergy()));
    }
}