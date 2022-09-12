package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class ScorpionDroid extends Droid {

    public ScorpionDroid() {
        super("Scorpion", 100, 195, false);
    }

    @Override
    public void giveDamage(int type, Droid other) {
        if (type == 1) {
            if (useSkill() != 0)
                this.energy -= 55;
            this.health -= 10;
            other.getDamage(Randomizer.getRadomInt(50, 60));
        } else {
            this.energy -= 8;
            other.getDamage(Randomizer.getRadomInt(4, 10));
        }
    }

    @Override
    public void getDamage(int damage) {
        health -= damage;

        if (this.isAlive())
            health += 15;       // self-heal
    }

    public int useSkill() {
        if (!isUsedSkill) {
            System.out.print("You can use your skill - 'sting without lose energy'. " +
                    "\nInput '1' if you want, '2' - otherwise: ");
            if (Validator.inputValue(1, 2) == 1) {
                isUsedSkill = true;
                return 0;
            }
        }
        return 1;
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
