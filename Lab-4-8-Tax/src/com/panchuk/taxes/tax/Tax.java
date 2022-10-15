package com.panchuk.taxes.tax;

public abstract class Tax {
    protected String nameOfTax;
    protected double taxPercentage;

    public abstract double getTaxAmount();
}
