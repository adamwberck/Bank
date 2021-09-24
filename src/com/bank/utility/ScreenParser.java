package com.bank.utility;

import com.bank.model.Option;
import com.bank.model.Screen;
import com.bank.model.Selection;

import java.io.*;
import java.util.*;

public class ScreenParser {
    public Map<String, Screen> parseFiles(Collection<File> files) throws IOException {
        var map = new Hashtable<String, Screen>();
        for(File f: files){
            if(f.isDirectory()){
                parseFiles(Arrays.asList(f.listFiles()));
            }
            else {

                var br = new BufferedReader(new FileReader(f));
                if(isSelection(br)){
                    String name = br.readLine();
                    String message = br.readLine();
                    String line = br.readLine();
                    List<Option> options = new ArrayList<>();
                    while(line != null){
                        int number = Integer.parseInt(line.split("\\.")[0]);
                        options.add(new Option(line, number, name));
                        line = br.readLine();
                    }
                    map.put(name, new Selection(name, message, options));
                }
                else {

                }
            }
        }
        return map;
    }

    private boolean isSelection(BufferedReader br) throws IOException {
        return br.readLine().equals("Selection");
    }
}
