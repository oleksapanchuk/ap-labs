package com.panchuk.lab3.model;

import java.util.Scanner;

public class SharkDroid extends Droid {
    private static final Scanner scan = new Scanner(System.in);
    public SharkDroid() {
        super("Shark", 150, 190);
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (35 - 40)d -45e
                \t\t\t\t\t2 - hit (10 - 17)d -14e -3h
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
                health = 144;
                energy = 230;
                break;
            case 2:
                health = 170;
                energy = 230;
                break;
            case 3:
                health = 152;
                energy = 193;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Shark Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
