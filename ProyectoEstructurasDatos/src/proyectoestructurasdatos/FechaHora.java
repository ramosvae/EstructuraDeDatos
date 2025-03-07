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
    private String formattedDatePlus5;

    public FechaHora() {

        now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDate = now.format(formatter);
        formattedDatePlus5 = now.plusMinutes(5).format(formatter);
    }

    public String getSoloFecha() {
        return formattedDate.substring(0, 10);
    }

    public String getFormattedDatePlus5() {
        return formattedDatePlus5;
    }

    public void setFormattedDatePlus5(String formattedDatePlus5) {
        this.formattedDatePlus5 = formattedDatePlus5;
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
