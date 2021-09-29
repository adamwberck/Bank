package com.bank.model;

import java.util.List;

public class Account {
    private double checking;
    private String name;
    private String address;
    private String phone;
    final private String ID;
    private String password;

    public Account(String name, String address, String phone, String ID, String password) {
        this.checking = 0;
        this.name = name;
        this.address = address;
        this.password = password;
        this.phone = phone;
        this.ID = ID;
    }


    public Account(double checking, String name, String address, String ID) {
        this.checking = checking;
        this.name = name;
        this.address = address;
        this.ID = ID;
    }

    public Account(List<String> values) {
        this.name = values.get(0);
        this.address = values.get(1);
        this.phone = values.get(2);
        this.ID = values.get(3);
        this.password = values.get(4);
        this.checking = Double.parseDouble(values.get(5));
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public double getChecking() {
        return checking;
    }

    public void setChecking(double checking) {
        this.checking = checking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPass() {
        return password;
    }
}
