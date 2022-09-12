package com.panchuk.lab3.model;

import com.panchuk.lab3.Validator;

import java.util.Scanner;

public class ScorpionDroid extends Droid {
    private static final Scanner scan = new Scanner(System.in);

    public ScorpionDroid() {
        super("Scorpion", 100, 195);
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (50 - 60)d -80e -10h
                \t\t\t\t\t2 - hit (3 - 5)d -4e
                Your choice:\040""");
        return Validator.inputValue(1, 2);
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
                health = 160;
                energy = 215;
                break;
            case 2:
                health = 104;
                energy = 190;
                break;
            case 3:
                health = 116;
                energy = 199;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Scorpion Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
