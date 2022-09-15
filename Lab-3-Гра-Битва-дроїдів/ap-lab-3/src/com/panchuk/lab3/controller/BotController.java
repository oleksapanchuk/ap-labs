package com.panchuk.lab3.controller;

import com.panchuk.lab3.Randomizer;
import com.panchuk.lab3.model.Droid;

public class BotController {

    public static void botGiveDamage(Droid enemy, Droid user) {
        if (Randomizer.getRadomInt(1, 2) == 1) enemy.giveDamage(1, user, true);
        else enemy.giveDamage(2, user, true);
    }
}
