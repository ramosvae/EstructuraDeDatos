package semiproyecto;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;

import javax.swing.*;


public class Gestion {
    //Cliente[] listaClientes = cargarInfo();

    String configuracionCola = "confCola.txt";
    String configuracionAtendidos = "confAtendidos.txt";
    Cliente[] listaClientes = new Cliente[contarLineas(configuracionCola)];
    Cliente[] listaClientesAtendidos = new Cliente[contarLineas(configuracionAtendidos)];
    Cola colaPreferencial = new Cola();
    Cola colaUnTramite = new Cola();
    Cola colaMasTramites = new Cola();


    /// ☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻☻///
    /// ☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻///
    /// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///
    public String getDolar() {
        String url = "https://www.xe.com/es/currencyconverter/convert/?Amount=1&From=USD&To=CRC";
        try {
            Document docDolar = Jsoup.connect(url).get();
            String dolarValor = docDolar.select(".sc-294d8168-1").text().substring(0, 6);
            String dolar = "\nPrecio actual del dolar: ₡" + dolarValor;
            return dolar;

        } catch (IOException ioe) {
            System.out.println("Error en getDolar: " + ioe.getMessage());
        }
        return "Error: No se encontró dolar";
    }

    /// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
    /// ☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻GET DOLAR☻☻☻☻☻☻☻☻///

    /// ☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻///
    /// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///

