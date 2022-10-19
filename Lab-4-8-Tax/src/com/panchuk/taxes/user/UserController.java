package com.panchuk.taxes.user;

import com.panchuk.taxes.Validator;

public class UserController {
    public static User createUserInConsole() {
        return new User(
                Validator.inputString("name", Validator.VALID_FULL_NAME),
                Validator.inputString("login", Validator.VALID_LOGIN),
                Validator.inputString("email", Validator.VALID_EMAIL),
                Validator.inputString("password", Validator.VALID_PASSWORD),
                Validator.inputString("date of birth", Validator.VALID_DATE)
        );
    }
}
