package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String message;
    private List<Options> optionsList = new ArrayList<>();

    public Screen(String message, List<String> optionStrings, List<Screen> ) {

    }

    public Screen(String message, List<Options> optionsList) {
        this.message = message;
        this.optionsList = optionsList;
    }

    private class Options {
        private String text;
        private int number;
        private Screen link;
    }
}
