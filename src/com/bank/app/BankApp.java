package com.bank.app;

import com.bank.controller.BankController;
import com.bank.model.Form;
import com.bank.model.Selection;
import com.bank.utility.BankPrinter;
import com.bank.utility.ScreenParser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BankApp {

    public static void main(String[] args) throws IOException {
        File folder = new File("C:\\Users\\mandr\\Bank\\res");
        var screen_map = ScreenParser.parseFiles(Arrays.asList(folder.listFiles()));
        var screen = screen_map.get("Welcome");
        while (screen != null) {
            Object input = BankPrinter.display(screen);
            if (screen instanceof Selection) {
                String key = BankController.selector(screen.getName(), (int) input);
                screen = screen_map.get(key);
            } else {
                Form form = (Form) screen;
                var list = (List<String>) input;
                for (int i = 0; i < form.size(); i++) {
                    BankController.form(screen.getName(), i, list.get(i));
                }
            }
        }
    }
}
