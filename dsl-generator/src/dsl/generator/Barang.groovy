package dsl.generator

import groovy.xml.MarkupBuilder

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOLEP
 */
class Barang {
    String namaBarang
    String hargaBarang
    String deskripsiBarang

//    def static foo(Closure closure, Barang barang) {
//        closure.delegate = barang
//        closure()
//    }
    
    def namaBarang(String nama) {
        this.namaBarang = nama;
    }

    def hargaBarang(String harga) {
        this.hargaBarang = harga
    }
    
    def deskripsiBarang(String desc) {
        this.deskripsiBarang = desc
    }
    
//    def methodMissing(String methodname, args) {
//        println methodname
//    }
//    
//    def getFoo() {
//        doBarang(this)
//    }
//    
//    public static Barang doBarang(Barang barang) {
//        return barang
//    }

}


