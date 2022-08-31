package com.panchuk.lab2.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    /**
     * validator of identifier
     */
    public static int checkId(int id) throws WrongIDException {
        if (id <= 0)
            throw new WrongIDException("Bad ID or Medical Card Number!\n");
        return id;
    }

    /**
     * get int from string or throw error
     */
    public static int getInteger(String str) throws NumberFormatException {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage() + " is not INT value!");
        }
    }

    /**
     * validator first name and last name and parent name
     */
    public static String checkName(String name, String typeName) throws WrongNameInputException {
        if (name == null || name.length() == 0) throw new WrongNameInputException("Opss... Try again!");

        Pattern patternName = Pattern.compile("[ a-zA-Zа-яА-Я-]+");
        Matcher matcherName = patternName.matcher(name);

        if (matcherName.matches()) {
            return name;
        } else {
            throw new WrongNameInputException(typeName + name + " does not match the rules");
        }
    }

    /**
     * validator phone number
     */
    public static String checkNPhone(String nPhone) throws WrongInputPhoneNumberException {
        if (nPhone == null || nPhone.length() == 0) throw new WrongInputPhoneNumberException("Opss... Try again!");

        Pattern patternPhone = Pattern.compile("\\+??[0-9]+");
        Matcher matcherPhone = patternPhone.matcher(nPhone);

        if (matcherPhone.matches()) {
            if (nPhone.startsWith("0") && nPhone.length() == 10) {
                return new StringBuilder().append("+380(").append(nPhone.substring(1, 3)).append(")")
                        .append(nPhone.substring(3, 5)).append("-")
                        .append(nPhone.substring(5, 7)).append("-")
                        .append(nPhone.substring(7)).toString();
            } else if (nPhone.startsWith("380") && nPhone.length() == 12) {
                return new StringBuilder().append("+380(").append(nPhone.substring(3, 5)).append(")")
                        .append(nPhone.substring(5, 7)).append("-")
                        .append(nPhone.substring(7, 9)).append("-")
                        .append(nPhone.substring(9)).toString();
            } else if (nPhone.startsWith("+380") && nPhone.length() == 13) {
                return new StringBuilder().append("+380(").append(nPhone.substring(4, 6)).append(")")
                        .append(nPhone.substring(6, 8)).append("-")
                        .append(nPhone.substring(8, 10)).append("-")
                        .append(nPhone.substring(10)).toString();
            } else {
                throw new WrongInputPhoneNumberException("Phone number is incorrect: " + nPhone);
            }
        } else {
            throw new WrongInputPhoneNumberException("Phone number: " + nPhone + " does not match the rules");
        }
    }

    /**
     * address validator
     */
    public static String checkAddress(String address) throws WrongInputAddressException {
        if (address == null || address.length() == 0) throw new WrongInputAddressException("Opss... Try again!");

        Pattern patternAddress = Pattern.compile("[ a-zA-Zа-яА-Я0-9-/.]+");
        Matcher matcherAddress = patternAddress.matcher(address);

        if (matcherAddress.matches()) {
            return address;
        } else {
            throw new WrongInputAddressException("The address " + address + " does not match the rules");
        }
    }


}
