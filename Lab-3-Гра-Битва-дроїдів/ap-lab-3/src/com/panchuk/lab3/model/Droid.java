package com.panchuk.lab3.model;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int energy;
    protected boolean isUsedSkill;

    protected Droid(String name, int health, int energy, boolean isUsedSkill) {
        this.name = name;
        this.health = health;
        this.energy = energy;
        this.isUsedSkill = isUsedSkill;
    }

    public abstract void giveDamage(int type, Droid other);
    public abstract void getDamage(int damage);
    public boolean isAlive() {
        return health > 0 && energy > 0;
    }
    public abstract void adaptationToArea(int idOfArea);
    public abstract int printMenuDroid();

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
