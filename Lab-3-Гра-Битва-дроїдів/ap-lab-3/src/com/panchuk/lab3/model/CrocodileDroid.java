package com.panchuk.lab3.model;

public class CrocodileDroid extends Droid {

    public CrocodileDroid() {
        super("Crocodile", 300, 230);
    }

    @Override
    public int bite() {
        return 0;
    }

    @Override
    public int hit() {
        return 0;
    }

    @Override
    public void skill() {

    }

    @Override
    public void selfHeal(Droid enemy) {

    }
}
