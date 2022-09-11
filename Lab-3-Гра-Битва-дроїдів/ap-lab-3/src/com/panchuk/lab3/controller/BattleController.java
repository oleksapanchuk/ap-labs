package com.panchuk.lab3.controller;

import com.panchuk.lab3.model.*;

public class BattleController {
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final String userName;
    private final int area;

    public BattleController(Droid userDroid, Droid enemyDroid, String userName, int area) {
        this.userDroid = userDroid;
        this.enemyDroid = enemyDroid;
        this.userName = userName;
        this.area = area;
    }

    public void initBattle() {
        userDroid.adaptationToArea(area);
        enemyDroid.adaptationToArea(area);

        printDroid(userDroid, enemyDroid);
    }

    public void runBattle() {
        int scoreUser = 0;
        int scoreEnemy = 0;

        for (int i = 0; i < 4; i++) {

            System.out.println("\n\t\t--- Round " + (i + 1));
            int resultOfRound = roundRunner(userDroid, enemyDroid);
            if (resultOfRound == 0) {
                scoreUser++;
                System.out.println("Win " + userDroid.getName());
            } else if (resultOfRound == 1) {
                scoreEnemy++;
                System.out.println("Win " + userDroid.getName());
            } else {
                scoreUser++;
                scoreEnemy++;
                System.out.println("Draw!");
            }
        }
    }

    private static int roundRunner(Droid user, Droid enemy) {

        while (user.isAlive() && enemy.isAlive()) {

            user.giveDamage(enemy);
            enemy.giveDamage(user);

            if (!user.isAlive() && !enemy.isAlive()) {
                return 2;
            } else if (!user.isAlive() ) {
                return 1;
            } else if (!enemy.isAlive()) {
                return 0;
            }

            printDroid(user, enemy);
        }
        return -1;
    }



    public static Droid getWinner() {
        return null;
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

        BattleController newBattle = new BattleController(ud, ed, "Men", 0);


        System.out.println("\t\t\t\t~~~ Droids are ready for battle!!! ~~~");
        newBattle.initBattle();
        System.out.println("\n\t\t\t\t\t\t\t~~~ START ~~~");
        newBattle.runBattle();

        printDroid(ud, ed);

    }

}
