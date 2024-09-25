package ejercicioHospital.hospital;

import ejercicioHospital.consultas.Consulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ValidadorHospital {
    public boolean validarDisponibilidadMedico(LocalDateTime FechaDeseada, String idMedico, ArrayList<Consulta> listaConsultas) {
        for(Consulta consulta : listaConsultas) {
            if(consulta.getFechaHora().isEqual(FechaDeseada)&&consulta.getMedico().getId().equals(idMedico)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarDispolnibilidadEnFechaConsulta(LocalDateTime FechaDeseada, int numeroConsultorio, ArrayList<Consulta> listaConsultas) {
        for(Consulta consulta : listaConsultas) {
            if(consulta.getFechaHora().isEqual(FechaDeseada) && numeroConsultorio==consulta.getConsultorio().getNumeroConsultorio()) {
                return false;
            }
        }
        return true;
    }
}
