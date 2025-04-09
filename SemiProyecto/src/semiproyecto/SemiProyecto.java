/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semiproyecto;


/**
 *
 * @author enano
 */
public class SemiProyecto {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.g.cargarInfo();
        menu.login();
        Caja[] cajas = {
            new Caja("Caja 1", 10, 50.0),
            new Caja("Caja 2", 15, 70.0),
            new Caja("Caja 3", 7, 20.0)
        };

        Reportes.generarReporte(cajas);
    }
}
