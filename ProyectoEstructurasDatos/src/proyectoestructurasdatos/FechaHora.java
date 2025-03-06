/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructurasdatos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author enano
 */
public class FechaHora {
    private LocalDateTime now;
    private String formattedDate;

    public FechaHora() {

        now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDate = now.format(formatter);
    }

    public String getSoloFecha() {
        return formattedDate.substring(0, 10);
    }

    public String getSoloHora() {
        return formattedDate.substring(11);
    }

    @Override
    public String toString() {
        return "Fecha y hora original: " + now + "\n"
                + "Fecha y hora formateada: " + formattedDate + "\n"
                + "Solo fecha: " + getSoloFecha() + "\n"
                + "Solo hora: " + getSoloHora();
    }
}
