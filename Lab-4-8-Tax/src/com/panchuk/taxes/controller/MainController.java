package com.panchuk.taxes.controller;

import com.panchuk.taxes.user.User;

public class MainController {
    private User user;

    public void initUser(User user) {
        this.user = user;
        execute();
    }

    private void execute() {
        System.out.println("\n\nMAIN PROGRAM\n\n");
    }

}
