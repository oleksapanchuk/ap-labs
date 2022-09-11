package com.panchuk.lab3.model;

public class SharkDroid extends Droid {

    public SharkDroid() {
        super("Shark", 150, 190);
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
                health -= 6;
                break;
            case 2:
                health += 20;
                energy += 40;
                break;
            case 3:
                health += 2;
                energy += 3;
                break;
            default:
                throw new IllegalStateException("Unexpected id of area: " + idOfArea);
        }
    }

    @Override
    public String toString() {
        return "Shark Droid: \n\t\tHealth = " + health +
                "\n\t\tEnergy = " + energy;
    }
}
