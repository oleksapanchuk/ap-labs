package com.panchuk.lab3.controller;

import com.panchuk.lab3.model.Droid;

public class BattleInfo {
    private final Droid userDroid;
    private final Droid enemyDroid;
    private final String userName;
    private final int area;

    public BattleInfo(Droid userDroid, Droid enemyDroid, String userName, int area) {
        this.userDroid = userDroid;
        this.enemyDroid = enemyDroid;
        this.userName = userName;
        this.area = area;
    }

    public Droid getUserDroid() {
        return userDroid;
    }

    public Droid getEnemyDroid() {
        return enemyDroid;
    }

    public String getUserName() {
        return userName;
    }

    public int getArea() {
        return area;
    }




    @Override
    public String toString() {
        return "BattleInfo{" +
                "userDroid=" + userDroid +
                ", enemyDroid=" + enemyDroid +
                ", userName='" + userName + '\'' +
                ", area=" + area +
                '}';
    }
}
