package com.panchuk.lab3.model;

import java.util.Random;
import java.util.Scanner;

public class SnakeDroid extends Droid {
    private static final Random random;
    private static final Scanner scan;
    private boolean isUsedSkill;

    static {
        random = new Random();
        scan = new Scanner(System.in);
    }

    public SnakeDroid() {
        super("Snake", 260, 260);
        this.isUsedSkill = false;
    }

    @Override
    public void getDamage(int damage) {
        if (useSkill(null) == 0)
            this.health -= damage;
    }

    @Override
    public int giveDamage(int damage, Droid other) {

        System.out.print("Choose variant of damage: 1 - snakebite; 2 - choke: ");
        if (scan.nextInt() == 1) {
            this.energy -= 80;
            other.getDamage(random.nextInt(30, 71));
        } else {
            this.energy -= 12;
            this.health -= 8;
            other.getDamage(random.nextInt(1, 26));
        }

        return 0;
    }

    @Override
    public int useSkill(Droid other) {
        return 0;
    }

    @Override
    public void selfHeal(Droid enemy) {

    }
}
