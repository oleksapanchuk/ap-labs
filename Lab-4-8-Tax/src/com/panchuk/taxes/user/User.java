package com.panchuk.taxes.user;

import com.panchuk.taxes.Validator;
import com.panchuk.taxes.tax.Tax;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class User {
    private String fullName;
    private String login;
    private String email;
    private String password;
    private String dateOfBirth;
    private boolean isAdmin;
    private List<Tax> taxes;

    public User(String fullName, String login, String email, String password, String dateOfBirth, boolean isAdmin) {
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.isAdmin = isAdmin;
        taxes = new ArrayList<>();
    }


    @Override
    public String toString() {
        return "User: " + fullName +
                "\nlogin = " + login +
                "\nemail = " + email +
                "\npassword = " + password +
                "\ndateOfBirth = " + dateOfBirth +
                "\nisAdmin = " + isAdmin +
                "\ntaxes = " + taxes;
    }


    public static void main(String[] args) {
        User user1 = new User(
                "Panchuk Oleksandr",
                "o1eksandr",
                "oleksandrpanchuk@gmail.com",
                "123",
                "12.03.2004",
                true
        );

        User user2 = new User(
                Validator.inputString("name", Validator.VALID_FULL_NAME),
                Validator.inputString("login", Validator.VALID_LOGIN),
                Validator.inputString("email", Validator.VALID_EMAIL),
                Validator.inputString("password", Validator.VALID_PASSWORD),
                Validator.inputString("data of birth", Validator.VALID_DATE),
                false
        );

        System.out.println(user1);
        System.out.println("------------------------------------------------------------------");
        System.out.println(user2);
    }
}
