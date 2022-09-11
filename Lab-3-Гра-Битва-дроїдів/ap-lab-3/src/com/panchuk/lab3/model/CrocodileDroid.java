package com.panchuk.lab3.model;

import java.util.Scanner;

public class CrocodileDroid extends Droid {
    private static final Scanner scan = new Scanner(System.in);
    public CrocodileDroid() {
        super("Crocodile", 300, 230);
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (20 - 60)d -10h
                \t\t\t\t\t2 - hit 22d -20e -8h
                Your choice:\040""");
        return scan.nextInt();
    }

    @Override
    public void getDamage(int damage) {
        this.health -= damage;
    }

    @Override
    public void giveDamage(int type, Droid other) {
        return;
    }

    public int useSkill() {
        return 0;
    }

    @Override
    public void selfHeal(Droid other) {
        return;
    }

    @Override
    public void adaptationToArea(int idOfArea) {
        switch (idOfArea) {
            case 0: break;
            case 1:
                health = 310;
                energy = 250;
                break;
            case 2:
                health = 297;
                energy = 227;
                break;
            case 3:
                health = 316;
                energy = 248;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Crocodile Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
