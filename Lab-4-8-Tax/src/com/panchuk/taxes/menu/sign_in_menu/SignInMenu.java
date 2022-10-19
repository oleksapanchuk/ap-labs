package com.panchuk.taxes.menu.sign_in_menu;

import com.panchuk.taxes.menu.main_menu.ExitCommand;
import com.panchuk.taxes.menu.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class SignInMenu {
    private final Map<String, MenuItem> menuItems;

    public SignInMenu() {
        menuItems = new LinkedHashMap<>();
        menuItems.put("sign up", new SignUpCommand());
        menuItems.put("sign in", new SignInCommand());
        menuItems.put("exit", new ExitCommand());
    }

    public void execute(String command) {
        menuItems.getOrDefault(command, () -> System.out.print("Incorrect command! Try again: ")).execute();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Sign in menu:");
        menuItems.forEach((nameCommand, menuItem) -> sb.append("\n\t").append(nameCommand));
        sb.append("\nYour choice: ");
        return sb.toString();
    }
}
