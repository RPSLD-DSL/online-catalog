/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOLEP
 */
class Execute {
    public String foo() {
        String file = new File('D:\\input.txt').text
        String string = new GroovyShell().evaluate("CatalogDsl.make{"+file+"}")
        println string
        return string
    } 
}

