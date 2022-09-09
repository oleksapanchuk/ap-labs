package com.panchuk.lab3.controller;

import com.panchuk.lab3.Area;
import com.panchuk.lab3.model.*;

public class BattleController {
    private static BattleInfo battleInfo;


    public static void initBattle(int idUserDroid, int idEnemyDroid, String userName, int idArea) {

        battleInfo = new BattleInfo(
                Area.createNewDroid(idUserDroid, idArea),
                Area.createNewDroid(idEnemyDroid, idArea),
                userName,
                idArea
        );

        System.out.println(battleInfo);

        System.out.println(battleInfo.getUserDroid().hit());


    }

    public static Droid runBattle() {
        int scoreUser = 0;
        int scoreEnemy = 0;

        for (int i = 0; i < 12; i++) {

            System.out.println("\n\t\t--- Round 1");
            if (roundRunner() != 0) {
                scoreUser++;
                System.out.println("Win User Droid");
            } else {
                scoreEnemy++;
                System.out.println("Win Enemy Droid");
            }
        }
        return null;
    }

    private static int roundRunner() {

        return 0;
    }



    public static Droid getWinner() {
        return null;
    }

    public static void main(String[] args) {
        initBattle(1, 2, "Mike", 2);
    }

}
