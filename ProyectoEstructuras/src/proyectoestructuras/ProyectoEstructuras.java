/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructuras;

/**
 *
 * @author enano
 */
public class ProyectoEstructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LecturaEscrituraTxt archivo = new LecturaEscrituraTxt("Datos.txt");
        archivo.escribirArchivo("Hola, esta es una prueba.");
        archivo.escribirArchivo(".");
        archivo.leerArchivo();
    }
    
}
