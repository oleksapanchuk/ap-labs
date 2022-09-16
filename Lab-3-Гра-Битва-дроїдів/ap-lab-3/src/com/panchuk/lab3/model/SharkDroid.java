package com.panchuk.lab3.model;

import com.panchuk.lab3.controller.Randomizer;
import com.panchuk.lab3.controller.Validator;

public class SharkDroid extends Droid {
    public SharkDroid() {
        super("Shark", 150, 190, false);
    }

    @Override
    public void giveDamage(int type, Droid other, boolean isBot) {
        if (type == 1) {
            this.energy -= 45;
            other.getDamage(Randomizer.getRadomInt(35, 40), !isBot);
        } else {
            this.health -= 3;
            this.energy -= 14;
            other.getDamage(Randomizer.getRadomInt(10, 17), !isBot);
        }
    }

    @Override
    public void getDamage(int damage, boolean isBot) {
        health -= damage;

        if (this.isAlive()) {
            health += 7;

            if (!isUsedSkill) {
                if (isBot) {
                    if (Randomizer.getRadomInt(1, 2) == 1) {
                        health += 75;
                        isUsedSkill = true;
                    }
                }
                else
                    if (useSkill()) health += 75;
            }
        }
    }

    public boolean useSkill() {
        System.out.print("You can use your skill - 'add 75 health'." +
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
                health = 150;
                energy = 190;
            }
            case 1 -> {
                health = 144;
                energy = 190;
            }
            case 2 -> {
                health = 170;
                energy = 230;
            }
            case 3 -> {
                health = 152;
                energy = 193;
            }
            default -> throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (35 - 40)d -45e
                \t\t\t\t\t2 - hit  (10 - 17)d -14e -3h
                Your choice:\040""");
        return Validator.inputValue(1, 2);
    }

    @Override
    public String toString() {
        return "Shark Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
