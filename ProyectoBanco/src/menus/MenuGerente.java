package menus;

import banco.Banco;
import usuarios.ejecutivo.Ejecutivo;
import usuarios.gerente.Gerente;
import usuarios.utils.Rol;

import java.util.Scanner;

public class MenuGerente {
    public Scanner scanner = new Scanner(System.in);

    public int mostrarMenu(Gerente gerenteEnSesion) {
        System.out.println("\n== Bienvenido Gerente " + gerenteEnSesion.getNombre() + " ==\n");
        System.out.println("1. Consulta de información.");
        System.out.println("2. Registrar ejecutivo.");
        System.out.println("3. Registrar gerente");
        System.out.println("4. Ver clientes. ");
        System.out.println("5. Ver ejecutivos. ");
        System.out.println("6. Ver gerentes");
        System.out.println("7. Salir ");

        try {
            System.out.print("Seleccione una opción: ");
            return scanner.nextInt();
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de dato no solicitado");
            return 0;
        }
    }

    public boolean procesarDatos(int opcionGerente, Banco banco, Gerente gerenteEnSesion) {
        switch (opcionGerente) {
            case 1:
                System.out.println("\n" + gerenteEnSesion.mostrarDatos());
                break;
            case 2:
                System.out.println("\n--INGRESAR NUEVO EJECUTIVO--");

                System.out.println("Ingrese el nombre : ");
                String nombreEjecutivo = scanner.next();

                scanner.nextLine();

                System.out.println("Ingrese el apellido : ");
                String apellidoEjecutivo = scanner.nextLine();

                System.out.println("Ingrese la dirección : ");
                String direccionEjecutivo = scanner.nextLine();

                System.out.println("Ingrese la sucursal donde trabajara: ");
                String sucursalEjecutivo = scanner.nextLine();

                System.out.println("Ingrese una contraseña (Esta informacion es confidencial y personal, no compartirla): ");
                String contraseniaEjecutivo = scanner.nextLine();

                System.out.println("Ingrese el salario mensual que se le asignara al ejecutivo: ");
                double salarioEjecutivo = scanner.nextDouble();

                String id = banco.generarIdUsuario(nombreEjecutivo, Rol.EJECUTIVO);
                String curp = banco.generarCurp();
                String rfc = banco.generarRfc();

                Ejecutivo ejecutivo = new Ejecutivo(id, nombreEjecutivo, apellidoEjecutivo, curp, rfc, direccionEjecutivo, sucursalEjecutivo, contraseniaEjecutivo, salarioEjecutivo);
                banco.registrarEjecutivo(ejecutivo);

                System.out.println("Usuario: " + id + " | Nombre: " + nombreEjecutivo + " " +  apellidoEjecutivo + " | Contraseña: " + contraseniaEjecutivo);
                break;
            case 3:
                System.out.println("\n--INGRESAR NUEVO GERENTE--");

                System.out.println("Ingrese el nombre : ");
                String nombreGerente = scanner.next();

                scanner.nextLine();

                System.out.println("Ingrese el apellido : ");
                String apellidoGerente = scanner.nextLine();

                System.out.println("Ingrese la dirección : ");
                String direccionGerente = scanner.nextLine();

                System.out.println("Ingrese la sucursal donde trabajara: ");
                String sucursalGerente = scanner.nextLine();

                System.out.println("Ingrese una contraseña (Esta informacion es confidencial y personal, no compartirla): ");
                String contraseniaGerente = scanner.nextLine();

                System.out.println("Ingrese el salario mensual que se le asignara al empleado: ");
                double salarioGerente = scanner.nextDouble();

                String idG = banco.generarIdUsuario(nombreGerente, Rol.GERENTE);
                String curpG = banco.generarCurp();
                String rfcG = banco.generarRfc();

                Gerente gerente = new Gerente(idG, nombreGerente, apellidoGerente, curpG, rfcG, direccionGerente, sucursalGerente, contraseniaGerente, salarioGerente);
                banco.registrarGerente(gerente);

                System.out.println("Usuario: " + idG + " | Nombre: " + nombreGerente + " " + apellidoGerente + " | Contraseña: " + contraseniaGerente);
                break;
            case 4:
                System.out.println("\n== Clientes Del Banco ==\n");
                banco.mostrarClientes();
                break;
            case 5:
                System.out.println("\n== Ejecutivos Del Banco ==\n");
                banco.mostrarEjecutivos();
                break;
            case 6:
                System.out.println("\n== Gerentes Del Banco ==\n");
                banco.mostrarGerentes();
                break;
            case 7:
                System.out.println("Saliendo...");
                return false;
            default:
                System.out.println("Opcion no valida, intentelo de nuevo: ");
        }
        return true;
    }
}