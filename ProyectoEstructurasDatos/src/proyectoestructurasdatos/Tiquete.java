/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasdatos;

/**
 *
 * @author enano
 */
public class Tiquete {

    private String Nombre;
    private int ID;
    private int Edad;
    private String Horacreacion;
    private String Horaatencion;
    private Tramites tramite;
    private Tipos tipo;

    public Tiquete(String Nombre, int ID, int Edad, String Horacreacion, String Horaatencion, Tramites tramite, Tipos tipo) {
        this.Nombre = Nombre;
        this.ID = ID;
        this.Edad = Edad;
        this.Horacreacion = Horacreacion;
        this.Horaatencion = Horaatencion;
        this.tramite = tramite;
        this.tipo = tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public Tramites getTramite() {
        return tramite;
    }

    public void setTramite(Tramites tramite) {
        this.tramite = tramite;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getHoracreacion() {
        return Horacreacion;
    }

    public void setHoracreacion(String Horacreacion) {
        this.Horacreacion = Horacreacion;
    }

    public String getHoraatencion() {
        return Horaatencion;

    }

    public void setHoraatencion(String Horaatencion) {
        this.Horaatencion = Horaatencion;
    }

    @Override
    public String toString() {
        return "Tiquete{" + "Nombre=" + Nombre + ", ID=" + ID + ", Edad=" + Edad + ", Horacreacion=" + Horacreacion + ", Horaatencion=" + Horaatencion + ", tramite=" + tramite + ", tipo=" + tipo + '}';
    }
    
    
}
