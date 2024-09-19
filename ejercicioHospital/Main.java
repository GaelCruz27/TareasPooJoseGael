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
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el ID del paciente: ");
                    int idPaciente = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el nombre del paciente: ");
                    String nombrePaciente = scanner.nextLine();
                    System.out.print("Introduce los apellidos del paciente: ");
                    String apellidosPaciente = scanner.nextLine();
                    System.out.print("Introduce la edad del paciente: ");
                    String edadPaciente = scanner.nextLine();
                    System.out.print("Introduce la fecha de nacimiento del paciente: ");
                    String fechaNacimientoPaciente = scanner.nextLine();
                    System.out.print("Introduce el teléfono del paciente: ");
                    String telefonoPaciente = scanner.nextLine();
                    System.out.print("Introduce el tipo de sangre del paciente: ");
                    String tipoSangrePaciente = scanner.nextLine();
                    System.out.print("Introduce el sexo del paciente (M/F): ");
                    char sexoPaciente = scanner.nextLine().charAt(0);
                    Paciente paciente = new Paciente(idPaciente, nombrePaciente, apellidosPaciente, edadPaciente, fechaNacimientoPaciente, telefonoPaciente, tipoSangrePaciente, sexoPaciente);
                    hospital.registrarPaciente(paciente);
                    System.out.println("Paciente registrado.");
                    break;
                case 2:
                    System.out.print("Introduce el ID del medico: ");
                    int idMedico = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el nombre del medico: ");
                    String nombreMedico = scanner.nextLine();
                    System.out.print("Introduce los apellidos del medico: ");
                    String apellidosMedico = scanner.nextLine();
                    System.out.print("Introduce la fecha de nacimiento del medico: ");
                    String fechaNacimientoMedico = scanner.nextLine();
                    System.out.print("Introduce el teléfono del medico: ");
                    String telefonoMedico = scanner.nextLine();
                    System.out.print("Introduce el RFC del medico: ");
                    String rfcMedico = scanner.nextLine();
                    Medico medico = new Medico(idMedico, nombreMedico, apellidosMedico, fechaNacimientoMedico, telefonoMedico, rfcMedico);
                    hospital.registrarMedico(medico);
                    System.out.println("Medico registrado.");
                    break;
                case 3:
                    System.out.print("Introduce el ID del consultorio: ");
                    int idConsultorio = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el piso del consultorio: ");
                    int pisoConsultorio = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el número del consultorio: ");
                    int numeroConsultorio = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    Consultorio consultorio = new Consultorio(idConsultorio, pisoConsultorio, numeroConsultorio);
                    hospital.registrarConsultorio(consultorio);
                    System.out.println("Consultorio registrado.");
                    break;
                case 4:
                    System.out.print("Introduce la fecha y hora de la consulta: ");
                    String fechaHora = scanner.nextLine();
                    System.out.print("Introduce el ID del paciente: ");
                    int idPacienteConsulta = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el ID del medico: ");
                    int idMedicoConsulta = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    System.out.print("Introduce el ID del consultorio: ");
                    int idConsultorioConsulta = scanner.nextInt();
                    scanner.nextLine();  // Consumir la nueva línea
                    Paciente pacienteConsulta = new Paciente(idPacienteConsulta, "", "", "", "", "", "", ' ');
                    Medico medicoConsulta = new Medico(idMedicoConsulta, "", "", "", "", "");
                    Consultorio consultorioConsulta = new Consultorio(idConsultorioConsulta, 0, 0);


                    System.out.println("Consulta registrada.");
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 5");
            }
        }
        scanner.close();
    }
}