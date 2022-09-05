package com.panchuk.lab3.model;

public class SnakeDroid extends Droid {

    public SnakeDroid() {
        super("Snake", 260, 260);
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
