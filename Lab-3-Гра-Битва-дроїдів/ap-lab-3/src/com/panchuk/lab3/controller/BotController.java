package com.panchuk.lab3.controller;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.model.Droid;

import java.util.Random;

public class BotController {
    private static final Random random;

    static {
        random = new Random();
    }

    public static void botGiveDamage(Droid enemy, Droid user) {
        if (random.nextInt(1,3) == 1) enemy.giveDamage(1, user);
        else enemy.giveDamage(2, user);
    }
}
