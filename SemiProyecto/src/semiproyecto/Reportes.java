/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semiproyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Dylan
 */
public class Reportes {
    public static void generarReporte(Caja[] cajas) {
        if (cajas == null || cajas.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay datos de cajas para generar el reporte.");
            return;
        }

        int totalClientes = 0;
        double totalTiempo = 0;

        Caja cajaMasClientes = cajas[0];
        Caja cajaMejorPromedio = cajas[0];

        for (Caja caja : cajas) {
            totalClientes += caja.getClientesAtendidos();
            totalTiempo += caja.getTiempoTotalAtencion();

            if (caja.getClientesAtendidos() > cajaMasClientes.getClientesAtendidos()) {
                cajaMasClientes = caja;
            }

            if (caja.getPromedioAtencion() < cajaMejorPromedio.getPromedioAtencion()) {
                cajaMejorPromedio = caja;
            }
        }

        double promedioGeneral = totalClientes == 0 ? 0 : totalTiempo / totalClientes;

        String reporte = "Reporte de Cajas\n\n"
                + "1. Caja con más clientes: " + cajaMasClientes.getNombre()
                + " (" + cajaMasClientes.getClientesAtendidos() + " clientes)\n"
                + "2. Total de clientes atendidos: " + totalClientes + "\n"
                + "3. Caja con mejor tiempo promedio: " + cajaMejorPromedio.getNombre()
                + " (" + String.format("%.2f", cajaMejorPromedio.getPromedioAtencion()) + " min/cliente)\n"
                + "4. Tiempo promedio general: " + String.format("%.2f", promedioGeneral) + " min/cliente";

        JOptionPane.showMessageDialog(null, reporte, "Módulo de Reportes", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
