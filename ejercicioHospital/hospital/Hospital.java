package ejercicioHospital.hospital;

import ejercicioHospital.consultas.Consulta;
import ejercicioHospital.consultorio.Consultorio;
import ejercicioHospital.medicos.Medico;
import ejercicioHospital.pacientes.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedicos = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorios = new ArrayList<>();
    private ValidadorHospital validador = new ValidadorHospital();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

    public void registrarConsulta(Consulta consulta) {

        if (!validador.validarDispolnibilidadEnFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsultas)) {
            System.out.println("Ya existe una consulta registrada par esa fecha");
            return;
        }

        if (!validador.validarDisponibilidadMedico(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsultas)) {
            System.out.println("El medico no tiene disponibilidad en esa fecha");
            return;
        }

        this.listaConsultas.add(consulta);
    }


    public void registrarConsultorios(Consultorio consultorio) {
        this.listaConsultorios.add(consultorio);
    }

    public void mostrarPacientes() {
        for (Paciente paciente : this.listaPacientes) {
            System.out.println("ID: " + paciente.getId());
            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("Apellidos: " + paciente.getApellidos());
            System.out.println("Fecha de nacimiento: " + paciente.getFechaNacimiento());
            System.out.println("Tipo de Sangre: " + paciente.getTipoSangre());
            System.out.println("Sexo: " + paciente.getSexo());
            System.out.println("Telefono: " + paciente.getTelefono());
        }
    }

    public void mostrarMedicos() {
        for (Medico medico : this.listaMedicos) {
            System.out.println("ID: " + (medico.getId()));
            System.out.println("Nombre: " + (medico.getNombre()));
            System.out.println("Apellidos: " + (medico.getApellidos()));
            System.out.println("Fecha de nacimiento: " + (medico.getFechaNacimiento()));
            System.out.println("Telefono: " + (medico.getTelefono()));
            System.out.println("RFC: " + (medico.getRfc()));
            System.out.println(" ");
        }
    }

    public void mostrarConsultorios() {
        for (Consultorio consultorio : this.listaConsultorios) {
            System.out.println("ID: " + (consultorio.getId()));
            System.out.println("Piso: " + (consultorio.getPiso()));
            System.out.println("Numero de consultorio: " + (consultorio.getNumeroConsultorio()));
            System.out.println(" ");
        }
    }

    public void mostrarConsultas() {
        for (Consulta consulta : this.listaConsultas) {
            System.out.println("ID: " + (consulta.getId()));
            System.out.println("Fecha y hora: "+ (consulta.getFechaHora()));
            System.out.println("Pasciente: "+ (consulta.getPaciente()));
            System.out.println("Medico: "+ (consulta.getMedico()));
            System.out.println("Consultorio: "+ (consulta.getConsultorio()));
            System.out.println(" ");
        }
    }
    //PACIENTE
    public String generarIDPaciente() {
        Random random = new Random();
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacientesMasUno = this.listaPacientes.size() + 1;
        int numeroAleatorio = random.nextInt(1, 100000);

        String idPaciente = String.format("P%d%d%d%d", anoActual, mesActual, longitudPacientesMasUno, numeroAleatorio);
        return idPaciente;

    }

    public Paciente obtenerPacientePorId(String idPaciente) {
        Paciente paciente = listaPacientes.stream().filter(p -> p.getId().equals(idPaciente)).findFirst().orElse(null);
        return paciente;
    }


    public void mostrarPacientePorId(String idPaciente) {
        Paciente paciente= obtenerPacientePorId(idPaciente);
        if(paciente != null){
            System.out.println(paciente.mostrarDatos());
        }else {
            System.out.println("Paciente no encontrado");
        }
    }

    // MEDICOS
    public Medico obtenerMedicoPorId(String idMedico) {
        Medico medico=listaMedicos.stream().filter(m -> m.getId().equals(idMedico)).findFirst().orElse(null);
        return medico;
    }
    public String generarIDMedico(Medico medico) {
        String anioCadena = String.valueOf(medico.getFechaNacimiento());
        LocalDate fecha = LocalDate.now();
        int anoActual = fecha.getYear();
        Random random = new Random();
        int numeroAleatorio = new Random().nextInt(700000 - 50)+50;
        int longitudMedicosMasUno = this.listaMedicos.size() + 1;
        char ultimoDigitoNacimiento = anioCadena.charAt(7);
        String primerasLetrasApellido = medico.apellidos.substring(0, 2).toUpperCase();
        String id = String.format("M%s%c%d%d%d", primerasLetrasApellido, ultimoDigitoNacimiento, anoActual, numeroAleatorio, longitudMedicosMasUno);
        return id;

    }

    public void mostrarMedicoPorID(String id) {
        Medico medico = obtenerMedicoPorId(id);
        if (medico != null) {
            System.out.println(medico.mostrarDatos());
        }else{
            System.out.println("Medico no encontrado");
        }
    }

    //CONSULTORIOS
    public Consultorio obtenerConsultorioPorId(String idConsultorio) {
        Consultorio consultorio=listaConsultorios.stream().filter(c -> c.getId().equals(idConsultorio)).findFirst().orElse(null);
        return consultorio;
    }
    public String generarIDConsultorio(Consultorio consultorio){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1, 500000);
        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int longitudConsultoriosMasUno = this.listaConsultorios.size() + 1;
        String id= String.format("C%d%d%d%d", longitudConsultoriosMasUno, diaActual, anoActual, numeroAleatorio);
        return id;

    }
    public void mostrarConsultorioPorID(String id) {

        Consultorio consultorio= obtenerConsultorioPorId(id);
        if (consultorio != null) {
            System.out.println(consultorio.mostrarDatos());
        }else{
            System.out.println("Consultorio no encontrado");
        }
    }

    public String generarIDConsulta(Consulta consulta){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(1, 500000);
        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int anoActual = fecha.getYear();
        int longitudConsultoriosMasUno = this.listaConsultorios.size() + 1;
        String id= String.format("CS%d%d%d%d", longitudConsultoriosMasUno, diaActual, anoActual, numeroAleatorio);
        return id;

}
}