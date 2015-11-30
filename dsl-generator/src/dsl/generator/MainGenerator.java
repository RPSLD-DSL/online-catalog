/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsl.generator;

import dsl.katalogtemplate.Parser;

/**
 *
 * @author ASUS
 */
public class MainGenerator {
    public static void main(String[] args) {
        String curDir = System.getProperty("user.dir");
        Parser pars = new Parser();
        pars.validate(curDir + "\\src\\dsl\\input\\contohInput.txt");
    }
}
