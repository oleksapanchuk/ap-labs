package com.panchuk.taxes.user;

public class Admin extends User {

    public Admin(String fullName, String login, String email, String password, String dateOfBirth) {
        super(fullName, login, email, password, dateOfBirth);
    }

    @Override
    public String toString() {
        return "Admin";
    }
}
