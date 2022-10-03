package com.panchuk.taxes;

import com.panchuk.taxes.menu.MainMenu;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        while (true) {
            menu.execute(scanner.nextLine());
        }
    }
}
