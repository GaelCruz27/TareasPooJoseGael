import java.util.ArrayList;
import java.util.Scanner;

public class SistemaReservas {
    private static ArrayList<Habitacion> habitaciones;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        inicializarSistema();
        mostrarMenu();
    }
    
    private static void inicializarSistema() {
        habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion("Individual", 50.0));
        habitaciones.add(new Habitacion("Doble", 75.0));
        habitaciones.add(new Habitacion("Suite", 150.0));
        scanner = new Scanner(System.in);
    }
    
    private static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Sistema de Reservas de Habitaciones ---");
            System.out.println("1. Mostrar detalles de las habitaciones");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Liberar una habitación");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarDetallesHabitaciones();
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    liberarHabitacion();
                    break;
                case 4:
                    System.out.println("Gracias por usar el sistema de reservas.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 4);
        scanner.close();
    }
    
    private static void mostrarDetallesHabitaciones() {
        System.out.println("\nDetalles de las habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarDetalles();
            System.out.println();
        }
    }
    
    private static void realizarReserva() {
        System.out.print("\nIngrese el número de habitación (1: Individual, 2: Doble, 3: Suite): ");
        int numeroHabitacion = scanner.nextInt();
        
        if (numeroHabitacion < 1 || numeroHabitacion > habitaciones.size()) {
            System.out.println("Número de habitación no válido.");
            return;
        }
        
        Habitacion habitacion = habitaciones.get(numeroHabitacion - 1);
        
        System.out.print("Ingrese el número de noches a reservar: ");
        int noches = scanner.nextInt();
        
        try {
            habitacion.reservar(noches);
            double costoTotal = habitacion.getPrecioPorNoche() * noches;
            System.out.println("Reserva exitosa para " + noches + " noches.");
            System.out.println("Costo total de la reserva: " + costoTotal);
        } catch (HabitacionNoDisponibleException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumeroDeNochesInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void liberarHabitacion() {
        System.out.print("\nIngrese el número de habitación para liberar (1: Individual, 2: Doble, 3: Suite): ");
        int numeroHabitacion = scanner.nextInt();
        
        if (numeroHabitacion < 1 || numeroHabitacion > habitaciones.size()) {
            System.out.println("Número de habitación no válido.");
            return;
        }
        
        Habitacion habitacion = habitaciones.get(numeroHabitacion - 1);
        if (!habitacion.isDisponible()) {
            habitacion.liberar();
            System.out.println("La habitación ha sido liberada y está disponible nuevamente.");
        } else {
            System.out.println("La habitación ya está disponible.");
        }
    }
}