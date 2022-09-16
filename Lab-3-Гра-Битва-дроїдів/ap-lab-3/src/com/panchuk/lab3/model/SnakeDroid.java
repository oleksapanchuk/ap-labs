package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class SnakeDroid extends Droid {

    public SnakeDroid() {
        super("Snake", 260, 260, false);
    }

    @Override
    public void giveDamage(int type, Droid other, boolean isBot) {

        if (type == 1) {
            this.energy -= 65;
            other.getDamage(Randomizer.getRadomInt(30, 70), isBot);
        } else {
            this.energy -= 12;
            this.health -= 8;
            other.getDamage(Randomizer.getRadomInt(1, 25), isBot);
        }
    }

    @Override
    public void getDamage(int damage, boolean isBot) {
        if (!isUsedSkill && damage > 40) {
            if (isBot) {
                if (Randomizer.getRadomInt(1, 2) == 1) isUsedSkill = true;
                else health -= damage;
            } else
                if (!useSkill())
                    health -= damage;
        } else
            health -= damage;


        if (this.isAlive())
            health += 4;
    }

    public boolean useSkill() {
        System.out.print("You can use your skill - 'skip damage if it is more then 40'." +
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
                health = 260;
                energy = 260;
            }
            case 1 -> {
                health = 270;
                energy = 295;
            }
            case 2 -> {
                health = 245;
                energy = 262;
            }
            case 3 -> {
                health = 266;
                energy = 270;
            }
            default -> throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public int printMenuDroid() {
        System.out.print("""
                
                Choose variant of damage:\s
                \t\t\t\t\t1 - snakebite (30 - 70)d -65e
                \t\t\t\t\t2 - choke     (1 - 25)d  -12e -8h
                Your choice:\040""");
        return Validator.inputValue(1, 2);
    }

    @Override
    public String toString() {
        return "Snake Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
