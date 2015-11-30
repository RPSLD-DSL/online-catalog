package dsl.generator;


import dsl.katalogtemplate.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author TOLEP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String curDir = System.getProperty("user.dir");
        String fileLocation = curDir + "\\input\\input.txt";
        Parser pars = new Parser();
        
        if (pars.validate(fileLocation)) {
            Execute ex = new Execute();
            String output = "<!DOCTYPE html>\n" +ex.foo(fileLocation);
            
            File file = new File (curDir + "\\output\\output.html");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(output);
                System.out.println("File output.html successfully created in folder output");
            } catch (Exception e) {
                System.out.println("Error writing files");
            }
        } else {
            System.out.println("Error syntax in file input");
        }

    }
}
