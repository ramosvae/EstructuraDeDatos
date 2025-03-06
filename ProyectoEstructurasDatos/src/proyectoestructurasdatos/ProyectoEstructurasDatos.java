/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructurasdatos;



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
        archivo.escribirArchivo(webScraping.toTxt);
        archivo.escribirArchivoAppend("\n"+hf.toString());
        archivo.leerArchivo();

    }

}
