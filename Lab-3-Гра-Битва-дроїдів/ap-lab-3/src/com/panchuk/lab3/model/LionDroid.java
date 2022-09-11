package com.panchuk.lab3.model;

import java.util.Random;
import java.util.Scanner;

public class LionDroid extends Droid {
    private static final Random random;
    private static final Scanner scan;
    private boolean isUsedSkill;

    static {
        random = new Random();
        scan = new Scanner(System.in);
    }

    public LionDroid() {
        super("Lion", 180, 210);
        isUsedSkill = false;
    }


    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (20 - 40)d -30e
                \t\t\t\t\t2 - hit (5 - 15)d -10e
                Your choice:\040""");
        return scan.nextInt();
    }

    @Override
    public void getDamage(int damage) {
        if (useSkill() != 0)
            this.health -= damage;
    }


    @Override
    public void giveDamage(int type, Droid other) {

        if (type == 1) {
            this.energy -= 30;
            other.getDamage(random.nextInt(20, 41));
        } else {
            this.energy -= 10;
            other.getDamage(random.nextInt(5, 16));
        }
    }


    public int useSkill() {
        if (!isUsedSkill) {
            System.out.print("You can use (input 1) your skill - 'skip damage': ");
            if (scan.nextInt() == 1) {
                isUsedSkill = true;
                return 0;
            }
        }
        return 1;
    }

    @Override
    public void selfHeal(Droid other) {
        this.health += (int) (other.getHealth() * 0.1);
    }

    @Override
    public void adaptationToArea(int idOfArea) {
        switch (idOfArea) {
            case 0: break;
            case 1:
                health = 185;
                energy = 225;
                break;
            case 2:
                health = 177;
                energy = 216;
                break;
            case 3:
                health = 182;
                energy = 222;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Lion Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
