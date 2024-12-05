package menu;

import banco.Banco;
import usuarios.Usuario;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import usuarios.utils.Rol;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal{
    Banco banco;
    Scanner scanner = new Scanner(System.in);

    public MenuPrincipal(Banco banco) {
        this.banco = banco;
    }

    public void iniciarSesion() {
        int intentosMaximos = 3, intentosUsuario = 0;
        System.out.println("--------------------------");
        System.out.println("- Bienvenido al PonyBank -");
        System.out.println("--------------------------");

        while (intentosUsuario < intentosMaximos) {
            System.out.println("\n-- Inicia Sesión --");

            System.out.println("\nIngresa el usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa la contrasenia: ");
            String contrasenia = scanner.nextLine();

            Usuario usuarioEnSesion = banco.validarInicioSesion(usuario, contrasenia);

            if (usuarioEnSesion instanceof Usuario) {
                if (usuarioEnSesion.getRol() == Rol.GERENTE) {
                    Gerente gerenteEnSesion = (Gerente) usuarioEnSesion;
                    MenuGerente menuGerente = new MenuGerente();
                    int opcionGerente;
                    boolean sesion = true;
                    while (sesion) {
                        opcionGerente = menuGerente.mostrarMenu(gerenteEnSesion);
                        sesion = menuGerente.procesarDatos(opcionGerente, banco, gerenteEnSesion);
                    }
                    intentosUsuario = 0;
                } else if (usuarioEnSesion.getRol() == Rol.EJECUTIVO) {
                    Ejecutivo ejecutivoEnSesion = (Ejecutivo) usuarioEnSesion;
                    MenuEjecutivo menuEjecutivo = new MenuEjecutivo();
                    int opcionEjecutivo;
                    boolean sesion = true;
                    while (sesion) {
                        opcionEjecutivo = menuEjecutivo.mostrarMenu(ejecutivoEnSesion);
                        sesion = menuEjecutivo.procesarDatos(opcionEjecutivo, banco, ejecutivoEnSesion);
                    }
                    intentosUsuario = 0;
                } else {
                    Cliente clienteEnSesion = (Cliente) usuarioEnSesion;
                    MenuCliente menuCliente = new MenuCliente();
                    int opcionCliente;
                    boolean sesion = true;
                    while (sesion) {
                        opcionCliente = menuCliente.mostrarMenu(clienteEnSesion);
                        sesion = menuCliente.procesarDatos(opcionCliente, banco, clienteEnSesion);
                    }
                    intentosUsuario = 0;
                }
            } else {
                System.out.println("\nError: Credenciales Incorrectas");
                System.out.println("1.- Intentar nuevamente");
                System.out.println("2.- Terminar programa");

                try {
                    System.out.print("Seleccione una opcion: ");
                    int op = scanner.nextInt();

                    switch (op) {
                        case 1:
                            intentosUsuario++;
                            scanner.nextLine();
                            break;
                        case 2:
                            intentosUsuario = intentosMaximos;
                            break;
                        default:
                            System.out.println("Opción invalida");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida: " + e.getMessage());
                }
            }
        }
    }
}