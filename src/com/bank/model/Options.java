package com.bank.model;

public class Options {
    private final String text;
    private final int number;
    private final Screen link;

    public Options(String text, int number, Screen link) {
        this.text = text;
        this.number = number;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }

    public Screen getLink() {
        return link;
    }
}
