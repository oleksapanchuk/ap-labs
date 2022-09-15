package com.panchuk.lab3.controller;

import com.panchuk.lab3.model.Droid;

public class BattleController {
    private static final int NUM_ROUNDS = 2;
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final int area;

    private final StringBuilder info = new StringBuilder();

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
        int[] totalScore = new int[NUM_ROUNDS];
        int kRound = 0;

        for (int i = 0; i < NUM_ROUNDS; i++) {

            initBattle();

            System.out.println("\n-------------- Round " + (i + 1) + " -------------------------------------------------");
            info.append("\n-------------- Round ").append(i + 1).append("-------------------------------------------------\n");

            totalScore[kRound++] = roundRunner(userDroid, enemyDroid);

            System.out.println("----------------------------------------------------------------------------");
            info.append("\n----------------------------------------------------------------------------\n");
        }

        getWinner(totalScore);
    }

    private int roundRunner(Droid user, Droid enemy) {
        int kFight = 0;
        while (user.isAlive() && enemy.isAlive()) {
            System.out.print("\n\t --- Fight " + (++kFight) + "\n");
            info.append("\n\n --- Fight ").append(kFight).append("\n");
            printDroid(user, enemy);

            user.giveDamage(user.printMenuDroid(), enemy);
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

    public void getWinner(int[] total) {
        int userScore = 0;
        int enemyScore = 0;

        System.out.print("\n\n\t\t\t\t\t~~~ Total result ~~~");
        info.append("\n\n\t\t\t\t\t~~~ Total result ~~~");
        for (int i = 0; i < NUM_ROUNDS; i++) {
            System.out.print("\nRound " + (i + 1) + ": \t");
            info.append("\nRound ").append(i + 1).append(": \t");

            if (total[i] == 0) {
                userScore++;
                System.out.print("\tWin - " + userDroid.getName());
                info.append("\tWin - ").append(userDroid.getName());
            } else if (total[i] == 1) {
                enemyScore++;
                System.out.print("\tWin - " + enemyDroid.getName());
                info.append("\tWin - ").append(enemyDroid.getName());
            } else {
                userScore++;
                enemyScore++;
                System.out.print("\tDraw");
                info.append("\tDraw");
            }
        }

        if (userScore == enemyScore) {
            System.out.println("\n\n\t\tDRAW - friendship won");
            info.append("\n\n\t\tDRAW - friendship won\n");
        } else {
            System.out.print("\n\nABSOLUTE CHAMPION is ");
            info.append("\n\nABSOLUTE CHAMPION is ");
            if (userScore > enemyScore) {
                System.out.println(userDroid.getName());
                info.append(userDroid.getName()).append("\n");
            } else {
                System.out.println(enemyDroid.getName());
                info.append(enemyDroid.getName()).append("\n");
            }
        }

    }

    /**
     * method print current data about droids
     *
     * @param user  user droid
     * @param enemy enemy droid
     */
    private void printDroid(Droid user, Droid enemy) {
        String printer = "\t\t\t" + user.getName() + " Droid\t\t\tVS\t\t\t" + enemy.getName() + " Droid" +
                "\nHealth: \t   " + String.format("%3d", user.getHealth()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getHealth()) +
                "\nEnergy: \t   " + String.format("%3d", user.getEnergy()) +
                "\t\t\t\t\t\t\t\t" + String.format("%3d", enemy.getEnergy());
        System.out.println(printer);
        info.append(printer);
    }

    public Droid getUserDroid() {
        return userDroid;
    }

    public Droid getEnemyDroid() {
        return enemyDroid;
    }

    public int getArea() {
        return area;
    }

    public StringBuilder getInfo() {
        return info;
    }
}
