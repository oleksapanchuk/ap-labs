package com.panchuk.lab3.model;

import com.panchuk.lab3.controller.Randomizer;
import com.panchuk.lab3.controller.Validator;

public class CrocodileDroid extends Droid {
    public CrocodileDroid() {
        super("Crocodile", 300, 230, false);
    }

    @Override
    public void giveDamage(int type, Droid other, boolean isBot) {
        if (type == 1) {
            this.health -= 15;
            this.energy -= 40;
            other.getDamage(Randomizer.getRadomInt(20, 50), !isBot);
        } else {
            this.health -= 8;
            this.energy -= 20;
            other.getDamage(22, !isBot);
        }

        if (!isUsedSkill) {
            if (isBot) {
                if (Randomizer.getRadomInt(1, 2) == 1) {
                    this.health -= 15;
                    this.energy -= 50;
                    other.getDamage(45, false);
                }
            } else {
                if (useSkill()) {
                    this.health -= 15;
                    this.energy -= 50;
                    other.getDamage(45, true);
                }
            }
        }
    }

    @Override
    public void getDamage(int damage, boolean isBot) {
        health -= damage;

        if (this.isAlive())
            health += 6;
    }

    public boolean useSkill() {
        System.out.print("You can use your skill - 'critical damage'." +
                "\nInput '1' if you want, '2' - otherwise: ");
        if (Validator.inputValue(1, 2) == 1) {
            isUsedSkill = true;
            return true;
        }
        return false;
    }

    @Override
    public void adaptationToArea(int idOfArea) {
        switch (idOfArea) {
            case 0 -> {
                health = 300;
                energy = 230;
            }
            case 1 -> {
                health = 310;
                energy = 250;
            }
            case 2 -> {
                health = 297;
                energy = 233;
            }
            case 3 -> {
                health = 316;
                energy = 248;
            }
            default -> throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (20 - 50)d -40e -10h
                \t\t\t\t\t2 - hit  22d        -20e  -8h
                Your choice:\040""");
        return Validator.inputValue(1, 2);
    }

    @Override
    public String toString() {
        return "Crocodile Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
