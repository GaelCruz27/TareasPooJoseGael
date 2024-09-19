package ejercicioHospital;
import java.util.Scanner;
import ejercicioHospital.hospital.Hospital;
import ejercicioHospital.consultas.Consulta;
import ejercicioHospital.consultorio.Consultorio;
import ejercicioHospital.medicos.Medico;
import ejercicioHospital.pacientes.Paciente;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("1. Registrar Paciente");
            System.out.println("2. Registrar Medico");
            System.out.println("3. Registrar Consultorio");
            System.out.println("4. Registrar Consulta");
            System.out.println("5. Salir");

            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            }
        }

    }
