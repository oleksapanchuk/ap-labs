package com.panchuk.lab3.model;

public class ScorpionDroid extends Droid {

    public ScorpionDroid() {
        super("Scorpion", 100, 195);
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
