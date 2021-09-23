package com.bank.app;

import com.bank.controller.BankController;
import com.bank.utility.BankPrinter;

public class BankApp {

    public static void main(String[] args){
        var bankPrinter = new BankPrinter();
        var bankController = new BankController();
    }
}
