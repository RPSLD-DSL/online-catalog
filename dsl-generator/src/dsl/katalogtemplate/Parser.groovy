/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsl.katalogtemplate;

/**
 *
 * @author ASUS
 */
class Parser {
    public void read(String filename) {
        String input = System.getProperty("user.dir") + "\\src\\dsl\\input\\" + filename;
        
    }
    
    public void validate(String filepath) {
        
        File file = new File(filepath)
        
        if (!file.exists()) {
            // file does not exist
            println("File does not exist")
        } else {
            // file exists
            file.eachLine{ line ->
                // line != null
                
            }
        }
        
        
    }
}

