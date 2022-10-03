package com.panchuk.taxes.menu;

public class ExitCommand implements MenuItem {
    @Override
    public void execute() {
        System.exit(0);
    }
}
