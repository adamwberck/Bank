package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String name;
    private String message;
    private Screen back;
    private List<Options> optionsList = new ArrayList<>();

    public Screen(String message, List<Options> optionsList) {
        this.message = message;
        this.optionsList = optionsList;
    }

}