    /// ☻ MAIN CARGAR ☻///
    public Cliente[] cargarInfo() {
        Cliente[] listaClientesAtendidos = new Cliente[contarLineas(configuracionAtendidos)];
        this.listaClientesAtendidos = listaClientesAtendidos;
        Cliente[] listaClientes = new Cliente[contarLineas(configuracionCola)];
        this.listaClientes = listaClientes;
        TramiteEnum gTramite = TramiteEnum.Vacio;
        TramiteEnum aTramite = TramiteEnum.Vacio;
        TipoEnum gTipo = TipoEnum.Vacio;
        TipoEnum aTipo = TipoEnum.Vacio;
        PojoCliente[] pojoLista = archivoAPojo(configuracionCola);
        for (int i = 0; i < pojoLista.length; i++) {
            String gNombre = pojoLista[i].getNombre();
            int gId = Integer.parseInt(pojoLista[i].getId());
            int gEdad = Integer.parseInt(pojoLista[i].getEdad());
            String gHoraCreacion = pojoLista[i].getHoraCreacion();
            String gHoraAtencion = pojoLista[i].getHoraAtencion();
            String gnTramite = pojoLista[i].getTramite();
            switch (gnTramite) {
                case "Deposito":
                    gTramite = TramiteEnum.Deposito;
                    break;
                case "Retiro":
                    gTramite = TramiteEnum.Retiro;
                    break;
                case "CambioDivisas":
                    gTramite = TramiteEnum.CambioDivisas;
                    break;
            }
            String gnTipo = pojoLista[i].getTipo();
            switch (gnTipo) {
                case "Preferencial":
                    gTipo = TipoEnum.Preferencial;
                    break;
                case "UnTramite":
                    gTipo = TipoEnum.UnTramite;
                    break;
                case "MasTramites":
                    gTipo = TipoEnum.MasTramites;
                    break;
            }
            Cliente c = new Cliente(gNombre, gId, gEdad, gHoraCreacion, gHoraAtencion, gTramite, gTipo);
            listaClientes[i] = c;
            if (c.getTipo() == TipoEnum.Preferencial && !colaPreferencial.buscar(c.getId())) {
                colaPreferencial.encola(c);
            } else if (c.getTipo() == TipoEnum.UnTramite && !colaUnTramite.buscar(c.getId())) {
                colaUnTramite.encola(c);
            } else if (c.getTipo() == TipoEnum.MasTramites && !colaMasTramites.buscar(c.getId())) {
                colaMasTramites.encola(c);
            }
        }
        PojoCliente[] pojoListaAt = archivoAPojo(configuracionAtendidos);
        for (int i = 0; i < pojoListaAt.length; i++) {
            String aNombre = pojoListaAt[i].getNombre();
            int aId = Integer.parseInt(pojoListaAt[i].getId());
            int aEdad = Integer.parseInt(pojoListaAt[i].getEdad());
            String aHoraCreacion = pojoListaAt[i].getHoraCreacion();
            String aHoraAtencion = pojoListaAt[i].getHoraAtencion();
            String anTramite = pojoListaAt[i].getTramite();
            switch (anTramite) {
                case "Deposito":
                    aTramite = TramiteEnum.Deposito;
                    break;
                case "Retiro":
                    aTramite = TramiteEnum.Retiro;
                    break;
                case "CambioDivisas":
                    aTramite = TramiteEnum.CambioDivisas;
                    break;
            }
            String anTipo = pojoListaAt[i].getTipo();
            switch (anTipo) {
                case "Preferencial":
                    aTipo = TipoEnum.Preferencial;
                    break;
                case "UnTramite":
                    aTipo = TipoEnum.UnTramite;
                    break;
                case "MasTramites":
                    aTipo = TipoEnum.MasTramites;
                    break;
            }
            Cliente a = new Cliente(aNombre, aId, aEdad, aHoraCreacion, aHoraAtencion, aTramite, aTipo);
            listaClientesAtendidos[i] = a;
        }
        return listaClientes;
    }
///  CARGAR ATENDIDOS
    public Cliente[] cargarAtendidos(String configuracion){
        Cliente[] nListaClientesAtendidos = new Cliente[contarLineas(configuracion)];
        TipoEnum aTipo = TipoEnum.Vacio;
        TramiteEnum aTramite = TramiteEnum.Vacio;
        PojoCliente[] pojoListaAt = archivoAPojo(configuracion);
        for (int i = 0; i < pojoListaAt.length; i++) {
            String aNombre = pojoListaAt[i].getNombre();
            int aId = Integer.parseInt(pojoListaAt[i].getId());
            int aEdad = Integer.parseInt(pojoListaAt[i].getEdad());
            String aHoraCreacion = pojoListaAt[i].getHoraCreacion();
            String aHoraAtencion = pojoListaAt[i].getHoraAtencion();
            String anTramite = pojoListaAt[i].getTramite();
            switch (anTramite) {
                case "Deposito":
                    aTramite = TramiteEnum.Deposito;
                    break;
                case "Retiro":
                    aTramite = TramiteEnum.Retiro;
                    break;
                case "CambioDivisas":
                    aTramite = TramiteEnum.CambioDivisas;
                    break;
            }
            String anTipo = pojoListaAt[i].getTipo();
            switch (anTipo) {
                case "Preferencial":
                    aTipo = TipoEnum.Preferencial;
                    break;
                case "UnTramite":
                    aTipo = TipoEnum.UnTramite;
                    break;
                case "MasTramites":
                    aTipo = TipoEnum.MasTramites;
                    break;
            }
            Cliente a = new Cliente(aNombre, aId, aEdad, aHoraCreacion, aHoraAtencion, aTramite, aTipo);
            nListaClientesAtendidos[i] = a;
    }
        return nListaClientesAtendidos;
    }


/// CONTAR LINEAS
public int contarLineas(String configuracion) {
    int lineas = 0;
    try (BufferedReader contadorLineas = new BufferedReader(new FileReader(configuracion))) {
        while (contadorLineas.readLine() != null) {
            lineas++;
        }
    } catch (IOException ioe) {
        System.out.println(String.format("Error en contar lineas: %s", ioe.getMessage()));
    }
    return lineas;
}

/// ARCHIVO A POJO
public PojoCliente[] archivoAPojo(String configuracion) {
    int numClientes = contarLineas(configuracion);
    PojoCliente[] listaClientes = new PojoCliente[numClientes];
    try {
        BufferedReader pojoLector = new BufferedReader(new FileReader(configuracion));
        String linea;
        for (int i = 0; (linea = pojoLector.readLine()) != null && i < numClientes; i++) {
            String[] datos = linea.split(",");
            if (datos.length == 7) {
                listaClientes[i] = new PojoCliente();
                listaClientes[i].setNombre(datos[0]);
                listaClientes[i].setId(datos[1]);
                listaClientes[i].setEdad(datos[2]);
                listaClientes[i].setHoraCreacion(datos[3]);
                listaClientes[i].setHoraAtencion(datos[4]);
                listaClientes[i].setTramite(datos[5]);
                listaClientes[i].setTipo(datos[6]);
                System.out.println(listaClientes[i].toString());
            }
        }
        pojoLector.close();
    } catch (IOException ioe) {
        System.out.println(String.format("El error es: %s", ioe.getMessage()));
    }
    return listaClientes;
}
/// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
/// ☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻☻☻☻☻☻☻☻CARGAR INFO☻///

/// ☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻///
/// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///
public String mostrarClientes() {
    String r = "";
    for (int i = 0; i < this.listaClientes.length; i++) {
        r += String.format("Nombre: %s\nID: %s\nHora Creacion: %s\nHora Atencion: %s\nTramite: %s\nTipo: %s\n*---------*---------*\n",
                listaClientes[i].getNombre(), listaClientes[i].getId(), listaClientes[i].getHoraCreacion(), listaClientes[i].getHoraAtencion(), listaClientes[i].getTramite(), listaClientes[i].getTipo());
    }
    return r;
}

/// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
/// ☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻☻☻☻☻☻☻☻MOSTRAR CLIENTES☻///

/// ☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻///
/// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///
///
/// MAIN INGRESAR CLIENTE
public int ingresarCliente() {

    try {
        TipoEnum nTipo = TipoEnum.Vacio;
        TramiteEnum nTramite = TramiteEnum.Vacio;
        String nNombre = JOptionPane.showInputDialog(null, "Ingrese nombre del cliente");
        if(nNombre.contains(",")){
            JOptionPane.showMessageDialog(null, "No se admiten caracteres especiales");
            return -1;
        }
        int nId = idMayor() + 1;
        int nEdad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese edad del cliente"));
        String nHoraCreacion = obtenerHora();
        String nHoraAtencion = "-1";
        int nnTipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija el tipo de cliente:" +
                " \n1. Preferencial \n2. Un solo tramite\n3. Dos o más tramites"));
        switch (nnTipo) {
            case 1:
                nTipo = TipoEnum.Preferencial;
                break;
            case 2:
                nTipo = TipoEnum.UnTramite;
                break;
            case 3:
                nTipo = TipoEnum.MasTramites;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: Valor ingresado no valido, reintente");
                return 1;
        }
        int nnTramite = Integer.parseInt(JOptionPane.showInputDialog(null, "Elija el tramite del cliente:" +
                " \n1. Deposito \n2. Retiro\n3. Cambio de divisas")); //Deposito, Retiro, CambioDivisas
        switch (nnTramite) {
            case 1:
                nTramite = TramiteEnum.Deposito;
                break;
            case 2:
                nTramite = TramiteEnum.Retiro;
                break;
            case 3:
                nTramite = TramiteEnum.CambioDivisas;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Error: Valor ingresado no valido, reintente");
                return 2;
        }
        JOptionPane.showMessageDialog(null, String.format("Ticket del cliente:\nNombre: %s\nID: %s\nEdad: %s\nHora de creacion: %s\nHora de atención: %s\nTramite: %s\nTipo: %s", nNombre, nId, nEdad, nHoraCreacion, nHoraAtencion, nTramite, nTipo));
        escribirArchivo(String.format("%s,%s,%s,%s,%s,%s,%s", nNombre, nId, nEdad, nHoraCreacion, nHoraAtencion, nTramite, nTipo), configuracionCola);
        cargarInfo();
    } catch (Exception e) {
        System.out.println("Error en ingreso de cliente: " + e);
    }
    return 0;
}

