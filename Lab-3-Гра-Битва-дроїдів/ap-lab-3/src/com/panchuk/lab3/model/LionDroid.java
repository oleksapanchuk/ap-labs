package com.panchuk.lab3.model;

import java.util.Random;
import java.util.Scanner;

public class LionDroid extends Droid {
    private static final Random random;
    private static final Scanner scan;
    private boolean isUsedSkill;

    static {
        random = new Random();
        scan = new Scanner(System.in);
    }

    public LionDroid() {
        super("Lion", 180, 210);
        isUsedSkill = false;
    }

    @Override
    public void getDamage(int damage) {
        if (useSkill(null) == 0)
            this.health -= damage;
    }

    @Override
    public int giveDamage(int damage, Droid other) {

        System.out.print("Choose variant of damage: 1 - bite; 2 - hit: ");
        if (scan.nextInt() == 1) {
            this.energy -= 30;
            other.getDamage(random.nextInt(20, 41));
        } else {
            this.energy -= 10;
            other.getDamage(random.nextInt(5, 16));
        }

        return 0;
    }

    @Override
    public int useSkill(Droid other) {
        if (!isUsedSkill) {
            System.out.print("You can use (input 1) your skill - 'skip damage': ");
            if (scan.nextInt() == 1) {
                isUsedSkill = true;
                return 0;
            }
        }
        return 1;
    }

    @Override
    public void selfHeal(Droid other) {
        this.health += (int) (other.getHealth() * 0.1);
    }
}
