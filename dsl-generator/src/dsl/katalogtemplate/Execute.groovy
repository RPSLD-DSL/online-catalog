package dsl.katalogtemplate;

import dsl.katalogtemplate.*;

/**
 *
 * @author TOLEP
 */
class Execute {
    
    public Execute(){
        
    }
    public String foo(String filePath) {
        String file = new File(filePath).text
        String string = new GroovyShell().evaluate("CatalogDsl.make{"+file+"}")
        return string
    } 
}

