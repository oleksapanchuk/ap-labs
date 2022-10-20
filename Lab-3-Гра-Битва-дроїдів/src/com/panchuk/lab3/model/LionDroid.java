package com.panchuk.lab3.model;

import com.panchuk.lab3.controller.Randomizer;
import com.panchuk.lab3.controller.Validator;

public class LionDroid extends Droid {

    public LionDroid() {
        super("Lion", 180, 210, false);
    }

    @Override
    public void giveDamage(int type, Droid other, boolean isBot) {
        if (type == 1) {
            this.energy -= 24;
            other.getDamage(Randomizer.getRadomInt(20, 30), !isBot);
        } else {
            this.energy -= 10;
            other.getDamage(Randomizer.getRadomInt(5, 15), !isBot);
        }
    }

    @Override
    public void getDamage(int damage, boolean isBot) {
        if (!isUsedSkill) {
            if (isBot) {
                if (Randomizer.getRadomInt(1, 2) == 1) isUsedSkill = true;
                else health -= damage;
            } else {
                if (!useSkill())
                    this.health -= damage;
            }
        }

        if (this.isAlive())
            health += 3;
    }


    public boolean useSkill() {
        System.out.print("You can use your skill - 'skip damage'." +
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
                health = 180;
                energy = 210;
            }
            case 1 -> {
                health = 190;
                energy = 225;
            }
            case 2 -> {
                health = 177;
                energy = 216;
            }
            case 3 -> {
                health = 182;
                energy = 222;
            }
            default -> throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (20 - 30)d -24e
                \t\t\t\t\t2 - hit  (5 - 15)d  -10e
                Your choice:\040""");
        return Validator.inputValue(1, 2);
    }

    @Override
    public String toString() {
        return "Lion Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
