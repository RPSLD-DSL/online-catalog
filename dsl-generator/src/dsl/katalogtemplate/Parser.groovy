/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsl.katalogtemplate;

import java.util.HashMap

/**
 *
 * @author ASUS
 */
class Parser {
    public void read(String filename) {
        String input = filename + "contohInput.txt"
        validate(input)
    }
    
    public boolean validate(String filepath) {
        File file = new File(filepath)
        boolean valid = false
        def parameters = ""
        
        if (!file.exists()) {
            // file does not exist
            println("File does not exist")
        } else {
            boolean parseBarang = false
            // file exists
            while (file.eachLine) {
                // line != null
                if(line.trim()) {
                    inputParam = line.split(" ", 2)[0]
                    if (!parameters.contains(inputParam)) {
                        valid = false
                    }
                }
            }
        }        
        return valid;
    }
}