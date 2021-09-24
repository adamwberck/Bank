package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Selection extends Screen{
    private final List<Option> optionList;

    public Selection(String name, String message, List<Option> optionList) {
        super(name, message);
        this.optionList = optionList;
    }

    public Option get(int i){
        return optionList.get(i);
    }
}
