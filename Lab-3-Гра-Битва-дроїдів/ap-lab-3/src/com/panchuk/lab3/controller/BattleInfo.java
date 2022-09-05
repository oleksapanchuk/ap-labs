package com.panchuk.lab3.controller;

import com.panchuk.lab3.Area;
import com.panchuk.lab3.model.*;

public class BattleInfo {
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final String userName;
    private final int area;

    public BattleInfo(int userDroid, int enemyDroid, String userName, int area) {
        this.userName = userName;
        this.area = area;
        this.userDroid = areaProp(userDroid);
        this.enemyDroid = areaProp(enemyDroid);
    }

    public Droid areaProp(int idDroid) {

        switch (idDroid) {
            case 1 -> {
                LionDroid lionDroid = new LionDroid();
                Area.setPropForLion(lionDroid, area);
                System.out.println("Lion Droid prepared for battle!");
                return lionDroid;
            }
            case 2 -> {
                ScorpionDroid scorpionDroid = new ScorpionDroid();
                Area.setPropForScorpion(scorpionDroid, area);
                System.out.println("Scorpion Droid prepared for battle!");
                return scorpionDroid;
            }
            case 3 -> {
                SnakeDroid snakeDroid = new SnakeDroid();
                Area.setPropForSnake(snakeDroid, area);
                System.out.println("Snake Droid prepared for battle!");
                return snakeDroid;
            }
            case 4 -> {
                CrocodileDroid crocodileDroid = new CrocodileDroid();
                Area.setPropForCrocodile(crocodileDroid, area);
                System.out.println("Crocodile Droid prepared for battle!");
                return crocodileDroid;
            }
            case 5 -> {
                SharkDroid sharkDroid = new SharkDroid();
                Area.setPropForShark(sharkDroid, area);
                System.out.println("Shark Droid prepared for battle!");
                return sharkDroid;
            }
            default -> {
                System.out.println("Not working!");
                return null;
            }

        }

    }


}
