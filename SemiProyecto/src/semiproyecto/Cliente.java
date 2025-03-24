package semiproyecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Cliente {

    private String nombre;
    private int id;
    private int edad;
    private String horaCreacion;
    private String horaAtencion;
    private TramiteEnum tramite;
    private TipoEnum tipo;

    public Cliente(String nombre, int id, int edad, String horaCreacion, String horaAtencion, TramiteEnum tramite, TipoEnum tipo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.horaCreacion = horaCreacion;
        this.horaAtencion = horaAtencion;
        this.tramite = tramite;
        this.tipo = tipo;
    }

    public String getPojoAtendido() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", nombre, id, edad, getHoraCreacion(), obtenerHora(), tramite, tipo);
    }

    public String getPojoEnCola() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", nombre, id, edad, horaCreacion, horaAtencion, tramite, tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(String horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public TramiteEnum getTramite() {
        return tramite;
    }

    public void setTramite(TramiteEnum tramite) {
        this.tramite = tramite;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public String obtenerHora() {
        DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String fechaHoraActualFormateada = now.format(formateo);
        String horaActualFormateada = fechaHoraActualFormateada.substring(11);
        return horaActualFormateada;
    }

    @Override
    public String toString() {
        return "****TICKET #"+id+"****\n"+
                "Nombre: "+ nombre+

                "\nEdad: "+ edad+
                "\nHora de Creacion: "+ horaCreacion+
                "\nHora de Atencion: "+ horaAtencion+
                "\nTramite: "+ tramite+
                "\nCaja: "+ tipo+
                "\n";
    }
}
