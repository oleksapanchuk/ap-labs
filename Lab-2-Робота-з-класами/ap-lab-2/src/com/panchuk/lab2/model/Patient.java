package com.panchuk.lab2.model;

import com.panchuk.lab2.controller.Validator;

public class Patient {
    private int id;
    private String fName;
    private String lName;
    private String pName;
    private String address;
    private String nPhone;
    private int nMedCard;
    private String diagnosis;

    /**
     * default constructor
     */
    public Patient() { }

    /**
     * constructor
     */
    public Patient(int id, String fName, String lName, String pName,
                   String address, String nPhone, int nMedCard,
                   String diagnosis) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.pName = pName;
        this.address = address;
        this.nPhone = nPhone;
        this.nMedCard = nMedCard;
        this.diagnosis = diagnosis;
    }
    /**
     * getters & setters
     */
    public int getId() { return id; }

    public String getFName() { return fName; }

    public String getLName() { return lName; }

    public String getPName() { return pName; }

    public String getAddress() { return address; }

    public String getNPhone() { return nPhone; }

    public int getNMedCard() { return nMedCard; }

    public String getDiagnosis() { return diagnosis; }

    public void setId(int id) { this.id = id; }

    public void setFName(String fName) { this.fName = fName; }

    public void setLName(String lName) { this.lName = lName; }

    public void setPName(String pName) { this.pName = pName; }

    public void setAddress(String address) { this.address = address; }

    public void setNPhone(String nPhone) { this.nPhone = nPhone; }

    public void setNMedCard(int nMedCard) { this.nMedCard = nMedCard; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }


    @Override
    public String toString() {
        String dividingLine = "-------------------------------------------------";
        return new StringBuilder().append("\n").append(dividingLine)
                .append("\nPatient ID: ").append(String.format("%09d", id))
                .append("\n\tFull name: ").append(fName).append(" ")
                .append(lName).append(" ").append(pName)
                .append("\n\tAddress: ").append(address)
                .append("\n\tNumber of phone: ").append(nPhone)
                .append("\n\tNumber of medical card: ").append(nMedCard)
                .append("\n\tDiagnosis: ").append(diagnosis).toString();
    }
}
