package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class CrocodileDroid extends Droid {
    public CrocodileDroid() {
        super("Crocodile", 300, 230, false);
    }

    @Override
    public void giveDamage(int type, Droid other) {
        if (type == 1) {
            this.health -= 15;
            this.energy -= 40;
            other.getDamage(Randomizer.getRadomInt(20, 50));
        } else {
            this.health -= 8;
            this.energy -= 20;
            other.getDamage(22);
        }
        if (useSkill() == 0) {
            this.health -= 15;
            this.energy -= 50;
            other.getDamage(45);
        }
    }

    @Override
    public void getDamage(int damage) {
        health -= damage;

        if (this.isAlive())
            health += 6;
    }

    public int useSkill() {
        if (!isUsedSkill) {
            System.out.print("You can use your skill - 'critical damage'." +
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
                health = 310;
                energy = 250;
                break;
            case 2:
                health = 297;
                energy = 233;
                break;
            case 3:
                health = 316;
                energy = 248;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
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
