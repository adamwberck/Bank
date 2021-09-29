package com.bank.model;

import com.bank.BankSingleton;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private double checking;
    private String name;
    private String address;
    private String phone;
    final private String ID;
    private String password;
    private List<Transaction> transactions = new ArrayList<>();

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
        this.ID = values.get(3);
        this.name = values.get(0);
        this.address = values.get(1);
        this.phone = values.get(2);
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

    @Override
    public String toString() {
        var df = new DecimalFormat("#.00");
        return "Your Bank Account!\n" +
                "Checking Balance: " + df.format(checking) +
                "Full Name: " + name + '\n' +
                "Address: " + address + '\n' +
                "Phone: " + phone + '\n' +
                "ID: " + ID + '\n' +
                "Password=: " + password + '\n' +
                '}';
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void add(String withdrawOrDeposit, double amount) {
        this.transactions.add(new Transaction(withdrawOrDeposit, amount));
    }

    public void displayRecent() {
        for(int i=0; i < Math.min(transactions.size(),5); i++){
            System.out.println(transactions.get(i).toString());
        }
    }

    public class Transaction {
        final private String withdrawOrDeposit;
        final private double amount;

        public Transaction(String withdrawOrDeposit, double amount) {
            this.withdrawOrDeposit = withdrawOrDeposit;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "Transaction: "+ withdrawOrDeposit + '\'' +
                    " - " + amount;
        }
    }
}
