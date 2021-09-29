package com.bank.utility;

import com.bank.model.Form;
import com.bank.model.Screen;
import com.bank.model.Selection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankPrinter {

    private static Scanner scanner = new Scanner(System.in);

    public static Object display(Screen screen){
        if (screen instanceof Selection)
            return display((Selection) screen);
        return display((Form) screen);
    }

    public static int display(Selection selection) {
        System.out.println(selection.getMessage());
        for (int i=0; i < selection.size(); i++) {
            System.out.println(selection.get(i));
        }
        String input = null;
        while(input == null){
            input = scanner.nextLine();
            try{
                int inputNum =  Integer.parseInt(input);
                if(inputNum>=1 && inputNum<=selection.size()){
                    return inputNum-1;
                }
                else{
                    input = null;
                }
            }
            catch(NumberFormatException ignored){
                input = null;
                System.out.println("Enter a Number");
            }
        }
        return 0;
    }

    public static List<String> display(Form form){
        List<String> output = new ArrayList<>();
        System.out.println(form.getMessage());
        for (int i=0; i < form.size(); i++) {
            System.out.println(form.get(i));
            String input = null;
            while(input == null){
                input = scanner.nextLine();
                if(!form.validCheck(i, input)) {
                    input = null;
                    System.out.println("Invalid Input");
                }
            }
            output.add(input);
        }
        return output;
    }
}
