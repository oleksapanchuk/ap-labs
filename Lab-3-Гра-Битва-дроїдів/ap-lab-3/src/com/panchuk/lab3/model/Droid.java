package com.panchuk.lab3.model;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int energy;

    protected Droid(String name, int health, int energy) {
        this.name = name;
        this.health = health;
        this.energy = energy;
    }

    public abstract void getDamage(int damage);
    public abstract int giveDamage(int damage, Droid other);
    public abstract int useSkill(Droid other);
    public abstract void selfHeal(Droid other);
    public boolean isAlive() {
        return health > 0 && energy > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getEnergy() {
        return energy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", energy=" + energy +
                '}';
    }
}
