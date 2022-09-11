package com.panchuk.lab3.model;

import java.util.Random;
import java.util.Scanner;

public class SnakeDroid extends Droid {
    private static final Random random;
    private static final Scanner scan;
    private boolean isUsedSkill;

    static {
        random = new Random();
        scan = new Scanner(System.in);
    }

    public SnakeDroid() {
        super("Snake", 260, 260);
        this.isUsedSkill = false;
    }

    @Override
    public void getDamage(int damage) {
//        if (useSkill(null) == 0)
        this.health -= damage;
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - snakebite (30 - 70)d -80e
                \t\t\t\t\t2 - choke (1 - 25)d -12e -8h
                Your choice:\040""");
        return scan.nextInt();
    }
    @Override
    public void giveDamage(int type, Droid other) {

        if (type == 1) {
            this.energy -= 80;
            other.getDamage(random.nextInt(30, 71));
        } else {
            this.energy -= 12;
            this.health -= 8;
            other.getDamage(random.nextInt(1, 26));
        }
    }


    public int useSkill() {
        if (!isUsedSkill) {
            isUsedSkill = true;
            health += 20;
            return 1;
        } else
            return 0;
    }

    @Override
    public void selfHeal(Droid enemy) {
        this.health += 2;
    }

    @Override
    public void adaptationToArea(int idOfArea) {
        switch (idOfArea) {
            case 0: break;
            case 1:
                health = 270;
                energy = 295;
                break;
            case 2:
                health = 245;
                energy = 262;
                break;
            case 3:
                health = 266;
                energy = 270;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Snake Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
