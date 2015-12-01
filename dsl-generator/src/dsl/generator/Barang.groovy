
package dsl.generator;

import groovy.xml.MarkupBuilder;


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
    }
    
    def deskripsiBarang(String desc) {
        this.deskripsiBarang = desc
    }
    
    def pathToGambar(String path) {
        this.pathToGambar = path
    }
    
    def category(String cat) {
        this.category = cat
    }
    
}


