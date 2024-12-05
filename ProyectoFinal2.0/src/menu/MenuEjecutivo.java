package menu;

import tarjetas.Debito;
import banco.Banco;
import usuarios.cliente.Cliente;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.utils.Rol;

import java.util.Scanner;

public class MenuEjecutivo {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Ejecutivo ejecutivoEnSesion) {
        System.out.println("\n== Bienvenido Ejecutivo " + ejecutivoEnSesion.getNombre() + " ==\n");
        System.out.println("1. Ver mi información.");
        System.out.println("2. Ver clientes.");
        System.out.println("3. Ingresar nuevo cliente.");
        System.out.println("4. Gestionar solisitudes de clientes");
        System.out.println("5. Salir ");

        try {
            System.out.print("Seleccione una opción: ");
            return scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de dato no solicitado");
            return 0;
        }
    }

    public boolean procesarDatos(int opcionEjecutivo, Banco banco, Ejecutivo ejecutivoEnSesion) {
        switch (opcionEjecutivo) {
            case 1:
                System.out.println("\n== Mi Información ==\n");
                System.out.println(ejecutivoEnSesion.mostrarDatos());
                break;
            case 2:
                System.out.println("\n== Clientes Del Banco ==\n");
                banco.mostrarClientes();
                break;
            case 3:
                scanner.nextLine();
                System.out.println("\n--INGRESAR NUEVO CLIENTE--");

                System.out.println("Ingrese el nombre del cliente: ");
                String nombreCliente = scanner.next();

                scanner.nextLine();

                System.out.println("Ingrese el apellido del cliente: ");
                String apellidoCliente = scanner.nextLine();

                System.out.println("Ingrese la dirección del cliente: ");
                String direccionCliente = scanner.nextLine();

                System.out.println("Ingrese la sucursal afiliada al cliente: ");
                String sucursalCliente = scanner.nextLine();

                System.out.println("Ingrese una contraseña segura y guardela: ");
                String contraseniaCliente = scanner.nextLine();

                String curp = banco.generarCurp();
                String rfc = banco.generarRfc();
                String id = banco.generarIdUsuario(nombreCliente, Rol.CLIENTE);


                String numeroDeCuenta = banco.generarNumeroDeCuenta();
                String numeroTarjetaDebito = banco.generarNumeroDeTarjetaDedito();
                String clave = banco.generarClaveInterbancaria();
                String titular = nombreCliente + " " + apellidoCliente;

                Debito debito = new Debito(titular, numeroTarjetaDebito, 0);
                Cliente cliente = new Cliente(id, nombreCliente, apellidoCliente, curp, rfc, direccionCliente, sucursalCliente, contraseniaCliente, numeroDeCuenta, debito, clave);

                banco.registrarCliente(cliente);

                System.out.println("Usuario: " + id + " | Nombre: " + nombreCliente + apellidoCliente + " | Contraseña: " + contraseniaCliente);
                break;
            case 4:
                System.out.println("\n== Solicitudes De Tarjeta De Crédito ==\n");
                gestionarSolicitudes(banco);
                break;
            case 5:
                System.out.println("Saliendo...");
                return false;
            default:
                System.out.println("Opción invalida, intente de nuevo");
        }
        return true;
    }

    public void gestionarSolicitudes(Banco banco) {
        banco.verSolicitudesPendientes();
        scanner.nextLine();

        if (!banco.solicitudesTarjetaCredito.isEmpty()) {
            System.out.println("\nIngrese el id del cliente para procesar su solicitud");
            String id = scanner.nextLine();
            Cliente cliente = buscarClientePorId(banco, id);

            if (cliente != null) {
                System.out.print("¿Aprobar la solicitud? (1 para sí, 2 para no): ");
                int decision = scanner.nextInt();
                boolean aprobar = decision == 1;

                String resultado = banco.procesarSolicitudTarjeta(cliente, aprobar);
                System.out.println(resultado);
            } else {
                System.out.println("Cliente no encontrado");
            }
        }
    }

    private Cliente buscarClientePorId(Banco banco, String id) {
        for (Cliente cliente : banco.solicitudesTarjetaCredito) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }

        return null;
    }
}