package com.panchuk.lab3;

import com.panchuk.lab3.model.*;

public class Area {

    public static void setPropForLion(LionDroid droid, int idArea) {
        switch (idArea) {
            case 1 -> {
                droid.setHealth(185);
                droid.setEnergy(225);
            }
            case 2 -> {
                droid.setHealth(177);
                droid.setEnergy(216);
            }
            case 3 -> {
                droid.setHealth(182);
                droid.setEnergy(222);
            }
            default -> throw new IllegalStateException("Unexpected value: " + idArea);
        }
    }

    public static void setPropForScorpion(ScorpionDroid droid, int idArea) {
        switch (idArea) {
            case 1 -> {
                droid.setHealth(160);
                droid.setEnergy(215);
            }
            case 2 -> {
                droid.setHealth(104);
                droid.setEnergy(190);
            }
            case 3 -> {
                droid.setHealth(116);
                droid.setEnergy(199);
            }
            default -> throw new IllegalStateException("Unexpected value: " + idArea);
        }
    }

    public static void setPropForSnake(SnakeDroid droid, int idArea) {
        switch (idArea) {
            case 1 -> {
                droid.setHealth(270);
                droid.setEnergy(295);
            }
            case 2 -> {
                droid.setHealth(245);
                droid.setEnergy(262);
            }
            case 3 -> {
                droid.setHealth(270);
                droid.setEnergy(266);
            }
            default -> throw new IllegalStateException("Unexpected value: " + idArea);
        }
    }

    public static void setPropForCrocodile(CrocodileDroid droid, int idArea) {
        switch (idArea) {
            case 1 -> {
                droid.setHealth(310);
                droid.setEnergy(250);
            }
            case 2 -> {
                droid.setHealth(297);
                droid.setEnergy(233);
            }
            case 3 -> {
                droid.setHealth(316);
                droid.setEnergy(248);
            }
            default -> throw new IllegalStateException("Unexpected value: " + idArea);
        }
    }

    public static void setPropForShark(SharkDroid droid, int idArea) {
        switch (idArea) {
            case 1 -> {
                droid.setHealth(144);
                droid.setEnergy(190);
            }
            case 2 -> {
                droid.setHealth(170);
                droid.setEnergy(230);
            }
            case 3 -> {
                droid.setHealth(152);
                droid.setEnergy(193);
            }
            default -> throw new IllegalStateException("Unexpected value: " + idArea);
        }
    }
}
