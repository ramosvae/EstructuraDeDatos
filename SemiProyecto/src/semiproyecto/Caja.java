/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semiproyecto;

/**
 *
 * @author Dylan
 */
public class Caja {
    private String nombre;
    private int clientesAtendidos;
    private double tiempoTotalAtencion;

    public Caja(String nombre, int clientesAtendidos, double tiempoTotalAtencion) {
        this.nombre = nombre;
        this.clientesAtendidos = clientesAtendidos;
        this.tiempoTotalAtencion = tiempoTotalAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public double getTiempoTotalAtencion() {
        return tiempoTotalAtencion;
    }

    public double getPromedioAtencion() {
        if (clientesAtendidos == 0) return 0;
        return tiempoTotalAtencion / clientesAtendidos;
    }
}

    