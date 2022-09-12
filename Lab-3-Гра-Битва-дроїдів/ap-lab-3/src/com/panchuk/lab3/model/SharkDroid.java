package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class SharkDroid extends Droid {
    public SharkDroid() {
        super("Shark", 150, 190, false);
    }

    @Override
    public void giveDamage(int type, Droid other) {
        if (type == 1) {
            this.energy -= 45;
            other.getDamage(Randomizer.getRadomInt(35, 40));
        } else {
            this.health -= 3;
            this.energy -= 14;
            other.getDamage(Randomizer.getRadomInt(10, 17));
        }
    }

    @Override
    public void getDamage(int damage) {
        health -= damage;

        if (this.isAlive()) {
            health += 7;
            if (useSkill() == 0) health += 75;
        }
    }

    public int useSkill() {
        if (!isUsedSkill) {
            System.out.print("You can use your skill - 'add 75 health'." +
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
                health = 144;
                energy = 190;
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
