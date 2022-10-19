package com.panchuk.taxes.menu.main_menu;

import com.panchuk.taxes.menu.MenuItem;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainMenu {
    private final Map<String, MenuItem> menuItems;

    public MainMenu() {
        menuItems = new LinkedHashMap<>();
        menuItems.put("exit", new ExitCommand());
    }

    public void execute(String command) {
        menuItems.getOrDefault(command, () -> System.out.print("Incorrect command! Try again: ")).execute();
    }


}
