package com.panchuk.lab3.controller;

import java.util.Random;

public class Randomizer {
    private static final Random random;
    static {
        random = new Random();
    }

    public static int getRadomInt(int origin, int bound) {
        return random.nextInt(origin, bound + 1);
    }
}
