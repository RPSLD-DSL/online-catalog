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
class CatalogDsl {
    def daftarBarang = []
    String namaToko
    String alamatToko
    String warnaBackground
    String warnaFont
    
    def static make(Closure closure) {
        CatalogDsl dslCatalog = new CatalogDsl()
        closure.delegate = dslCatalog;
        closure()
    }
    
    def namaToko (String nama) {
        this.namaToko = nama
    }
    
    def alamatToko (String alamat) {
        this.alamatToko = alamat
    }
    
    def warnaBackground (String bg) {
        this.warnaBackground = bg;
    }
    
    def warnaFont (String font) {
        this.warnaFont = font
    }
    
    def barang(Closure cl) {
        Barang barang = new Barang()
        cl.delegate = barang
        cl()
        println barang.namaBarang
        daftarBarang << barang
    }
    
    def methodMissing(String methodname, args) {
        println methodname
    }
    
    def getHtml() {
        println "masuk sini coy"
        doHtml(this)
    }
    
    public static String doHtml(CatalogDsl catalog) {
        println("Toko : ${catalog.namaToko}")
        println("Jumlah Barang : "+catalog.daftarBarang.length)
        println("Barang pertama : " +catalog.daftarBarang[0].namaBarang)
        
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html(lang:"en") {
            head {
                title("Katalog ${catalog.namaToko}")
                meta('charset':"utf-8")
                meta('name':'viewport','content':'width=device-width, initial-scale=1')
                meta('name':'description','content':'katalog toko online')
                meta('name':'author','content':'kelompok4-k2')
                link (rel:"stylesheet", href:"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")
            }
            body {
                nav('class':'navbar navbar-inverse navbar-fixed-top', 'role':'navigation')
            }
            
        }
        return "mmm";
        
    }
    
    
    
	
}

