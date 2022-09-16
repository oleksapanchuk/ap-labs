package com.panchuk.lab3.controller;

public class Writer {
    public static final StringBuilder info = new StringBuilder();
    public static final StringBuilder infoBot = new StringBuilder();

    /**
     * writerAndPrinter method prints into console & appends info about battle to info
     */
    public static void writerAndPrinter(String str) {
        System.out.print(str);
        info.append(str);
    }

    /**
     * writerBotBattle method appends info about battle to infoBot
     */
    public static void writerBotBattle(String str) {
        infoBot.append(str);
    }

    /**
     * numBotBattle method appends info about battle number to infoBot
     */
    public static void numBotBattle(int battleNum) {
        infoBot.append("\n\n------------ BOT BATTLE ")
                .append(battleNum)
                .append(" --------------------------------\n\n");
    }
}
