package com.panchuk.lab3.model;

import java.util.Random;

public class LionDroid extends Droid {
    private static final Random random;

    static {
        random = new Random();
    }

    public LionDroid() {
        super("Lion", 180, 210);
    }

    public int bite() {
        this.energy -= 30;
        return random.nextInt(20, 41);
    }

    public int hit() {
        this.energy -= 10;
        return random.nextInt(5, 16);
    }

    public void skill() {

    }

    public void selfHeal(Droid enemy) {
        this.health += (int) (enemy.getHealth() * 0.1);
    }


}
