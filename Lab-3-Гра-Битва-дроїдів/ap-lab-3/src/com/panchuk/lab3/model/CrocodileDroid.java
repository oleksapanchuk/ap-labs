package com.panchuk.lab3.model;

public class CrocodileDroid extends Droid {

    public CrocodileDroid() {
        super("Crocodile", 300, 230);
    }

    @Override
    public void getDamage(int damage) {
        return;
    }

    @Override
    public int giveDamage(Droid other) {
        return 0;
    }

    @Override
    public int useSkill(Droid other) {
        return 0;
    }

    @Override
    public void selfHeal(Droid other) {
        return;
    }

    @Override
    public void adaptationToArea(int idOfArea) {
        switch (idOfArea) {
            case 0: break;
            case 1:
                health += 10;
                energy += 20;
                break;
            case 2:
                health -= 3;
                energy -= 3;
                break;
            case 3:
                health += 16;
                energy += 18;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Crocodile Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
