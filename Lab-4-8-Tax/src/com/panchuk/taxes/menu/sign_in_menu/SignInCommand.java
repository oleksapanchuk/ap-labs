package com.panchuk.taxes.menu.sign_in_menu;

import com.panchuk.taxes.Validator;
import com.panchuk.taxes.controller.MainController;
import com.panchuk.taxes.menu.MenuItem;
import com.panchuk.taxes.storage.UserStorage;
import com.panchuk.taxes.user.User;

public class SignInCommand implements MenuItem {

    @Override
    public void execute() {
        MainController mc = new MainController();

        String login = Validator.inputString("login", Validator.VALID_LOGIN);
        String password = Validator.inputString("password", Validator.VALID_PASSWORD);

        User user = UserStorage.findUser(login, password);
        if (user == null) {
            System.out.println("The login or password is incorrect! Try again!!!");
            execute();
        }
        else
            mc.initUser(user);
    }
}
