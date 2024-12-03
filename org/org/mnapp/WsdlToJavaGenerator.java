package org.mnapp.app;

import org.apache.cxf.tools.wsdlto.WSDLToJava;

public class WsdlToJavaGenerator {
	String wsdl;
    public void generateTestWsdlSource (String mode, String wsdl) {
        // Ścieżka do pliku WSDL
//        String wsdl = "https://test-bramka.edeklaracje.gov.pl/uslugi/dokumenty?wsdl";
    	this.wsdl = new String(wsdl);
        
        // Opcje generowania kodu
        String[] wsdltojavaArgs = new String[] {
            "-d", "src/main/java", // Katalog docelowy dla wygenerowanego kodu
            "-p", "com." + mode + ".edeklaracje", // Pakiet dla wygenerowanego kodu
            wsdl // Plik WSDL
        };
        
        // Generowanie kodu
        WSDLToJava.main(wsdltojavaArgs);
        
        System.out.println("Generowanie kodu zakończone!");
    }
}
