package com.panchuk.taxes.user;

import com.panchuk.taxes.menu.main_menu.ExitCommand;
import com.panchuk.taxes.menu.MenuItem;
import com.panchuk.taxes.tax.Tax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    private String fullName;
    private String login;
    private String email;
    private String password;
    private String dateOfBirth;
    private List<Tax> taxes;

    public User(String fullName, String login, String email, String password, String dateOfBirth) {
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        taxes = new ArrayList<>();
    }

    public Map<String, MenuItem> getAvailableCommands() {
        Map<String, MenuItem> mI = new HashMap<>();

        mI.put("exit", new ExitCommand());

        return mI;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public List<Tax> getTaxes() {
        return taxes;
    }

    @Override
    public String toString() {
        return "User: " + fullName +
                "\nlogin = " + login +
                "\nemail = " + email +
                "\npassword = " + password +
                "\ndateOfBirth = " + dateOfBirth +
                "\ntaxes = " + taxes;
    }
}
