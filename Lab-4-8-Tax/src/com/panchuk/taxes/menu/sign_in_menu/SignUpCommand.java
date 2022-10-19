package com.panchuk.taxes.menu.sign_in_menu;

import com.panchuk.taxes.menu.MenuItem;
import com.panchuk.taxes.storage.UserStorage;
import com.panchuk.taxes.user.UserController;

public class SignUpCommand implements MenuItem {

    @Override
    public void execute() {
        UserStorage.addUser(UserController.createUserInConsole());
        System.out.println("You have successfully registered!");
    }
}
