/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructurasdatos;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author enano
 */
public class ProyectoEstructurasDatos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WebScraping webScraping = new WebScraping();
        webScraping.Scrap();
        
        FechaHora hf = new FechaHora();
        System.out.println(hf);
        
        LecturaEscrituraTxt archivo = new LecturaEscrituraTxt("Datos.txt");
        archivo.escribirArchivo(webScraping.aTxt);
        archivo.escribirArchivoAppend(hf.toString());
        archivo.leerArchivo();

        
        
        
        

    }

}
