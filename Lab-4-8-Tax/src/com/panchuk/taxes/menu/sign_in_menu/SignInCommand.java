package com.panchuk.taxes.menu.sign_in_menu;

import com.panchuk.taxes.menu.MenuItem;

public class SignInCommand implements MenuItem {

    @Override
    public void execute() {
        System.out.println("Sign In there!");
    }
}
