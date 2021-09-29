package com.bank.utility;

import com.bank.model.Form;
import com.bank.model.Screen;
import com.bank.model.Selection;

import java.io.*;
import java.util.*;

public class ScreenParser {
    public static Map<String, Screen> parseFiles(Collection<File> files) throws IOException {
        var map = new Hashtable<String, Screen>();
        for(File f: files){
            if(f.isDirectory()){
                parseFiles(Arrays.asList(f.listFiles()));
            }
            else {
                var br = new BufferedReader(new FileReader(f));
                boolean isSelection = isSelection(br);
                String name = br.readLine();
                String message = br.readLine();
                String line = br.readLine();
                List<String> strings = new ArrayList<>();
                while(line != null){
                    strings.add(line);
                    line = br.readLine();
                }
                if(isSelection){ // Selection screen
                    map.put(name, new Selection(name, message, strings));
                }
                else{ // Form Screen
                    map.put(name, new Form(name, message, strings));
                }
            }
        }
        return map;
    }

    private static boolean isSelection(BufferedReader br) throws IOException {
        try {
            return br.readLine().equals("Selection");
        }
        catch(NullPointerException ignored){
            return false;
        }
    }
}
