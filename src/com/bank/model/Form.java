package com.bank.model;

import java.util.List;

public class Form extends Screen{
    List<String> entries;
    public Form(String name, String message, List<String> entries) {
        super(name, message);
        this.entries = entries;
    }

    public int size() {
        return entries.size();
    }

    public String get(int i) {
        return entries.get(i);
    }

    public boolean validCheck(int i, String input) {
        // TODO actually check
        return true;
    }
}
