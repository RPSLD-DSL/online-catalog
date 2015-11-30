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
        String input = System.getProperty("user.dir") + "\\src\\dsl\\input\\" + filename
        validate(input)
    }
    
    public boolean validate(String filepath) {
        def katalog = []
        File file = new File(filepath)
        println filepath
        boolean valid = false
        
        if (!file.exists()) {
            // file does not exist
            println("File does not exist")
        } else {
            driveInfo = [:]
            // file exists
            file.eachLine{ line ->
                // line != null
                println $line
                if(line.trim()) {
                    // map
                    def(key,value) = line.split(' ').collect {it.trim()}
                    // store
                    driveInfo."$key" = value;
                } else {
                    // line == null
                    if (driveInfo) {
                        katalogDsl << driveInfo
                        driveInfo = [:]
                    }
                }
            }
        }
        // last insert
        if (driveInfo) {
            katalogDsl << driveInfo
        }
        
        return valid;
    }
}

