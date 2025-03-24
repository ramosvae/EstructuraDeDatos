package semiproyecto;

import javax.swing.*;

public class Menu {

    String[] users = {"Erick", "Fabian", "Joseline", "Dylan"};
    String[] passW = {"1234", "4321", "1324", "3214"};
    Gestion g = new Gestion();

    public void menu() {
        try {
            int index = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "/  /  /  /  / Menu de cajas /  /  /  /  /\n\n" +
                            "1. Ingresar nuevo cliente a la cola\n" +
                            "2. Atender cliente en cola\n" +
                            "3. Mostrar las colas\n" +
                            "4. Mostrar atendidos\n" +
                            "5. Terminar programa\n" +
                            ""
                            + g.getDolar()));
            switch (index) {
                case 1:
                    g.ingresarCliente();
                    menu();
                    break;
                case 2:
                    g.atenderCliente();
                    menu();
                    break;
                case 3:
                    g.mostrarColas();
                    menu();
                    break;
                case 4:
                    g.mostrarAtendidos();
                    menu();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    menu();
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error en menu: " + e.getMessage());
            menu();
        }
    }

    public void login() {
        try {
            String user = JOptionPane.showInputDialog(null, "Ingrese el usuario: \n\nEscriba 'salir' para salir");
            if (user.equals("salir")) {
                System.exit(0);
            }
            String pass = JOptionPane.showInputDialog(null, "Ingrese la contraseña: ");
            for (int i = 0; i < users.length; i++) {
                if (user.equals(users[i]) && pass.equals(passW[i])) {
                    JOptionPane.showMessageDialog(null, String.format("Acceso exitoso, bienvenido %s", user));
                    menu();
                }
            }
            JOptionPane.showMessageDialog(null, "Usuario o contraseña no válidos, reintente");
            login();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            login();
        }
    }
}
