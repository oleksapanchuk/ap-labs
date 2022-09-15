package com.panchuk.lab3;

public class Writer {
    public static final StringBuilder info = new StringBuilder();

    public static void writerAndPrinter(String str) {
        System.out.print(str);
        info.append(str);
    }
}
