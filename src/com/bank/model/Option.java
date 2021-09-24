package com.bank.model;

public class Option {
    private final String text;
    private final int number;
    private Screen link;
    private String key;

    public Option(String text, int number, Screen link) {
        this.text = text;
        this.number = number;
        this.link = link;
    }

    public Option(String text, int number, String key) {
        this.text = text;
        this.number = number;
        this.key = key;
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

    public void setLink(Screen link) {
        this.link = link;
    }
}
