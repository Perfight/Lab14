package com.company;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        StringBuffer in = new StringBuffer();
        try(FileReader reader = new FileReader("comment.txt")){
            int sym = -1;
            while ((sym = reader.read()) != -1){
                in.append(Character.toChars(sym));
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        Pattern pattern = Pattern.compile("((//.+)\\n)|(/\\*.+?\\*/)", Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(in.toString());
        String out = null;
        if(matcher.find()){
            out = matcher.replaceAll("");
        }
        try(FileWriter writer = new FileWriter("no_comment.txt")) {
            writer.write(out);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
