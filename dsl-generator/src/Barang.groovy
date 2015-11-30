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
    public String namaBarang
    public String hargaBarang
    public String deskripsiBarang
    public String pathToGambar
    public String category
    
    def namaBarang(String nama) {
        this.namaBarang = nama;
    }

    def hargaBarang(String harga) {
        this.hargaBarang = harga
        println this.hargaBarang
    }
    
    def deskripsiBarang(String desc) {
        this.deskripsiBarang = desc
        println this.deskripsiBarang
    }
    
    def pathToGambar(String path) {
        this.pathToGambar = path
        println this.pathToGambar
    }
    
    def category(String cat) {
        this.category = cat
        println this.category
    }
    
}


