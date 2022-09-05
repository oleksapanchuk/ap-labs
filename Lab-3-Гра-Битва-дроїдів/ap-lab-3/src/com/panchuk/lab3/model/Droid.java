package com.panchuk.lab3.model;

public class Droid {
    private String name;
    private int health;
    private int energy;

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", energy=" + energy +
                '}';
    }
}
