package com.panchuk.lab2.controller;

import com.panchuk.lab2.model.Patient;

import java.util.Arrays;

public class PatientManagement {
    private static Patient[] arrayAllPatient;
    private static Patient[] sortedByDiagnosis;
    private static Patient[] sortedByMedCardInterval;
    private static Patient[] sortedByDigitOfPhoneNum;
    /**
     * Initialization of an array sorted by diagnosis
     */
    public static void initArrayAllPatient(int totalArrLength) {
        PatientManagement.sortedByDiagnosis = new Patient[totalArrLength];
    }
    /**
     * Initialization of an array sorted by diagnosis
     */
    public static void initArrSortedByDiagnosis(int totalArrLength) {
        PatientManagement.sortedByDiagnosis = new Patient[totalArrLength];
    }
    /**
     * Initialization of an array sorted by medical card interval
     */
    public static void initArrSortedByMedCardInterval(int totalArrLength) {
        PatientManagement.sortedByMedCardInterval = new Patient[totalArrLength];
    }
    /**
     * Initialization of an array sorted by first digit of phone number
     */
    public static void initArrSortedByDigitOfPhoneNum(int totalArrLength) {
        PatientManagement.sortedByDigitOfPhoneNum = new Patient[totalArrLength];
    }
    /**
     * Getter of an array sorted by diagnosis
     */
    public static Patient[] getArrayAllPatient() {
        int index = 0;
        for (Patient p: arrayAllPatient) {
            if (p == null) return Arrays.copyOf(arrayAllPatient, index);
            index++;
        }
        return arrayAllPatient;
    }
    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByDiagnosis() {
        int index = 0;
        for (Patient p: sortedByDiagnosis) {
            if (p == null) return Arrays.copyOf(sortedByDiagnosis, index);
            index++;
        }
        return sortedByDiagnosis;
    }
    /**
     * Getter of an array sorted by medical card interval
     */
    public static Patient[] getSortedByMedCardInterval() {
        int index = 0;
        for (Patient p: sortedByMedCardInterval) {
            if (p == null) return Arrays.copyOf(sortedByMedCardInterval, index);
            index++;
        }
        return sortedByMedCardInterval;
    }
    /**
     * Getter of an array sorted by first digit of phone number
     */
    public static Patient[] getSortedByDigitOfPhoneNum() {
        int index = 0;
        for (Patient p: sortedByDigitOfPhoneNum) {
            if (p == null) return Arrays.copyOf(sortedByDigitOfPhoneNum, index);
            index++;
        }
        return sortedByDigitOfPhoneNum;
    }


}
