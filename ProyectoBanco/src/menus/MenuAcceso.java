package menus;

import banco.Banco;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAcceso {
    Banco banco;
    Scanner scanner = new Scanner(System.in);

    public MenuAcceso(Banco banco) {
        this.banco = banco;
    }

    public void iniciarSesion() {
        int intentosMaximos = 3, intentosUsuario = 0;


    //Aqui falta el diseño del banco


        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n-- MENU ACCESO --");

            System.out.println("\nIngresa tu Usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = banco.validarInicioSesion(usuario, contrasenia);

            if (usuarioEnSesion != null) {
                switch (usuarioEnSesion.getRol()) {
                    case GERENTE -> {
                        Gerente gerenteEnSesion = (Gerente) usuarioEnSesion;
                        MenuGerente menuGerente = new MenuGerente();
                        int opcionGerente;
                        boolean sesion = true;
                        while (sesion) {
                            opcionGerente = menuGerente.mostrarMenu(gerenteEnSesion);
                            sesion = menuGerente.procesarDatos(opcionGerente, banco, gerenteEnSesion);
                        }
                    }
                    case EJECUTIVO -> {
                        Ejecutivo ejecutivoEnSesion = (Ejecutivo) usuarioEnSesion;
                        MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
                        int opcionEjecutivo;
                        boolean sesion = true;
                        while (sesion) {
                            opcionEjecutivo = menuEjecutivo.mostrarMenu(ejecutivoEnSesion);
                            sesion = menuEjecutivo.procesarDatos(opcionEjecutivo, banco, ejecutivoEnSesion);
                        }
                    }
                    case CLIENTE -> {
                        Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                        MenuCliente menuCliente = new MenuCliente();
                        int opcionCliente;
                        boolean sesion = true;
                        while (sesion) {
                            opcionCliente = menuCliente.mostrarMenu(clienteEnSesion);
                            sesion = menuCliente.procesarDatos(opcionCliente, banco, clienteEnSesion);
                        }
                    }
                }
                intentosUsuario = 0;
            } else {
                System.out.println("\nUSUARIO o CONTRASENIA incorrectos intenta de nuevo.");
                System.out.println("1.- Reintentar");
                System.out.println("2.- Salir");

                try {
                    System.out.print("Selecciona una opción: ");
                    int op = scanner.nextInt();

                    switch (op) {
                        case 1 -> intentosUsuario++;
                        case 2 -> intentosUsuario = intentosMaximos;
                        default -> System.out.println("Opción no válida, intenta de nuevo.");
                    }
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Dato invalido " + e.getMessage());
                    scanner.nextLine();
                }
            }
        }
    }
}
