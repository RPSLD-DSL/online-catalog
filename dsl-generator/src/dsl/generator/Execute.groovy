package dsl.generator;

import org.codehaus.groovy.control.customizers.ImportCustomizer
import org.codehaus.groovy.control.CompilerConfiguration
/**
 *
 * @author TOLEP
 */
class Execute {
    
    public static String doGenerate(String filePath) {
        def importCustomizer = new ImportCustomizer()
        importCustomizer.addImport 'dsl.generator.CatalogDsl'
        def configuration = new CompilerConfiguration()
        configuration.addCompilationCustomizers(importCustomizer)
        def shell = new GroovyShell(configuration)
        String file = new File(filePath).text
        String string = shell.evaluate("CatalogDsl.make{"+file+"}")
        return string
    } 
}

