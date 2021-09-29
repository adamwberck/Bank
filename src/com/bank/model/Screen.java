package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Screen{
    private String name;
    private String message;

    public Screen(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
