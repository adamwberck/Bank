package com.bank.model;

import java.util.List;

public class Form extends Screen{
    List<FormEntry> entries;
    public Form(String name, String message, List<FormEntry> entries) {
        super(name, message);
        this.entries = entries;
    }
}
