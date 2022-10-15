package com.panchuk.taxes;

import com.panchuk.taxes.menu.sign_in_menu.SignInMenu;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        SignInMenu menu = new SignInMenu();
        while (true) {
            menu.execute(scanner.nextLine());
        }
    }
}
