
package dsl.generator;

import groovy.xml.MarkupBuilder;
import java.lang.Math;
/**
 *
 * @author TOLEP
 */
class CatalogDsl {
    public List<Barang> daftarBarang
    public String namaToko
    public String alamatToko
    public String warnaBackground
    public String warnaFont
    
    CatalogDsl() {
        daftarBarang = new ArrayList<Barang>()
    }
    
    def static String make(Closure closure) {
        CatalogDsl dslCatalog = new CatalogDsl()
        closure.delegate = dslCatalog
        closure()
        def writer = new StringWriter()
        def xml = new MarkupBuilder(writer)
        xml.html(lang:"en") {
            head {
                title("Katalog ${dslCatalog.namaToko}")
                meta('charset':"utf-8")
                meta('name':'viewport','content':'width=device-width, initial-scale=1')
                meta('name':'description','content':'katalog toko online')
                meta('name':'author','content':'kelompok4-k2')
                link(rel:"stylesheet", href:"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css")
                link(rel:"stylesheet", href:"css/shop-homepage.css")
            }
            body('style':"background-color:${dslCatalog.warnaBackground} !important; color:${dslCatalog.warnaFont} !important") {
                //Navigation
                nav(class:"navbar navbar-inverse navbar-fixed-top",'role':"navigation") {
                    div(class:"container") {
                        div(class:"navbar-header") {
                            button('type':"button", class:"navbar-toogle", \
                                    'data-toogle':"collapse", 
                                    'data-target':"#bs-example-navbar-collapse-1") {
                                span("Toogle navigation",class:"sr-only")
                            }
                            a(dslCatalog.namaToko, class:"navbar-brand", 'href':"#")
                        }
                        div(class:"collapse navbar-collapse", 'id':"bs-example-navbar-collapse-1") {
                            ul(class:"nav navbar-nav") {
                                li() {
                                    a("Catalog", 'href':"#catalog")
                                }
                                li() {
                                    a("Contact", 'href':"#contact")
                                }
                            }
                        }
                    }
                }
                
                //Content
                int idx = 0
                int nr = (int)Math.ceil(dslCatalog.daftarBarang.size()/3)
                int nc
                div(class:"container", 'id':"catalog") {
                    div(class:"row title") {
                        h1("Katalog ${dslCatalog.namaToko}")
                        hr()
                    }
                    for(int row=0; row<nr; row++) {
                        div(class:"row") {
                            if (row == nr-1) {
                                nc = (int)dslCatalog.daftarBarang.size()%3
                            } else {
                                nc = 3
                            }
                            div (class:"col-md-12") {
                                div(class:"row") {
                                    for(int col=0; col<nc; col++) {
                                        Barang curBarang = dslCatalog.daftarBarang[idx]
                                        div(class:"col-sm-4 col-lg-4 col-md-4") {
                                            div(class:"thumbnail"){
                                                img('src': curBarang.pathToGambar)
                                                div(class:"caption") {
                                                    h4("Rp. " + curBarang.hargaBarang,class:"pull-right")
                                                    h4(curBarang.namaBarang,class:"nama-produk")
                                                    p(curBarang.deskripsiBarang)
                                                    div(class:"ratings") {
                                                        p("Category : " + curBarang.category, class:"pull-right")
                                                    }
                                                }
                                            }
                                        }
                                        idx++
                                    }
                                }
                            }
                        }
                    }
                }

                //Footer
                div(class:"container", 'id':"contact") {
                    footer() {
                        hr()
                        div(class:"row") {
                            div(class:"col-lg-12") {
                                h3(dslCatalog.namaToko)
                                h4(dslCatalog.alamatToko)
                            }
                        }
                    }
                }
            }
            
        }
        return writer
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
        daftarBarang.add(barang)
    }

}