package com.bank.controller;

import com.bank.BankSingleton;
import com.bank.model.Account;

import java.util.List;

public class BankController {
    public static String selector(String key, int selection){//TODO implement selection
        // System.out.println("db" + key + " " + selection);
        switch (key) {
            case "Welcome":
                BankSingleton.setLoggedIn(null);
                switch (selection){
                    case 0:
                        return "New";
                    case 1:
                        return "Login";
                    case 2:
                        return null;
                }
                break;
            case "Customer":
                switch (selection){
                    case 0:
                        return "Deposit";
                    case 1:
                        return "Withdraw";
                    case 2:
                        return "Transfer";
                    case 3:
                        return "Info";
                    case 4:
                        return "Welcome";
                }
                break;
        }
        return null;
    }

    public static String form(String key, List<String> values){
        if(values.contains("Exit")) {
            return "Welcome";
        }
        switch (key) {
            case "New":
                BankSingleton.setLoggedIn(null);
                BankSingleton.addAccount(new Account(values));
                return "Welcome";
            case "Login":
                Account login = BankSingleton.idPassCheck(values);
                if(login == null) {
                    System.out.println("Could not find Account with that Password");
                    return "Login";
                }
                BankSingleton.setLoggedIn(login);
                return "Customer";
            case "Withdraw":
                BankSingleton.withdraw(values.get(0));
                return "Customer";
            case "Deposit":
                BankSingleton.deposit(values.get(0));
                return "Customer";
            case "Transfer":
                if(BankSingleton.withdraw(values.get(1))){
                    BankSingleton.deposit(values.get(0), values.get(1));
                }
                return "Customer";
            case "Info":
                BankSingleton.displayLoggedIn();
                return "Customer";
        }
        return "";
    }
}
