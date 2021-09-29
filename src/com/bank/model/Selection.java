package com.bank.model;

import com.bank.controller.BankController;

import java.util.List;

public class Selection extends Screen{
    private final List<String> optionList;

    public Selection(String name, String message, List<String> optionList) {
        super(name, message);
        this.optionList = optionList;
    }

    public String get(int i){
        return optionList.get(i);
    }

    public int size() {
        return optionList.size();
    }
}
