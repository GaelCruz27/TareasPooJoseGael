package ejercicioHospital.consultas;

import ejercicioHospital.consultorio.Consultorio;
import ejercicioHospital.medicos.Medico;
import ejercicioHospital.pacientes.Paciente;

import java.time.LocalDateTime;

public class Consulta {
    public int id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(int id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }
    public String mostrarDatos() {
        String datos = String.format("Id: %s, Fecha y Hota: : %s, Paciente %s, Medico: %s, Consultotio %s",
                id,
                fechaHora,
                paciente,
                medico,
                consultorio);
        return datos;
    }
    public int getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }
}