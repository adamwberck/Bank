package com.bank.model;

public class Option {
    private final String text;
    private final int number;
    private String action; //TODO replace with controller implementation
    private String key;

    public Option(String text, int number, String action) {
        this.text = text;
        this.number = number;
        this.action = action;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }
}
