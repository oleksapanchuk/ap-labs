package com.panchuk.lab3.model;

public class SharkDroid extends Droid {

    public SharkDroid() {
        super("Shark", 150, 190);
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
