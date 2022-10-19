package com.panchuk.taxes.menu.main_menu;

import com.panchuk.taxes.menu.MenuItem;

public class ExitCommand implements MenuItem {
    @Override
    public void execute() {
        System.exit(0);
    }
}
