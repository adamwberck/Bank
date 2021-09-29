package com.bank.controller;

public class BankController {
    public static String selector(String key, int selection){//TODO implement selection
        System.out.println(key + " " + selection);
        switch (key) {
            case "Welcome":
                switch (selection){
                    case 0:
                        return "New";
                    case 1:
                        return "Login";
                    case 2:
                        return null;
                }
                break;
        }
        return null;
    }

    public static void form(String key, int entry_index, String entry){//TODO implement form
        System.out.println(key + " " + entry_index + " " + entry);
        // switch (key) {
        //}
    }
}
