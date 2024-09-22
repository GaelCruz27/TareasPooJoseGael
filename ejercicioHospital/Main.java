package ejercicioHospital;
import java.util.Scanner;
import ejercicioHospital.hospital.Hospital;
import ejercicioHospital.pacientes.Paciente;
import ejercicioHospital.medicos.Medico;
import ejercicioHospital.consultas.Consulta;
import ejercicioHospital.consultorio.Consultorio;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        while(opcion != 9) {
            System.out.println("Bienvenido al IMSS ");
            System.out.println("Introduzca la opción que desee:  ");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar medico");
            System.out.println("3. Registrar consultorio");
            System.out.println("4. Registrar consulta");
            System.out.println("5. Mostrar pacientes");
            System.out.println("6. Mostrar médicos");
            System.out.println("7. Mostrar consultorios");
            System.out.println("8. Mostrar consultas");
            System.out.println("9. Mostrar paciente por ID");
            System.out.println("10. Mostrar Medico por ID");
            System.out.println("11. Mostrar Consultorio por ID");
            System.out.println("12. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("A elegido la opcion REGISTRAR PACIENTE");
                    String id = hospital.generarIDPaciente();

                    System.out.println("Ingrese el nombre del paciente: ");
                    String nombre = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese el apellido del paciente: ");
                    String apellido = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese la fecha de nacimiento del paciente: ");
                    String fechaNacimiento = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese el tipo de sangre del paciente: ");
                    String tipoSangre = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese el sexo del paciente: ");
                    char sexo = sc.next().charAt(0);
                    sc.nextLine();

                    System.out.println("Ingrese el teléfono del paciente: ");
                    String telefono = sc.nextLine();
                    sc.nextLine();

                    Paciente paciente = new Paciente(id, nombre, apellido, fechaNacimiento, tipoSangre, sexo, telefono);
                    hospital.registrarPaciente(paciente);

                    System.out.println("Paciente registrado exitosamente");
                    break;

                case 2:
                    System.out.println("A elegido la opcion REGISTRAR MEDICO");
                    String idMedico="Default";
                    sc.nextLine();

                    System.out.println("Ingrese el nombre del medico: ");
                    String nombreMedico = sc.nextLine();

                    System.out.println("Ingrese el apellido del medico: ");
                    String apellidoMedico = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese la fecha de nacimiento del medico(DDMMYYYY): ");
                    String fechaNacimientoMedico = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese el telefono del medico: ");
                    String telefonoMedico = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Ingrese el RFC del medico: ");
                    String rfcMedico = sc.nextLine();
                    sc.nextLine();

                    Medico medico = new Medico(idMedico, nombreMedico, apellidoMedico, fechaNacimientoMedico, telefonoMedico, rfcMedico);
                    medico.setId(hospital.generarIDMedico(medico));
                    hospital.registrarMedico(medico);
                    break;

                case 3:
                    System.out.println("A elegido la opcion REGISTRAR CONSULTORIO");
                    String idConsultorio = "0";

                    System.out.println("Ingrese el piso del consultorio: ");
                    int piso = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Ingrese el numero del consultorio: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    Consultorio consultorio = new Consultorio(idConsultorio, piso, numero);
                    consultorio.setId(hospital.generarIDConsultorio(consultorio));
                    hospital.registrarConsultorios(consultorio);
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("A elegido la opcion MOSTRAR PACIENTES");
                    System.out.println("Los pacientes son los siguientes: ");
                    hospital.mostrarPacientes();
                    break;
                case 6:
                    System.out.println("A elegido la opcion MOSTRAR MEDICOS");
                    System.out.println("Los medicos son los siguientes: ");
                    hospital.mostrarMedicos();
                    break;
                case 7:
                    System.out.println("A elegido la opcion MOSTRAR CONSULTORIOS");
                    System.out.println("Los consultorios son los siguientes: ");
                    hospital.mostrarConsultorios();
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("\nA elegido la opcion MOSTRAR PACIENTE POR ID");
                    sc.nextLine();
                    System.out.println("Ingresa el ID del paciente que deseas buscar");
                    String idPaciente = sc.nextLine();

                    hospital.mostrarPacientePorId(idPaciente);
                    break;

                case 10:
                    System.out.println("\nA elegido la opcion MOSTRAR MEDICO POR ID");
                    sc.nextLine();
                    System.out.println("Ingresa el ID del medico que deseas buscar");
                    idMedico = sc.nextLine();
                    hospital.mostrarMedicoPorID(idMedico);
                    break;

                case 11:
                    System.out.println("\nA elegido la opcion MOSTRAR CONSULTORIO POR ID");
                    sc.nextLine();
                    System.out.println("Ingrese el ID del consultorio que deseas buscar");
                    idConsultorio = sc.nextLine();
                    hospital.mostrarConsultorioPorID(idConsultorio);
                    break;

                case 12:
                    System.out.println("Hasta Luego");
                    return;
            }
        }
    }
}