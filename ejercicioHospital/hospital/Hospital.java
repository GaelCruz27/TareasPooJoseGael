package ejercicioHospital.hospital;

import ejercicioHospital.consultorio.Consultorio;
import ejercicioHospital.medicos.Medico;
import ejercicioHospital.pacientes.Paciente;
import ejercicioHospital.consultas.Consulta;
import java.util.ArrayList;

public class Hospital {
    public ArrayList<Paciente> listaPacientes = new ArrayList<>();
    public ArrayList<Medico> listaMedico = new ArrayList<>();
    public ArrayList<Consulta> listaConsultas = new ArrayList<>();
    public ArrayList<Consultorio> listaConsultorio = new ArrayList<>();

    public void registrarPaciente (Paciente paciente){
        this.listaPacientes.add(paciente);

    }
    public void registrarMedico (Medico medico){
        this.listaMedico.add(medico);
    }
    public void registrarConsultorio (Consultorio consultorio){

        this.listaConsultorio.add(consultorio);
    }

    public void registrarConsulta (Consulta consulta){

        if(!validarDisponibilidadFechaConsulta(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio())){
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

    }
    private boolean validarDisponibilidadFechaConsulta(String fechaDeseada, int numeroConsultorio){

        for(Consulta consulta : this.listaConsultas){
            if(consulta.fechaHora.equals(fechaDeseada) && numeroConsultorio == consulta.getConsultorio().getNumeroConsultorio()){
                return false;
            }

        }
        return true;
    }

    private boolean validarDisponibilidadPaciente(int idPaciente, String fechaDeseada){

        for(Consulta consulta : this.listaConsultas){
            if(consulta.getFechaHora().equals(fechaDeseada)){
                return false;
            }

        }
        return true;
    }

}