/// ID mayor
public int idMayor() {
    int idMayor = 0;
    for (int i = 0; i < listaClientes.length; i++) {
        if (listaClientes[i].getId() > idMayor) {
            idMayor = listaClientes[i].getId();
        }
    }
    return idMayor;
}

///  Hora creacion
public String obtenerHora() {
    DateTimeFormatter formateo = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    String fechaHoraActualFormateada = now.format(formateo);
    String horaActualFormateada = fechaHoraActualFormateada.substring(11);
    return horaActualFormateada;
}

/// Escribir archivo
public void escribirArchivo(String contenido, String archivo) {
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo, true))) {
        escritor.write(contenido);
        escritor.newLine();
        System.out.println("Escritura completada.");
    } catch (IOException e) {
        System.out.println("Ocurrió un error al escribir el archivo: " + e.getMessage());
    }
}

/// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
/// ☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻☻☻☻☻☻☻☻INGRESAR CLIENTES☻///

/// ☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻///
/// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///

public void mostrarColas() {
    JOptionPane.showMessageDialog(null, "Cola preferencial:\n" + colaPreferencial.toString());
    JOptionPane.showMessageDialog(null, "Cola de un tramite:\n" + colaUnTramite.toString());
    JOptionPane.showMessageDialog(null, "Cola de multiples tramites:\n" + colaMasTramites.toString());
}

/// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
/// ☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻☻☻MOSTRAR COLA☻☻☻☻☻☻///

/// ☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻☻☻☻☻☻☻///
/// ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓///
///
/// MAIN ATENDER CLIENTE
public void atenderCliente() {
    int indice = Integer.parseInt(JOptionPane.showInputDialog(null,
            "¿Qué cola desea atender?\n 1. Preferencial\n2. Un tramite\n3. Multiples tramites"));
    switch (indice) {
        case 1:
            borrarDeColaTxt(colaPreferencial.getFrente().getCliente().getPojoEnCola());
            escribirArchivo(colaPreferencial.getFrente().getCliente().getPojoAtendido(), configuracionAtendidos);
            colaPreferencial.atiende();
            break;
        case 2:
            borrarDeColaTxt(colaUnTramite.getFrente().getCliente().getPojoEnCola());
            escribirArchivo(colaUnTramite.getFrente().getCliente().getPojoAtendido(), configuracionAtendidos);
            colaUnTramite.atiende();
            break;
        case 3:
            borrarDeColaTxt(colaMasTramites.getFrente().getCliente().getPojoEnCola());
            escribirArchivo(colaMasTramites.getFrente().getCliente().getPojoAtendido(), configuracionAtendidos);
            colaMasTramites.atiende();
            break;
    }
}

public void borrarDeColaTxt(String clienteBorrar) {
    int linea = 0;
    for (int i = 0; i < listaClientes.length; i++) {
        if (!listaClientes[i].getPojoEnCola().equals(clienteBorrar) && linea == 0) {
            reescribirArchivo(listaClientes[i].getPojoEnCola(), configuracionCola);
            linea++;
        } else if (!listaClientes[i].getPojoEnCola().equals(clienteBorrar) && linea == 1) {
            escribirArchivo(listaClientes[i].getPojoEnCola(), configuracionCola);
        }
    }
}

public void reescribirArchivo(String contenido, String archivo) {
    try (BufferedWriter reescritor = new BufferedWriter(new FileWriter(archivo, false))) {
        reescritor.write(contenido);
        reescritor.newLine();
        System.out.println("Escritura completada.");
    } catch (IOException e) {
        System.out.println("Ocurrió un error al reescribir el archivo: " + e.getMessage());
    }
}

public void mostrarAtendidos(){
    this.listaClientesAtendidos = cargarAtendidos(configuracionAtendidos);
    String r = "";
    for (int i = 0; i < listaClientesAtendidos.length; i++) {
        r += listaClientesAtendidos[i].toString()+"\n";
    }
    JOptionPane.showMessageDialog(null, "Lista de atendidos:\n" + r);
}

private Caja[] cajas = {
    new Caja("Caja 1", 10, 50.0),
    new Caja("Caja 2", 15, 70.0),
    new Caja("Caja 3", 7, 20.0)
};

public Caja[] getCajas() {
    return cajas;
}


/// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑///
/// ☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻ATENDER CLIENTE☻☻☻☻☻☻☻☻☻☻☻☻☻☻///

///*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*///
}


