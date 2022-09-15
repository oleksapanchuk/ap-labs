package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class ScorpionDroid extends Droid {

    public ScorpionDroid() {
        super("Scorpion", 100, 195, false);
    }

    @Override
    public void giveDamage(int type, Droid other, boolean isBot) {
        if (type == 1) {                                                                    // if sting
            if (!isUsedSkill) {                                                             // and not used skill
                if (isBot) {
                    if (Randomizer.getRadomInt(1, 2) == 1) isUsedSkill = true;
                    else energy -= 55;
                } else
                    if (!useSkill())
                        energy -= 55;
            } else {
                energy -= 55;
            }

            this.health -= 10;
            other.getDamage(Randomizer.getRadomInt(50, 60), isBot);
        } else {
            this.energy -= 8;
            other.getDamage(Randomizer.getRadomInt(4, 10), isBot);
        }
    }

    @Override
    public void getDamage(int damage, boolean isBot) {
        health -= damage;

        if (this.isAlive())
            health += 15;
    }

    public boolean useSkill() {
        System.out.print("You can use your skill - 'sting without lose energy'. " +
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
                health = 100;
                energy = 195;
            }
            case 1 -> {
                health = 160;
                energy = 215;
            }
            case 2 -> {
                health = 104;
                energy = 190;
            }
            case 3 -> {
                health = 116;
                energy = 199;
            }
            default -> throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                Choose variant of damage:\s
                \t\t\t\t\t1 - bite (50 - 60)d -55e -10h
                \t\t\t\t\t2 - hit  (4 - 10)d   -8e
                Your choice:\040""");
        return Validator.inputValue(1, 2);
    }

    @Override
    public String toString() {
        return "Scorpion Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
