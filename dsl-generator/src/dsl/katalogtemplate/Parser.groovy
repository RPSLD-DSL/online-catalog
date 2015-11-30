
package dsl.katalogtemplate;

import java.util.HashMap;

/**
 *
 * @author ASUS
 */
class Parser {
    public void read(String filename) {
        String input = filename + "contohInput.txt"
        boolean valid = validate(input)
    }
    
    public boolean validate(String filepath) {
        
        File file = new File(filepath)
        boolean valid = true
        String parameters = "namaToko alamatToko barang namaBarang hargaBarang deskripsiBarang warnaBackground warnaFont pathToGambar category"
        
        if (!file.exists()) {
            // file does not exist
            println("File does not exist")
        } else {
            boolean parseBarang = false
            // file exists
            file.eachLine{ line ->
                // line != null
                if(line.trim()) {
                    String lineWithoutTab = line.trim().replaceAll("\\s+", " ")
                    String inputParam = lineWithoutTab.split(" ", 2)[0]
                    if (inputParam.compareTo("}") != 0) {
                        if (!parameters.contains(inputParam)) {
                            valid = false
                        }   
                    }
                }
            }
        }
        return valid;
    }
}