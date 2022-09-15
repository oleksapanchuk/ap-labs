package com.panchuk.lab3.model;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.Validator;

public class LionDroid extends Droid {

    public LionDroid() {
        super("Lion", 180, 210, false);
    }

    @Override
    public void giveDamage(int type, Droid other) {
        if (type == 1) {
            this.energy -= 24;
            other.getDamage(Randomizer.getRadomInt(20, 30));
        } else {
            this.energy -= 10;
            other.getDamage(Randomizer.getRadomInt(5, 15));
        }
    }

    @Override
    public void getDamage(int damage) {
        if (useSkill() != 0)
            this.health -= damage;

        if (this.isAlive())
            health += 3;
    }




    public int useSkill() {
        if (!isUsedSkill) {
            System.out.print("You can use your skill - 'skip damage'." +
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
                health = 190;
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
